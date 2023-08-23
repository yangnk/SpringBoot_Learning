package com.example.quartzdemo.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author yangnk
 * @desc
 * @date 2023/08/22 23:37
 **/
@RestController
public class QuartzController {

    @Autowired
    ScheduleServiceImpl scheduleService;

    @RequestMapping(value = "/addTrigger", method = RequestMethod.POST)
    public void addTrigger(@RequestBody TriggerVo triggerVoBody) {
        scheduleService.addTrigger(triggerVoBody);
    }

    @RequestMapping(value = "/deleteTrigger", method = RequestMethod.DELETE)
    public void deleteTrigger(@RequestHeader("jobName") String jobName, @RequestHeader ("jobGroup") String jobGroup) {
        scheduleService.deleteTrigger(jobName, jobGroup);
    }
}