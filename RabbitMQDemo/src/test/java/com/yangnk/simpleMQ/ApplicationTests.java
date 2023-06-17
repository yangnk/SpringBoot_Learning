package com.yangnk.simpleMQ;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private Sender helloSender;

    @Test
    public void send() throws Exception {
        while (true) {
            Thread.sleep(3000);
            helloSender.send();
        }
    }

    @Test
    public void send1() throws Exception {
        while (true) {
            Thread.sleep(3000);
            helloSender.sendMsg("website_normal_exchange", "website_normal_routing_key",
                    "test-" + new Date());
        }
    }
}