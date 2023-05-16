package com.yangnk.simpleMQv2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.text.MessageFormat;

@Slf4j
@Configuration
public class RabbitConfig {

    @Value("${spring.rabbitmq.host}")
    private String host;

    @Value("${spring.rabbitmq.port}")
    private int port;

    @Value("${spring.rabbitmq.username}")
    private String username;

    @Value("${spring.rabbitmq.password}")
    private String password;

    @Value("${spring.rabbitmq.virtual-host}")
    private String virtualhost;

    @Autowired
    CachingConnectionFactory cachingConnectionFactory;

    @Bean
    RabbitTemplate rabbitTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(cachingConnectionFactory);
        // 消息只要被 rabbitmq broker 接收到就会执行 confirmCallback
        // 如果是 cluster 模式，需要所有 broker 接收到才会调用 confirmCallback
        // 被 broker 接收到只能表示 message 已经到达服务器，并不能保证消息一定会被投递到目标 queue 里
        rabbitTemplate.setConfirmCallback((data, ack, cause) -> {
            String msgId = data.getId();
            if (ack) {
                log.info(msgId + ": 消息发送成功");
            } else {
                log.info(msgId + ": 消息发送失败");
            }
        });

        // confirm 模式只能保证消息到达 broker，不能保证消息准确投递到目标 queue 里。
        // 在有些业务场景下，我们需要保证消息一定要投递到目标 queue 里，此时就需要用到 return 退回模式
        // 这样如果未能投递到目标 queue 里将调用 returnCallback，可以记录下详细到投递数据，定期的巡检或者自动纠错都需要这些数据
        rabbitTemplate.setReturnCallback((message, replyCode, replyText, exchange, routingKey) -> {
            log.info(MessageFormat.format("消息发送失败，ReturnCallback:{0},{1},{2},{3},{4},{5}", message, replyCode,
                    replyText, exchange, routingKey));
        // TODO 做消息发送失败时的处理逻辑
        });
        return rabbitTemplate;
    }

    @Bean
    Queue myQueue() {
        return new Queue("queuev2", true);
    }

    @Bean
    DirectExchange myExchange() {
        return new DirectExchange("exchangev2", true, false);
    }

    @Bean
    Binding queueBinding() {
        return BindingBuilder.bind(myQueue()).to(myExchange()).with("routingKeyv2");
    }
}

