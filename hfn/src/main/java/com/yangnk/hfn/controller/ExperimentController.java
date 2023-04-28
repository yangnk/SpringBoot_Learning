package com.yangnk.hfn.controller;

import com.yangnk.hfn.pojo.bo.ExperimentInfo;
import com.yangnk.hfn.service.ExperimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

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

    /**
     * 使用gpu
     * @return
     */
    @GetMapping("/useGPUVm")
    public String useGPUVm() {
        experimentService.useGPUVm();
        return "success";
    }

    @GetMapping("/useGPUVm1")
    public String useGPUVm1() {
        experimentService.useGPUVm1();
        return "success";
    }

    @GetMapping("/test")
    public String index() {
        return "test," + new Date().toString();
    }
}
