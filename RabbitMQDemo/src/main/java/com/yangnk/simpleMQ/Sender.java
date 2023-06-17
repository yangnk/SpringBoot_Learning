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
        String messageContext = "hello, " + new Date();
        this.rabbitTemplate.convertAndSend("hello", messageContext);
        log.info("=================Sender:{}================", messageContext);
    }

    // 发送普通消息
    public void sendMsg(String exchange,String routingKey, String content) {
        // DirectExchange类型的交换机，必须指定对应的路由键
        rabbitTemplate.convertAndSend(exchange, routingKey, content);
        log.info("=================start sendMsg, exchange:{}, routingKey:{}, content:{}================",
                exchange, routingKey, content);
    }
}