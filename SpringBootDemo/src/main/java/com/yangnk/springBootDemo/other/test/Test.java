//package com.yangnk.springBootDemo.test;
//
//import cn.hutool.extra.mail.MailUtil;
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.*;
//import org.springframework.context.annotation.Lazy;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//import javax.annotation.PreDestroy;
//import java.util.HashMap;
//
///**
// * ${DESCRIPTION}
// *
// * @author yangningkai
// * @create 2022-01-25 19:42
// **/
//@Component
//public class ThreadPoolTest implements InitializingBean, DisposableBean, BeanNameAware,BeanFactoryAware {
//
//
//    //1、bean实例的处理
//    @PostConstruct
//    public void init() {
//        System.out.println("================init()===================");
//    }
//
//    //1、bean实例的处理
//    @PreDestroy
//    @Lazy
//    public void preDestroy() {
//        System.out.println("================preDestroy()===================");
//    }
//
//    //2、bean级别的生命周期处理
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        System.out.println("================afterPropertiesSet()===================");
//    }
//
//    //2、bean级别的生命周期处理
//    @Override
//    public void destroy() throws Exception {
//        System.out.println("================destroy()===================");
//    }
//
//    @Override
//    public void setBeanName(String s) {
//        System.out.println("================setBeanName()===================");
//        System.out.println(s);
//        System.out.println("================setBeanName()===================");
//    }
//
//    @Override
//    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
//        System.out.println("================setBeanFactory()===================");
//        System.out.println(beanFactory.toString());
//        System.out.println("================setBeanFactory()===================");
//    }
//}
