package com.yangnk.springBootDemo.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2022-02-25 20:56
 **/
@RestController
public class TestController {
    @GetMapping("/test")
    public String test() {
        return "hello " + System.currentTimeMillis();
    }
}
