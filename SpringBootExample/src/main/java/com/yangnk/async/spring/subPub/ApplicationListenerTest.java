package com.yangnk.async.spring.subPub;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import java.util.Date;

//自定义事件监听器
@Component
public class ApplicationListenerTest implements ApplicationListener<ApplicationEventTest> {

    @Override
    public void onApplicationEvent(ApplicationEventTest event) {

        event.printMsg(String.valueOf(new Date()));

    }
}
