package com.yangnk;

import com.yangnk.test.ApplicationStartedEventListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SpringDemoApplication {

    public static void main(String[] args) {
//        SpringApplication.run(SpringDemoApplication.class, args);

        SpringApplication app = new SpringApplication(SpringDemoApplication.class);
        app.addListeners(new ApplicationStartedEventListener());
        app.run(args);
    }

}
