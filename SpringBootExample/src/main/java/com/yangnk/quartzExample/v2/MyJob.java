package com.yangnk.quartzExample.v2;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author yangnk
 * @desc
 * @date 2023/08/05 23:57
 **/
public class MyJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        context.getJobDetail().getJobDataMap().forEach((k, v) ->{
            System.out.println("key = " + k);
            System.out.println("value = " + v);
            System.out.println("===System.currentTimeMillis() = " + System.currentTimeMillis());
        });
    }
}