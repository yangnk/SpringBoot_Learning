package com.example.quartzdemo.demo;

import com.example.quartzdemo.mapper.TScheduleTriggerMapper;
import com.example.quartzdemo.mapper.TScheduleTriggerParamMapper;
import com.example.quartzdemo.model.TScheduleTrigger;
import com.example.quartzdemo.model.TScheduleTriggerParam;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class ScheduleServiceImpl implements IScheduleService {
    /**
     * @description:
     * @author: 调度器
     * @time: 2022/1/15 19:15
     */
    @Resource
    private Scheduler scheduler;

    @Resource
    private TScheduleTriggerMapper scheduleTriggerMapper;

    @Resource
    private TScheduleTriggerParamMapper scheduleTriggerParamMapper;

    public void deleteTrigger(String jobName, String jobGroup) {
        try {
            scheduleTriggerMapper.deleteByJobName(jobName);
            scheduler.deleteJob(new JobKey(jobName));
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    public void addTrigger(TriggerVo triggerVo) {
        int id = (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
        TScheduleTrigger trigger = new TScheduleTrigger();
        trigger.setCron(triggerVo.getCron());
        trigger.setJobGroup(triggerVo.getJobGroup());
        trigger.setJobName(triggerVo.getJobName());
        trigger.setId(id);
        trigger.setStatus("1");
        scheduleTriggerMapper.insert(trigger);

        HashMap<String, String> allMap = triggerVo.getMap();
        JobDataMap jobDataMap = new JobDataMap();
        for (Map.Entry<String, String> entry : allMap.entrySet()) {
            TScheduleTriggerParam tScheduleTriggerParam = new TScheduleTriggerParam();
            tScheduleTriggerParam.setScheduleTriggerId(id);
            tScheduleTriggerParam.setName(entry.getKey());
            tScheduleTriggerParam.setValue(entry.getValue());
            scheduleTriggerParamMapper.insert(tScheduleTriggerParam);
            jobDataMap.put(entry.getKey(),entry.getValue());
        }

        try {
        //设置TriggerKey
        String jobName = triggerVo.getJobName();
        String jobGroup = triggerVo.getJobGroup();
        String cron = triggerVo.getCron();

        //创建触发器
        CronTrigger cronTrigger1 = TriggerBuilder.newTrigger()
                .withIdentity(jobName, jobGroup)
                .withSchedule(CronScheduleBuilder.cronSchedule(cron))
                .build();

        //创建工作详情实例
            JobDetail jobDetail = JobBuilder.newJob((Class<? extends Job>) Class.forName(jobName))
                    .withIdentity(jobName, jobGroup)
                    .setJobData(jobDataMap)
                    .build();
            scheduler.scheduleJob(jobDetail, cronTrigger1);
        } catch (SchedulerException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Scheduled(cron = "*/10 * * * * ?")
    @Override
    public void refresh() {
        log.info(">>>>>>>>>>Refreshing");
        try {
            //1.查询数据库中所有任务
            List<TScheduleTrigger> scheduleTriggers = scheduleTriggerMapper.listScheduleTrigger();
            log.info(">>>>>>>>>>List of scheduled is:{}", scheduleTriggers.toString());

            //2.遍历所有任务
            for (TScheduleTrigger scheduleTrigger : scheduleTriggers) {
                Integer id = scheduleTrigger.getId();
                String cron = scheduleTrigger.getCron();
                String status = scheduleTrigger.getStatus();
                String jobName = scheduleTrigger.getJobName();
                String jobGroup = scheduleTrigger.getJobGroup();

                //3.从调度器中查找该任务
                //3.1 设置TriggerKey
                TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);

                //3.2 通过triggerKey从调度器中获取触发器
                CronTrigger cronTrigger = (CronTrigger)scheduler.getTrigger(triggerKey);

                //3.3 判断触发器是否为空，如果为空，表示调度器中没有该任务
                //如果调度器中没有该任务 ，添加任务
                if(null==cronTrigger){
                    //如果状态为0，该任务禁用,跳出本次循环
                    if("0".equals(status)){
                        continue;
                    }

                    //将任务添加到调度器中(创建新的触发器和工作详情实例)
                    //创建触发器
                    CronTrigger cronTrigger1 = TriggerBuilder.newTrigger()
                            .withIdentity(jobName, jobGroup)
                            .withSchedule(CronScheduleBuilder.cronSchedule(cron))
                            .build();

                    //创建工作详情实例
                    JobDetail jobDetail = JobBuilder.newJob((Class<? extends Job>) Class.forName(jobName))
                            .withIdentity(jobName, jobGroup)
                            .build();

                    //查询该任务的所有参数
                    List<TScheduleTriggerParam> scheduleTriggerParams = scheduleTriggerParamMapper.listScheduleTriggerParam(id);
                    //遍历参数，将参数设置到jobData中
                    JobDataMap jobDataMap = jobDetail.getJobDataMap();
                    for (TScheduleTriggerParam scheduleTriggerParam : scheduleTriggerParams) {
                        jobDataMap.put(scheduleTriggerParam.getName(),scheduleTriggerParam.getValue());
                    }
                    scheduler.scheduleJob(jobDetail,cronTrigger1);
                }else{
                    //调度器中有该任务，但是状态变成禁用
                    if("0".equals(status)){
                        //设置jobKey
                        JobKey jobKey = JobKey.jobKey(jobName, jobGroup);
                        //移除该任务
                        scheduler.deleteJob(jobKey);
                    }

                    //调度器中有该任务，但是表达式改变
                    //获取调度器中该任务的触发器器的表达式
                    String cronExpression = cronTrigger.getCronExpression();
                    //表达式不一致
                    if(!cronExpression.equals(cron)){
                        //重新创建触发器
                        CronTrigger cronTrigger2 = TriggerBuilder.newTrigger()
                                .withIdentity(jobName, jobGroup)
                                .withSchedule(CronScheduleBuilder.cronSchedule(cron))
                                .build();
                        //更新调度器中该任务的触发器
                        scheduler.rescheduleJob(triggerKey,cronTrigger2);
                    }
                }
            }
        } catch (SchedulerException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
