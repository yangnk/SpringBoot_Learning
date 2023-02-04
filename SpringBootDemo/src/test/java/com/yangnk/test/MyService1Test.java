package com.yangnk.test;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Async;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@RunWith(Runner.class)
class MyService1Test {
    @Autowired
    MyService1 myService1;

    @Test
    public void runTest() {
        myService1.run();

    }


}