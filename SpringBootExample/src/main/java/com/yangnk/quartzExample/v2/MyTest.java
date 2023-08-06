package com.yangnk.quartzExample.v2;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yangnk
 * @desc
 * @date 2023/08/06 00:07
 **/
public class MyTest {

    public static void main(String[] args) throws SchedulerException {

        //StdSchedulerFactory方式，用的多
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler schedulerStd = schedulerFactory.getScheduler();

        JobDetail jobDetail = getJobDetail();
        Trigger trigger = getTrigger();

        //执行调度
        schedulerStd.scheduleJob(jobDetail, trigger);
        schedulerStd.start();
    }

    public static Trigger getTrigger() {
        //CronScheduleBuilder
        String triggerName2 = "schedulerJob2";
        String triggerGroup2 = "schedulerGroup2";
        String jobTime = "0/1 * * * * ?";
        Trigger trigger2 = TriggerBuilder
                .newTrigger()
                .withIdentity(triggerName2, triggerGroup2)
                .startAt(DateBuilder.futureDate(1, DateBuilder.IntervalUnit.SECOND))
                .withSchedule(CronScheduleBuilder.cronSchedule(jobTime))
                .startNow()
                .build();
        return trigger2;
    }

    public static JobDetail getJobDetail() {
        Map<String, String> jobData = new HashMap<>();
        String jobName = "schedulerJob";
        String jobGroup = "schedulerGroup";
        jobData.put("key00","value00");
        jobData.put("key01","value01");
        jobData.put("key03","value03");
        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.putAll(jobData);

        JobDetail jobDetail = JobBuilder.newJob(MyJob.class)
                .withIdentity(jobName, jobGroup)
                .usingJobData(jobDataMap)
                .storeDurably()
                .build();
        return jobDetail;
    }
}