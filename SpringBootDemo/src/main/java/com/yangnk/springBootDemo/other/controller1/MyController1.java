package com.yangnk.springBootDemo.controller1;


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

    @RequestMapping("/hello1")
    public String sayHello(String string){
        System.out.println("hello1");
        System.out.println(string);
        return "hello1";
    }
}

