package com.yangnk.quartzExample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SpringDemo2Application {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SpringDemo2Application.class);
        app.run(args);
    }

}
