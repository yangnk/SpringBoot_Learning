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

@Component
@Slf4j
public class MyJob3 implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        //在日志中打印以下语句
        log.info(">>>>>>>>>>>>>.job3，ts="+new Date().toLocaleString());
        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        for (String s : jobDataMap.keySet()) {
            System.out.println(s);
        }
    }
}
