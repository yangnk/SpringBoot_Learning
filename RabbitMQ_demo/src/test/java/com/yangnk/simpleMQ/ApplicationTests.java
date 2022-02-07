package com.yangnk.simpleMQ;

import com.yangnk.simpleMQ.Sender;
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

    @Autowired
    private Receiver helloReceiver;

    @Test
    public void hello() throws Exception {
        while (true) {
            helloSender.send();
        }
    }

    @Test
    public void receiver() throws Exception {
        while (true) {
            helloReceiver.process("hello");
        }
    }
}