package com.yangnk.springboothttpclient.httpclientService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Date;

@RestController
public class MyController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyController.class);

    public MyController() {
    }

    @RequestMapping({"/hello"})
    public String sayHello() throws IOException {
        HttpService httpService = new HttpService();
        String url = "https://www.baidu.com";
//        String url = "http://127.0.0.1:9000/hello1";
        String result = httpService.doGet(url);
        LOGGER.info("=== sayHello.result ==== " + result);
        return (new Date()).toString() + " ---0130.2.--- " + result;
    }
}
