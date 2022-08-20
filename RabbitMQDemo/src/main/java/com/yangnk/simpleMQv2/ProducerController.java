package com.yangnk.simpleMQv2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public String sendMessage(String message) {
        String msgId = UUID.randomUUID().toString();
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-mm-dd hh:mm:ss"));
        log.info("===========date:{}=============", date);
        Map<String, String> map = new HashMap<>();
        map.put("msgId", msgId);
        map.put("date", date);
        rabbitTemplate.convertAndSend("exchangev2", "routinngKeyv2", map, new CorrelationData(msgId));
        return map.toString();
    }
}
