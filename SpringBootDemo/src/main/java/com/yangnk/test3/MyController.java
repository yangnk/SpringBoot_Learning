package com.yangnk.test3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    MyService myService;

    @RequestMapping("/test")
    String test() {
        String name = myService.getName("yangnk");
        return name;
    }


}
