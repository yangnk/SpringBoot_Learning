package com.yangnk.logindemo.MY_TEST;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2022-04-07 11:49
 **/
@RestController
public class MyHello {
    @RequestMapping("/myhello")
    public String sayHello(String string) {
        System.out.println("myhello");
        System.out.println(string);
        return "myhello";
    }
}
