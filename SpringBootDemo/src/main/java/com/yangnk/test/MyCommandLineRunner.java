package com.yangnk.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
public class MyCommandLineRunner implements CommandLineRunner {

    @Override
    public void run(String... args) {

        log.info("================={}===================",new Date());
        log.info("......MyCommandLineRunner.MyCommandLineRunner()......");
        log.info("================={}===================",new Date());

        // Do something...
    }

}


