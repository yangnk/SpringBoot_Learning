package com.yangnk.simpleMQ;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class RabbitConfig {

    @Bean
    public Queue helloQueue() {
        return new Queue("hello");
    }


    // ------------------------普通队列 start------------------------
    // 普通队列
    @Bean
    public Queue normalQueue() {
        return new Queue(MqConstant.MQ_WEBSITE_NORMAL_QUEUE, true);
    }

    // 普通交换机
    @Bean
    public DirectExchange normalExchange() {
        return new DirectExchange(MqConstant.MQ_WEBSITE_NORMAL_EXCHANGE, true, false);
    }

    // 绑定普通消息队列
    @Bean
    public Binding normalBind() {
        return BindingBuilder.bind(normalQueue()).to(normalExchange()).with(MqConstant.MQ_WEBSITE_NORMAL_ROUTING_KEY);
    }

//    // 定义消息转换器
//    @Bean
//    public Jackson2JsonMessageConverter jsonMessageConverter() {
//        return new Jackson2JsonMessageConverter();
//    }
    // ------------------------普通队列 end------------------------

//  解决SpringBoot后端项目中的Idea 报错：Could not autowire,no beans of “XXX“ type found
//    https://blog.csdn.net/weixin_51484460/article/details/129449418
    @Bean("defaultRabbitConnectionFactory")
    @Primary
    public ConnectionFactory defaultRabbitConnectionFactory(RabbitProperties rabbitProperties){
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory();
        cachingConnectionFactory.setHost(rabbitProperties.getHost());
        cachingConnectionFactory.setPort(rabbitProperties.getPort());
        cachingConnectionFactory.setUsername(rabbitProperties.getUsername());
        cachingConnectionFactory.setPassword(rabbitProperties.getPassword());
        cachingConnectionFactory.setVirtualHost("vhost");
        cachingConnectionFactory.setCacheMode(rabbitProperties.getCache().getConnection().getMode());
        // 配置发送确认回调时，次配置必须配置，否则即使在RabbitTemplate配置了ConfirmCallback也不会生效
        cachingConnectionFactory.setPublisherConfirmType(rabbitProperties.getPublisherConfirmType());
        return cachingConnectionFactory;
    }

    /** ======================== 定制一些处理策略 =============================*/
    /**
     * 定制化amqp模版
     * <p>
     * Rabbit MQ的消息确认有两种。
     * <p>
     * 一种是消息发送确认：这种是用来确认生产者将消息发送给交换机，交换机传递给队列过程中，消息是否成功投递。
     * 发送确认分两步：一是确认是否到达交换机，二是确认是否到达队列
     * <p>
     * 第二种是消费接收确认：这种是确认消费者是否成功消费了队列中的消息。
     * Springboot中使用ConfirmCallback和ReturnCallback
     * 注意：
     *  在需要使用消息的return机制时候，mandatory参数必须设置为true
     * 新版本开启消息的confirm配置publisher-confirms已经过时，改为使用publisher-confirm-type参数设置（correlated:开启;NONE:关闭）
     */
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        rabbitTemplate.setConnectionFactory(connectionFactory);
//        设置开启Mandatory才能触发回调函数，无论消息推送结果怎么样都强制调用回调函数
        rabbitTemplate.setMandatory(true);
        /**
         * 使用该功能需要开启消息确认 无论成功与否，需要配置 publisher-confirms: true
         * 通过实现ConfirmCallBack接口，用于实现消息发送到交换机Exchange后接收ack回调
         * correlationData  消息唯一标志
         * ack              确认结果
         * cause            失败原因
         */
        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
            log.info("ConfirmCallback：" + "相关数据：" + correlationData);
            log.info("ConfirmCallback：" + "确认情况：" + ack);
            log.info("ConfirmCallback：" + "原因：" + cause);
        });
        /**
         * 消息从Exchange路由到Queue失败的回调
         * 使用该功能需要开启消息返回确认，需要配置 publisher-returns: true
         * 通过实现ReturnCallback接口，如果消息从交换机发送到对应队列失败时触发
         * message    消息主体 message
         * replyCode  消息主体 message
         * replyText  描述
         * exchange   消息使用的交换机
         * routingKey 消息使用的路由键
         */
        rabbitTemplate.setReturnCallback((message, replyCode, replyText, exchange, routingKey) -> {
            log.info("ReturnCallback：" + "消息：" + message);
            log.info("ReturnCallback：" + "回应码：" + replyCode);
            log.info("ReturnCallback：" + "回应信息：" + replyText);
            log.info("ReturnCallback：" + "交换机：" + exchange);
            log.info("ReturnCallback：" + "路由键：" + routingKey);
        });
        return rabbitTemplate;
    }

}
