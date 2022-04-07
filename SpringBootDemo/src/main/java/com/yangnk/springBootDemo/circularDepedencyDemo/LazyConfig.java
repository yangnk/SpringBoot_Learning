package com.yangnk.springBootDemo.circularDepedencyDemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2022-03-04 22:26
 **/
public class LazyConfig {
    @Bean
    @Lazy
    public Person person() {
        return new Person("李四", 55);
    }
}
