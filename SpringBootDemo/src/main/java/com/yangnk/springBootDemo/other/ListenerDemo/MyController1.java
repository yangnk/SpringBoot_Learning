package com.yangnk.springBootDemo.ListenerDemo;


import javafx.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2022-03-04 16:10
 **/
@RestController
public class MyController1 {
    @Autowired
    ApplicationContext applicationContext;

    @RequestMapping("/hello1")
    public String sayHello() {
        BlackListEvent blackListEvent = new BlackListEvent(this, "hangzhou");
        applicationContext.publishEvent(blackListEvent);
        System.out.println("hello1");
        return "hello1";
    }
}

