package com.yangnk.aopExample;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class MyController {

    @RequestMapping("/hello")
    public String printDate() {
        return new Date().toString();
    }
}
