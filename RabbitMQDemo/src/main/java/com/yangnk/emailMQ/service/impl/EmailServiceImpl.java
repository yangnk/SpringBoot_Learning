package com.yangnk.emailMQ.service.impl;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2019-04-25 下午5:09
 **/
import com.yangnk.emailMQ.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
@Slf4j
public class EmailServiceImpl implements EmailService {
    @Resource( name = "rabbitTemplate" )
    private RabbitTemplate rabbitTemplate;

    @Value("${mq.exchange}")
    private String exchange;

    @Value("${mq.routekey}")
    private String routeKey;

    @Override
    public void sendEmail(String message) throws Exception {
        try {
            rabbitTemplate.convertAndSend(exchange, routeKey, message);
        }catch (Exception e){
            log.info("-------------------->>EmailServiceImpl.sendEmail:{}<<---------------------", ExceptionUtils.getMessage(e));
        }
    }
}