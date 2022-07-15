package com.yangnk.hfn.service.impl;

import com.alibaba.fastjson.JSON;
import com.yangnk.hfn.pojo.bo.ExperimentInfo;
import com.yangnk.hfn.service.ExperimentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2022-05-08 15:29
 **/
@Slf4j
@Service
public class ExperimentServiceImpl implements ExperimentService {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(ExperimentInfo experimentInfo) {
        String experimentJsonString = JSON.toJSONString(experimentInfo);
        rabbitTemplate.convertAndSend("hfn_exchange", "hfn_routekey", experimentJsonString);
        log.info("=================ExperimentService.send():{}================", experimentJsonString);
    }
}
