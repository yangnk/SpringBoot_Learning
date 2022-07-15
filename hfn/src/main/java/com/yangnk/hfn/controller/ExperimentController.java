package com.yangnk.hfn.controller;

import com.yangnk.hfn.pojo.bo.ExperimentInfo;
import com.yangnk.hfn.service.ExperimentService;
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
public class ExperimentController {
    @Autowired
    ExperimentService experimentService;

    @RequestMapping(value = "/startExperiment", method = RequestMethod.POST)
    public String startExperiment(@RequestBody ExperimentInfo experimentInfo) {
        experimentService.send(experimentInfo);
        return "success";
    }
}
