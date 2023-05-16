package com.yangnk.simpleMQv3;

import com.rabbitmq.client.ConnectionFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue helloQueue() {
        return new Queue("queue1");
    }

    @Bean
    public ConnectionFactory connectionFactory() throws Exception {
        ConnectionFactory connectionFactory = new ConnectionFactory();
//        connectionFactory.setHost(env.getProperty("mq.host").trim());
//        connectionFactory.setPort(Integer.parseInt(env.getProperty("mq.port").trim()));
//        connectionFactory.setVirtualHost(env.getProperty("mq.vhost").trim());
//        connectionFactory.setUsername(env.getProperty("mq.username").trim());
//        connectionFactory.setPassword(env.getProperty("mq.password").trim());
        return connectionFactory;
    }
}
