package com.yangnk.rabbimqv3.rabbitMQ;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import com.rabbitmq.client.Channel;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Slf4j
@Service
public class ConsumerService {

    @RabbitListener(queues = {"queuev3"}, containerFactory = "customContainerFactory")
    public void handler(Message message, Channel channel) throws IOException, InterruptedException {
        channel.basicQos(1);
        String string = message.getPayload().toString();
        log.info("==========message.getBody().toString():{}=========",string);
        channel.basicAck((Long) (message.getHeaders().get(AmqpHeaders.DELIVERY_TAG)), false);
    }
}
