package com.yangnk.springExtend;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value = 1)
public class BeanPostProcessorTest implements BeanPostProcessor {
    String name;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(">>>>>>>>>>>>>>BeanPostProcessorTest.postProcessBeforeInitialization()" + beanName);
        return bean;
    }
}
