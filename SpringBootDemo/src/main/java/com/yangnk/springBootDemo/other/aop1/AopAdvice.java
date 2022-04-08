package com.yangnk.springBootDemo.aop1;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2022-03-04 16:27
 **/
@Aspect
@Component
public class AopAdvice {

    @Pointcut("execution (* com.yangnk.springBootDemo.controller1.*.*(..))")
    public void test() {

    }
//
//    @Before("test()")
//    public void beforeAdvice() {
//        System.out.println("============================");
//        System.out.println("beforeAdvice...");
//        System.out.println("============================");
//    }

    @Around("test()")
    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String name = proceedingJoinPoint.getSignature().getName();
        System.out.println("============================");
        System.out.println(name);
        System.out.println("============================");
        Object[] args = proceedingJoinPoint.getArgs();
        args[0] = "test";
        return proceedingJoinPoint.proceed(args);

//        String[] args = (String[])proceedingJoinPoint.getArgs();
//        args[0] = "test";
//        return proceedingJoinPoint.proceed(args);
    }
}
