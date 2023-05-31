package com.yangnk.springbootserverdemo.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class MyController {

    @RequestMapping("/test")
    String test() {
        return new Date().toString()+", springboot Test";
    }
}
