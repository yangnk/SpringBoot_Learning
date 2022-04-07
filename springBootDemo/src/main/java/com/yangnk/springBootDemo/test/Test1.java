//package com.yangnk.springBootDemo.test;
//
//import org.springframework.beans.factory.DisposableBean;
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.context.annotation.Lazy;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//import javax.annotation.PreDestroy;
//
///**
// * ${DESCRIPTION}
// *
// * @author yangningkai
// * @create 2022-01-25 19:42
// **/
//@Component
//public class Test1 implements InitializingBean, DisposableBean{
//
//    @PostConstruct
//    public void init() {
//        System.out.println("================init1()===================");
//    }
//
//    @PreDestroy
//    @Lazy
//    public void preDestroy() {
//        System.out.println("================preDestroy1()===================");
//    }
//
//
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        System.out.println("================afterPropertiesSet1()===================");
//    }
//
//    @Override
//    public void destroy() throws Exception {
//        System.out.println("================destroy1()===================");
//    }
//}
