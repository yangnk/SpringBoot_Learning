package com.yangnk.redisDemo.service;

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
    @Autowired
    RedisUtils redisUtils;
    @Autowired
    JedisPool jedisPool;

    void redisInvoke() {
        Jedis jedis = jedisPool.getResource();
        //循环创建20个线程，只有获得锁的线程才能成功创建
        for (int i = 0; i < 20; i++) {
            boolean lock = redisUtils.setnxLock(jedis, "lock", "1", 5);
            while (!lock) {
                lock = redisUtils.setnxLock(jedis, "lock", "1", 5);
            }
            new Thread(new MyTask()).start();
        }

    }
}

class MyTask implements Runnable {
    @Override
    public void run() {
        System.out.println("===============================");
        System.out.println(Thread.currentThread().getName() + ":" + new Date().toString());
        System.out.println("===============================");
    }
}
