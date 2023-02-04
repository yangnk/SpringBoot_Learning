package com.yangnk.data;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan({"com.yangnk.data"})
@SpringBootApplication
public class HspApplication {

    public static void main(String[] args) {
        SpringApplication.run(HspApplication.class, args);
    }

}

