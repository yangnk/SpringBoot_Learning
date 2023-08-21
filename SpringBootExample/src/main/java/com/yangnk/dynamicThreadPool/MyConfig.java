package com.yangnk.dynamicThreadPool;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.concurrent.*;

@Configuration
public class MyConfig {
    @Bean
    ThreadPoolExecutor getExecutor() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10,
                10,
                10,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10000));
        executor.prestartCoreThread();
        return executor;
    }
}
