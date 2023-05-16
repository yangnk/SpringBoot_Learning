package com.yangnk.dynamicThreadPool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Configuration
public class MyConfiguration {

    @Bean("threadPoolExecutor")
    public ThreadPoolExecutor getThreadPoolExecutor() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,
                2,
                30,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2),
                new ThreadFactoryBuilder().setNameFormat("c_t_%d").build(),
                new ThreadPoolExecutor.CallerRunsPolicy());

        return threadPoolExecutor;
    }
}
