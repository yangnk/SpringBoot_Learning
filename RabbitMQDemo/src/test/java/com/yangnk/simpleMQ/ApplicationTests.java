package com.yangnk.simpleMQ;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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

//    @Test
//    public void receiver() throws Exception {
//        while (true) {
//            Thread.sleep(3000);
//            helloReceiver.process("hello");
//        }
//    }
}