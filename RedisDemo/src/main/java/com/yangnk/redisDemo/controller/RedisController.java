package com.yangnk.redisDemo.controller;

import com.yangnk.redisDemo.annotation.RedisLock;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2022-05-13 20:37
 **/
@RestController
public class RedisController {

    @RedisLock(key = "lock", expire = 20)
    @GetMapping("/test1")
    public String index() {
        return "test1";
    }
}
