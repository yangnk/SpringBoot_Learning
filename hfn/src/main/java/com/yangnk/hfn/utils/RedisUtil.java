package com.yangnk.hfn.utils;

import redis.clients.jedis.Jedis;

public class RedisUtil {

    /**
     * 获取redis中的值
     *
     * @param jedis
     * @param key
     * @return
     */
    public static String getValue(Jedis jedis, String key) {
        String s = jedis.get(key);
        return s;
    }

    /**
     * 给redis设值
     *
     * @param jedis
     * @param key
     * @param value
     * @return
     */
    public static boolean setValue(Jedis jedis, String key, String value) {
        try {
            jedis.set(key, value);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 删除redis中的值
     *
     * @param jedis
     * @param key
     * @return
     */
    public static boolean delValue(Jedis jedis, String key) {
        try {
            jedis.del(key);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    /**
     * @desc 通过setnx+expire实现redis分布式锁
     * @return true：加锁成功；false：加锁失败
     */
    public static boolean setnxLock(Jedis jedis, String key, String value, int timeout) {
        Long flag = jedis.setnx(key, value);
        if (flag == 1) {
            jedis.expire(key, timeout);
        } else {
            return false;
        }
        return true;
    }

    public static boolean acquireLock(Jedis jedis, String key, String value, long timeout, long processTime) {

        try {
            // 使用SETNX 互斥命令 设置 key值，如果设置成功了，返回1
            // 并且 设置超时时间， 为锁的最大处理时间, 设置成功也返回1
            StringBuilder sb = new StringBuilder()
                    .append("if (redis.call('SETNX', KEYS[1], ARGV[1]) == 1) then    ")
                    .append("return redis.call('expire', KEYS[1], ARGV[2])           ")
                    .append("else                                                    ")
                    .append("return 0                                                ")
                    .append("end                                                     ");
            // 转换为 EVALSHA 命令执行
            String sha1 = jedis.scriptLoad(sb.toString());

            // 获取锁的最后时间, 否则则超时获取不到
            long endTime = System.currentTimeMillis() + timeout;

            // 当前时间 小于获取的超时时间，可以持续获取
            while (System.currentTimeMillis() < endTime) {

                Long result = (Long) jedis.evalsha(sha1, 1, key, value, String.valueOf(processTime));
                if (result == 1) return true;
                // 这里说明没有获取到锁，休眠一会，继续循环
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return false;
    }

    /**
     * 释放锁， 就是删除 这个锁的key
     */
    public static void releaseLock(Jedis jedis, String key) {
        try {
            jedis.del(key);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }
}
