package com.yangnk.simpleMQ;


import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
@Slf4j
public class Sender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String context = "hello" + new Date();
        this.rabbitTemplate.convertAndSend("hello", context);
        log.info("=================Sender:{}================", context);
    }
}