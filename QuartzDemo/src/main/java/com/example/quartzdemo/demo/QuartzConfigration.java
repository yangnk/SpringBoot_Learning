package com.example.quartzdemo.demo;

/**
 * @author yangnk
 * @desc
 * @date 2023/08/22 11:45
 **/

import org.quartz.Scheduler;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Properties;

/**
 * @description:quartz配置类，将调度器交给spring管理
 * @author: jie
 * @time: 2022/1/15 18:19
 */
@Configuration
public class QuartzConfigration {

    @Resource
    private MyJobFactory myJobFactory;

    @Bean
    public Scheduler scheduler(){
        return this.getSchedulerFactoryBean().getScheduler();
    }

    @Bean
    public SchedulerFactoryBean getSchedulerFactoryBean(){
        //1.创建SchedulerFactoryBean
        SchedulerFactoryBean sc = new SchedulerFactoryBean();
        //2.加载自定义的quartz.properties
        sc.setQuartzProperties(this.getProperties());
        //3.设置自定义的MyJobFactory
        sc.setJobFactory(myJobFactory);
        return sc;
    }

    /**
     * @description:读取自定义的properties文件
     * @author: jie
     * @time: 2022/1/15 18:24
     */
    public Properties getProperties(){
        try {
            PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
            //设置自定义配置文件的位置
            propertiesFactoryBean.setLocation(new ClassPathResource("/quartz.properties"));
            //读取配置文件
            propertiesFactoryBean.afterPropertiesSet();
            return propertiesFactoryBean.getObject();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
