package com.yangnk.mysqldemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.yangnk.mysqldemo")
public class MysqlDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MysqlDemoApplication.class, args);
	}

}
