package com.yangnk.HFNQueue.controller;

import com.yangnk.HFNQueue.pojo.ExperimentInfo;
import com.yangnk.HFNQueue.service.HfnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2022-05-08 15:25
 **/
@RestController
@RequestMapping(value = "/experiment")
public class HfnController {
    @Autowired
    HfnService hfnService;

    @RequestMapping(value = "/startExperiment", method = RequestMethod.POST)
    public String startExperiment(@RequestBody ExperimentInfo experimentInfo) {
        hfnService.send(experimentInfo);
        return "success";
    }
}
