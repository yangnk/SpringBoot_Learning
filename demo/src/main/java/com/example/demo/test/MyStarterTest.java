package com.example.demo.test;

import com.yangnk.threadpoolstarter.myStarter.MyStarterConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2022-04-29 14:37
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class MyStarterTest {

    @Autowired
    private MyStarterConfig myStarterConfig;

    @Test
    public void testMyStarter(){
        String name = myStarterConfig.getName();
        System.out.println(name);
    }
}
