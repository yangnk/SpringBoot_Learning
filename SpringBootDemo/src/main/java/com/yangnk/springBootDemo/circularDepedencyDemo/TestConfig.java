package com.yangnk.springBootDemo.circularDepedencyDemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2022-03-04 22:38
 **/
@Configuration
@ComponentScan(basePackages = { "com.yangnk.springBootDemo.circularDepedencyDemo" })
public class TestConfig {
}
