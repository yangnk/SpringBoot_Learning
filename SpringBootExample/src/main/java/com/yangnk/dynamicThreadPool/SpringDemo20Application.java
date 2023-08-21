package com.yangnk.dynamicThreadPool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDemo20Application {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SpringDemo20Application.class);
        app.run(args);
    }
}
