package com.yangnk.webSocketExample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDemo10Application {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SpringDemo10Application.class);
        app.run(args);
    }
}
