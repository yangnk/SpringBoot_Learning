//package com.yangnk.springBootDemo.test;
//
//
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.config.BeanPostProcessor;
//import org.springframework.stereotype.Component;
//
///**
// * ${DESCRIPTION}
// *
// * @author yangningkai
// * @create 2022-02-25 15:00
// **/
//@Component
//public class MyPostBeanProcessor implements BeanPostProcessor {
//
//    //3、容器级别生命周期的处理
//    @Override
//    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//
//        System.out.println("===========postProcessBeforeInitialization()=============");
//        System.out.println(beanName);
//        System.out.println("===========postProcessBeforeInitialization()=============");
//        return bean;
//    }
//}
