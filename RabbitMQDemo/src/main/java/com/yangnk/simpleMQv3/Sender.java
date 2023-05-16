package com.yangnk.simpleMQv3;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeoutException;

@Slf4j
@RestController
public class Sender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Autowired
    ConnectionFactory connectionFactory;

    @RequestMapping("/send")
    public String send() throws IOException, TimeoutException, InterruptedException {
        String context = "hello," + new Date();
        this.rabbitTemplate.convertAndSend("queue1",context);

//        Connection connection = connectionFactory.newConnection();
//        Channel channel = connection.createChannel();
//        channel.confirmSelect();
//
//        channel.basicPublish("", "", null, context.getBytes());
//        boolean b = channel.waitForConfirms();
//        if (b == true) {
//            //todo 生产者发送成功
//        }

        log.info("=================send:{}================", context);
        return context;
    }
}
