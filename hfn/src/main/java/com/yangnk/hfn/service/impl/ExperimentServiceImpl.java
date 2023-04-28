package com.yangnk.hfn.service.impl;

import com.alibaba.fastjson.JSON;
import com.yangnk.hfn.pojo.bo.ExperimentInfo;
import com.yangnk.hfn.service.ExperimentService;
import com.yangnk.hfn.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2022-05-08 15:29
 **/
@Slf4j
@Service
public class ExperimentServiceImpl implements ExperimentService {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Autowired
    JedisPool jedisPool;

    @Autowired
    RedissonClient redissonClient;

    public void send(ExperimentInfo experimentInfo) {
        String experimentJsonString = JSON.toJSONString(experimentInfo);
        rabbitTemplate.convertAndSend("hfn_exchange", "hfn_routekey", experimentJsonString);
        log.info("=================ExperimentService.send():{}================", experimentJsonString);
    }

    @Override
    public void useGPUVm() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5, 30,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(1));
        for (int i = 0; i < 5; i++) {
            executor.execute(() -> {
                Jedis jedis = jedisPool.getResource();
                String GPULock = "GPULock";
                String threadName = Thread.currentThread().getName();
                boolean bool = RedisUtil.setnxLock(jedis, GPULock, threadName, 30);

                //加锁状态，其他线程还在操作GPU数量，需要等待
                while (bool == false) {
                    log.info("===wait threadName:{},time:{}====", Thread.currentThread(), System.currentTimeMillis());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    bool = RedisUtil.setnxLock(jedis, GPULock, threadName, 30);
                }

                log.info("===worker threadName:{}====", Thread.currentThread());
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    //判断redis中是否是自己线程的锁，避免把别人的锁释放掉
                    if (RedisUtil.getValue(jedis, GPULock).equals(Thread.currentThread())) {
                        RedisUtil.delValue(jedis, GPULock);
                    }
                }
            });
    }
}

    @Override
    public void useGPUVm1() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5, 30,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(1));

        for (int i = 0; i < 5; i++) {
            executor.execute(() -> {
                RLock lock = redissonClient.getLock("GPULock");
                // 加锁以后10秒钟自动解锁,无需调用unlock方法手动解锁
                lock.lock(15, TimeUnit.SECONDS);

                boolean res = false;
                try {
                    // 尝试加锁，最多等待100秒，上锁以后15秒自动解锁
                    res = lock.tryLock(100, 15, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
//                        e.printStackTrace();
                }
                if (res) {
                    try {
                        for (int j = 0; j < 5; j++) {
                            log.info("===worker threadName:{},j:{}====", Thread.currentThread(), j);
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
//                                    e.printStackTrace();
                            }
                        }
                    } finally {
                        lock.unlock();
                    }
                }
            });
        }
    }
}
