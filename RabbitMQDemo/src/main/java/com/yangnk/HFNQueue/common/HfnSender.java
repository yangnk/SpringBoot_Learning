package com.yangnk.HFNQueue.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
@Slf4j
public class HfnSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String context = "hello " + new Date();
        this.rabbitTemplate.convertAndSend("hfn_exchange", "hfn_routekey", context);
        log.info("=================Sender:{}================", context);
    }
}