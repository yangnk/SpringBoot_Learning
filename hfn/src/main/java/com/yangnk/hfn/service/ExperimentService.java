package com.yangnk.hfn.service;

import com.yangnk.hfn.pojo.bo.ExperimentInfo;

public interface ExperimentService {
    public void send(ExperimentInfo experimentInfo);

    /**
     * 利用jedis做分布式锁，控制gpu减库存存在的并发问题
     */
    public void useGPUVm();

    /**
     * 利用redission做分布式锁，控制gpu减库存存在的并发问题
     */
    public void useGPUVm1();
}
