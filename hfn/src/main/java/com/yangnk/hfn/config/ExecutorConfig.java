package com.yangnk.hfn.config;

import com.yangnk.hfn.common.task.ExperimentTask;
import com.yangnk.hfn.pojo.bo.ExperimentInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Comparator;
import java.util.concurrent.*;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2022-05-08 15:51
 **/
@Configuration
public class ExecutorConfig {
    @Bean(value = "HfnThreadPoolExecutor")
    public ThreadPoolExecutor initThreadPoolExecutor() {

        BlockingQueue<Runnable> myQueue = new PriorityBlockingQueue(10, new Comparator<ExperimentTask>() {
            @Override
            public int compare(ExperimentTask o1, ExperimentTask o2) {
                return o1.experimentInfo.priority - o2.experimentInfo.priority;
            }
        });

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10,
                10,
                1000L,
                TimeUnit.MILLISECONDS,
                myQueue,
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());
        threadPoolExecutor.prestartAllCoreThreads();
        return threadPoolExecutor;
    }
}
