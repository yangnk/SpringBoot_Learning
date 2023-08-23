package com.example.quartzdemo.demo;

import lombok.Data;

import java.util.HashMap;

/**
 * @author yangnk
 * @desc
 * @date 2023/08/22 23:41
 **/
@Data
public class TriggerVo {

    String cron;
    String jobName;
    String jobGroup;
    HashMap<String, String> map = new HashMap<String, String>();

}