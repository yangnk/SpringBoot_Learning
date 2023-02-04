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
        String url = "https://portal.ceni.org.cn/auth/getToken";
        String result = httpService.doPost(url);
        LOGGER.info("=== sayHello.result ==== " + result);
        return (new Date()).toString() + " ---0130.2.--- " + result;
    }
}
