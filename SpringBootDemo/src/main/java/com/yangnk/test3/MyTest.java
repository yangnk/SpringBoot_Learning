//package com.yangnk.test3;
//
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.config.BeanPostProcessor;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//
//@Component
////@Qualifier("myTest")
//public class MyTest implements InitializingBean, BeanPostProcessor {
//
//    public MyTest() {
//        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>111");
//    }
//
//    @PostConstruct
//    public void post() {
//        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>222");
//    }
//
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>333");
//    }
//
//    @Override
//    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println(">>>>>>>>>>>>>>>>>"+beanName);
////        System.out.println(">>>>>>>>>>>>>>>>>" + bean.toString());
//        if (beanName.equals("myTest")) {
//            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>444");
//        }
//        return bean;
//    }
//}
