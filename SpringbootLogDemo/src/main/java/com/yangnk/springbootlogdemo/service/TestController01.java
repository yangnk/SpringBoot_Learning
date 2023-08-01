package com.yangnk.springbootlogdemo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestController01 {

    @RequestMapping("/hello")
    public String index() {

        log.debug("hello world0.");
        log.info("hello world.");
        log.warn("hello world1.");
        log.error("hello world2.");
        return "Hello World.";
    }

}