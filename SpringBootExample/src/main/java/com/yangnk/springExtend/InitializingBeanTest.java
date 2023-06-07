package com.yangnk.springExtend;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component("initializingBeanTest")
@Order(value = 1)
public class InitializingBeanTest implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        //属性注入后进行处理
        System.out.println(">>>>>>>>>>>InitializingBeanTest.afterPropertiesSet（）");

    }

    @PostConstruct
    void testPostConstruct() {
        System.out.println(">>>>>>>>>>>>InitializingBeanTest.testPostConstruct（）");
    }
}
