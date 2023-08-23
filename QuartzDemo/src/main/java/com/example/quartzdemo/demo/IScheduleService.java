package com.example.quartzdemo.demo;

/**
 * @author yangnk
 * @desc
 * @date 2023/08/22 11:49
 **/

public interface IScheduleService {

    /**
     * 定时更新任务
     */
    public void refresh();

    /**
     * 创建新任务
     * @param triggerVo
     */
    public void addTrigger(TriggerVo triggerVo);

    /**
     * 停止任务
     *
     * @param jobName
     * @param jobGroup
     */
    public void deleteTrigger(String jobName, String jobGroup);

}
