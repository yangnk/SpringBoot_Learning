package com.yangnk.async.spring;

import com.yangnk.async.spring.subPub.ApplicationListenerTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SpringDemo1Application {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(SpringDemo1Application.class);
        //需要把监听器加入到spring容器中
        application.addListeners(new ApplicationListenerTest());
//        Set<ApplicationListener<?>> listeners = application.getListeners();
        ConfigurableApplicationContext context =  application.run(args);
        //发布事件
//        context.publishEvent(new ApplicationEventTest(new Object()));


//        context.close();
    }

}
