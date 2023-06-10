package com.yangnk.dynamicThreadPool;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.concurrent.*;

@Configuration
public class MyConfig {
    @Bean
    ThreadPoolExecutor getExecutor() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(50,
                500,
                10,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(100000));
        executor.prestartCoreThread();
        return executor;
    }
}
