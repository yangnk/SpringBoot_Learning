package com.yangnk.hfn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yangnk.hfn.dao")
public class HfnApplication {

	public static void main(String[] args) {
		SpringApplication.run(HfnApplication.class, args);
	}

}
