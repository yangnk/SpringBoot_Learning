package com.yangnk.test;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MyTest{



    @Value("${testKey}")
    String string;
    static String stringStatic;

    @PostConstruct
    public void init() {
        stringStatic = string;
    }


//    @Value("${testKey}")
//    public void setStringStatic(String stringStatic) {
//        MyTest.stringStatic = stringStatic;
//    }


    public static String getStringStatic() {
        return stringStatic;
    }

//    @Override
//    public void afterPropertiesSet(){
//        stringStatic = string;
//    }
}

