package com.yangnk.redisDemo.annotation;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2022-05-13 20:05
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface RedisLock {
    String key();
    int expire() default 5;
    long waitTime() default Long.MIN_VALUE;
    TimeUnit timeUnit() default TimeUnit.SECONDS;

}
