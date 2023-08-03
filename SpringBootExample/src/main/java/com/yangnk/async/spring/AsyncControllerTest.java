package com.yangnk.async.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsyncControllerTest {

    @Autowired
    private AsyncService asyncService;

    @RequestMapping("/hello")
    public String index() {

        asyncService.sendSms("a", "b", "c", "d");
        return "Hello World.";
    }

}
