package com.yangnk.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;

@RestController
public class ControllerTest {

    @Autowired
    Person person;

    @RequestMapping("/test")
    public String test() {
        return new Date().toString();
    }
}
