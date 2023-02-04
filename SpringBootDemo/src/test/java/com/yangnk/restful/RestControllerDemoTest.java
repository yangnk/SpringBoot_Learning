package com.yangnk.restful;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class RestControllerDemoTest {

    @Autowired
    RestControllerDemo restControllerDemo;

    @Autowired
    private RestTemplate restTemplate;

    @Test
    void getTest() {
        String str = restTemplate.getForObject("http://127.0.0.1:8081/get?name=aaa", String.class);
        System.out.println(str);
    }

}