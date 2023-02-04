package com.yangnk.kafkademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2022-04-16 10:21
 **/
@RestController
public class HelloWorldProducer {
    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    @RequestMapping("/testkafka")
    public void send(@RequestParam String msg) throws InterruptedException {
        while (true) {
            kafkaTemplate.send("testTopic0825a", "key_" + new Date().toString(), "value_" + new Date().toString());

            System.out.println("new Date().toString() = " + new Date().toString());
            Thread.sleep(3000);
        }
    }
}
