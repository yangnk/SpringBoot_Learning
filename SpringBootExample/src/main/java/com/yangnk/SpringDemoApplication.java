package com.yangnk;

import com.yangnk.springExtend.ApplicationContextInitializer1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SpringDemoApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SpringDemoApplication.class);
        // 方法一：添加自定义的 ApplicationContextInitializer 实现类的实例(注册ApplicationContextInitializer)
        app.addInitializers(new ApplicationContextInitializer1());
        app.run(args);
    }

}
