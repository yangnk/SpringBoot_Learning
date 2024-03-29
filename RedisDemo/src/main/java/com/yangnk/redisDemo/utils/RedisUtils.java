package com.yangnk.redisDemo.utils;

import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2022-05-13 15:48
 **/
@Component
public class RedisUtils {

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
}
