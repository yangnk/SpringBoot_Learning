package com.example.quartzdemo.demo;

/**
 * @author yangnk
 * @desc
 * @date 2023/08/22 00:45
 **/

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;

/**
 * @description:自定义MyJobFactory，解决spring不能在quartz中注入bean的问题
 */
@Component
public class MyJobFactory extends AdaptableJobFactory {
    /**
     * @description:这个对象Spring会帮我们自动注入进来
     */
    @Autowired
    private AutowireCapableBeanFactory autowireCapableBeanFactory;

    @Override
    protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
        Object jobInstance = super.createJobInstance(bundle);
        //通过以下方式，解决Job任务无法使用Spring中的Bean问题
        autowireCapableBeanFactory.autowireBean(jobInstance);
        return jobInstance;
    }
}
