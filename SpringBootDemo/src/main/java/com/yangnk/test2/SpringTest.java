package com.yangnk.test2;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
//public class SpringTest implements ApplicationContextAware, BeanPostProcessor {
public class SpringTest implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(">>>>>>>>>>>>>>>>>afterPropertiesSet>>>>>>>>>>>>>>");
    }

//    @Override
//    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println(">>>>>>>>>>>>>bean = " + bean);
//        return bean;
//    }

//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        String name = applicationContext.getApplicationName();
//        System.out.println(">>>>>>>>>>>>>>>>>>name = " + name);
//    }
}
