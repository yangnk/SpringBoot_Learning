package com.yangnk.rabbimqv3.rabbitMQ;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@Slf4j
public class ProducerController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @RequestMapping("/testmq")
    public String sendMessage(@RequestParam String message) throws InterruptedException {
        Map<String, String> map = null;
        for (int i = 0; i <= 10000; i++) {
            String msgId = UUID.randomUUID().toString();
            String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-mm-dd hh:mm:ss"));
            log.info("===========date:{}=============", date);
            map = new HashMap<>();
            map.put("msgId", msgId);
            map.put("date", date);
            map.put("message", message);
            rabbitTemplate.convertAndSend("exchangev3", "routingKeyv3", map, new CorrelationData(msgId));
            Thread.sleep(3000);
        }
        return map == null ? "" : map.toString();
    }
}
