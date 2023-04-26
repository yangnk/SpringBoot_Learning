package com.yangnk.hfn.common.task;

import com.yangnk.hfn.pojo.bo.ExperimentInfo;
import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.Callable;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2022-05-08 15:58
 **/
@Slf4j
public class ExperimentTask implements Callable<String> {
    public ExperimentInfo experimentInfo;

    public ExperimentTask(ExperimentInfo experimentInfo) {
        this.experimentInfo = experimentInfo;
    }

    @Override
    public String call() throws Exception {
        log.info("=================ExperimentTask.call():start=================");
        Thread.sleep(5000);

        if (experimentInfo == null || experimentInfo.getExperimentId() == null) {
            return "fail";
        }
        log.info("=================ExperimentTask.call(), experimentInfo:{}, ThreadName:{}================", experimentInfo.toString(), Thread.currentThread().getName());
        return "success";
    }
}
