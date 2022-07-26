package com.yangnk.springBootExample.other.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2022-03-04 16:10
 **/
@RestController
 public class MyController {

    @Value("${testValue.one}")
    int testValue;

    @Autowired
    Student student;

    @RequestMapping("/hello")
    public String sayHello() {
        System.out.println("hello");
        return student.toString();
    }
}

