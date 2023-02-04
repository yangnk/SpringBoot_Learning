package com.yangnk.kafkademo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class KafkaTests {

    @Autowired
    HelloWorldProducer producer;

    // 消费者：先启动 kafkaApp
    @Test
    void testSendMsg() throws InterruptedException {
        long time = System.currentTimeMillis();
        System.out.println("----"+time +"，已经发出----");
        producer.send("0825, " +time);
    }
}