package com.example.quartzdemo.demo;

/**
 * @author yangnk
 * @desc
 * @date 2023/08/22 11:47
 **/

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.Map;

@Component
@Slf4j
public class MyJob2 implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        //在日志中打印以西语句
        log.info("job2， " + new Date().toLocaleString());
        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
//        Set<Map.Entry<String, Object>> entries = jobDataMap.entrySet();
        for (Map.Entry<String, Object> entry : jobDataMap.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            log.info("key:{},value:{}", key, value);
        }
    }
}
