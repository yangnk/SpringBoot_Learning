package com.yangnk;

import com.yangnk.test.ApplicationStartedEventListener;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@RunWith(Runner.class)
//@TestPropertySource("classpath:appSource.properties")
public class SpringDemoApplicationTest {

    public static void main(String[] args) {
//        SpringApplication.run(SpringDemoApplication.class, args);
        SpringApplication app = new SpringApplication(SpringDemoApplicationTest.class);
//        app.addListeners(new ApplicationStartedEventListener());
        app.run(args);
    }

}
