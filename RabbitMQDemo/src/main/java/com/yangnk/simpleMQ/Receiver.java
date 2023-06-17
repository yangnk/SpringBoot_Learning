package com.yangnk.simpleMQ;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
public class Receiver {

    @RabbitHandler
    @RabbitListener(queues = "hello")
    public void process(String hello) {
        log.info("==============receive:{}===================", hello);
    }

    // 消费普通消息
    @RabbitListener(queues = {"website_normal_queue"})
    @RabbitHandler
    public void process1(String content, Message message, Channel channel) throws IOException {
        try {
            log.info("普通队列的内容[{}]", content);
            // 消息的可定确认，第二个参数如果为true将一次性确认所有小于deliveryTag的消息
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            log.info("普通信息处理完毕");
        } catch (Exception e) {
            log.error("处理失败:{}", e.getMessage());
            // 直接拒绝消费该消息，后面的参数一定要是false，否则会重新进入业务队列，不会进入死信队列
            channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
        }
    }
}