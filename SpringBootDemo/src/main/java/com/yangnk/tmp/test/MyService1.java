package com.yangnk.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MyService1 {

    @Async
    public void run() {
        for (int i = 0; i < 3; i++) {
            log.info("111.==========i:{}, currentThreadName:{}===========", i, Thread.currentThread().getName());
        }
    }

    @Async
    public void mySleep() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
