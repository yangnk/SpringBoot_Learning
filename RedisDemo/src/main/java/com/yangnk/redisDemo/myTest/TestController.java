package com.yangnk.redisDemo.myTest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2022-05-13 15:40
 **/

@RestController
public class TestController {
    @GetMapping("/test")
    public String index() {
        return "index";
    }
}