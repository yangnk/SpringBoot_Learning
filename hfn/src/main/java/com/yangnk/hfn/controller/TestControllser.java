package com.yangnk.hfn.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;

@RestController
@RequestMapping(value = "/test")
@Slf4j
public class TestControllser {

    @GetMapping("/test")
    public String index() {
        return "test," + new Date().toString();
    }

}
