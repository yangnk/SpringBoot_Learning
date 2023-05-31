package com.yangnk.redisDemo.service.impl;

import com.yangnk.redisDemo.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Date;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2022-05-13 21:21
 **/
@Service
public class RedisService {
//    @Autowired
//    RedisUtils redisUtils;
    @Autowired
    JedisPool jedisPool;


    /**
     * 从redis中根据key获取value
     * @param key
     * @return
     */
    public String getValueByKey(String key) {
        Jedis jedis = jedisPool.getResource();
        String s = jedis.get(key);
        return s;
    }

    public void redisInvoke() {
        Jedis jedis = jedisPool.getResource();
        String lockKey = "lock";
        //循环创建20个线程，只有获得锁的线程才能成功创建
        for (int i = 0; i < 20; i++) {
            boolean lock = RedisUtils.setnxLock(jedis, lockKey, "1", 5);
            while (!lock) {
                lock = RedisUtils.setnxLock(jedis, lockKey, "1", 5);
            }
            new Thread(new MyTask(jedis, lockKey)).start();
        }
    }
}

class MyTask implements Runnable {
    Jedis jedis;
    String key;

    public MyTask(Jedis jedis, String key) {
        this.jedis = jedis;
        this.key = key;
    }

    @Override
    public void run() {
        System.out.println("===============================");
        System.out.println(Thread.currentThread().getName() + ":" + new Date().toString());
        System.out.println("===============================");
        RedisUtils.delValue(jedis, key);
    }
}
