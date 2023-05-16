package com.yangnk.simpleMQv3;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.core.Message;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RabbitListener(queues = "queue1")
@Slf4j
public class Receiver {
    @RabbitHandler
    public void process(Message message, Channel channel, String queue1) {
        log.info("==============receive:{}===================", queue1);

        try {
            channel.basicReject(message.getMessageProperties().getDeliveryTag(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
