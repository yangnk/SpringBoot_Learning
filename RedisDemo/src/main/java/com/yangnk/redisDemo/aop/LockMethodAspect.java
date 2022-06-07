package com.yangnk.redisDemo.aop;

import com.yangnk.redisDemo.annotation.RedisLock;
import com.yangnk.redisDemo.utils.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.lang.reflect.Method;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2022-05-13 20:07
 **/
@Aspect
@Component
@Slf4j
public class LockMethodAspect {
    @Autowired
    RedisUtils redisUtils;
    @Autowired
    JedisPool jedisPool;

    @Around("@annotation(com.yangnk.redisDemo.annotation.RedisLock)")
    public Object around(ProceedingJoinPoint joinPoint){
        log.info("LockMethodAspect.around()");
        //获取加注解的方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        RedisLock redisLock = method.getAnnotation(RedisLock.class);

        //判断是否加锁
        Jedis jedis = jedisPool.getResource();
        String key = redisLock.key();
        int expireTime = redisLock.expire();
        boolean lock = redisUtils.setnxLock(jedis, key, "1", expireTime);
        log.info("LockMethodAspect.lock:{}", lock);
        if (lock == false) {
            throw new RuntimeException("获取锁失败");
        }

        try {
            return joinPoint.proceed();
        } catch (Throwable throwable) {
            throw new RuntimeException("系统异常");
        }finally {
            jedis.close();
        }
    }
}
