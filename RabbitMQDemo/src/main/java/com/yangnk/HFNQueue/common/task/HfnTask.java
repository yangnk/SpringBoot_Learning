package com.yangnk.HFNQueue.common.task;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yangnk.HFNQueue.pojo.ExperimentInfo;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2022-05-08 15:58
 **/
@Slf4j
public class HfnTask implements Callable<String>{
    ExperimentInfo experimentInfo;

    public HfnTask(ExperimentInfo experimentInfo) {
        this.experimentInfo = experimentInfo;
    }

    @Override
    public String call() throws Exception {
        log.info("=================HfnTask.call():start=================");
        Thread.sleep(5000);

        if (experimentInfo == null || experimentInfo.getExperimentId() == null) {
            return "fail";
        }
        log.info("=================HfnTask.call(), experimentInfo:{}, ThreadName:{}================", experimentInfo.toString(), Thread.currentThread().getName());
        return "success";
    }
}
