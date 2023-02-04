package com.yangnk.ThreadPoolTest;

import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.junit.runner.Runner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2022-04-29 14:37
 **/
@SpringBootTest
@RunWith(SpringRunner.class)

public class ThreadPoolStartTest {

    @Autowired
    ThreadPoolExecutor threadPoolExecutor;

    @Test
    public void testThreadPoolStart() {
        System.out.println("===start===");
        System.out.println("threadPoolExecutor.getPoolSize() = " + threadPoolExecutor.getPoolSize());
        System.out.println("===end===");
//
//
//
//
//        String configLocation = "application-alias.xml";
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(configLocation);
//        System.out.println("    alias-hello -> " + applicationContext.getBean("alias-hello"));
//        System.out.println("double-alias-hello -> " + applicationContext.getBean("double-alias-hello"));
    }
}
