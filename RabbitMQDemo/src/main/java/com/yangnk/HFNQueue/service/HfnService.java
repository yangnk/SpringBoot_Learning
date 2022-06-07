package com.yangnk.HFNQueue.service;

import com.alibaba.fastjson.JSON;
import com.yangnk.HFNQueue.pojo.ExperimentInfo;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2022-05-08 15:29
 **/
@Slf4j
@Service
public class HfnService {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(ExperimentInfo experimentInfo) {
        String experimentJsonString = JSON.toJSONString(experimentInfo);
        this.rabbitTemplate.convertAndSend("hfn_exchange", "hfn_routekey", experimentJsonString);
        log.info("=================HfnService.send():{}================", experimentJsonString);
    }
}
