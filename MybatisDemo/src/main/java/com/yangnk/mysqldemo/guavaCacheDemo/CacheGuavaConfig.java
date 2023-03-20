package com.yangnk.mysqldemo.guavaCacheDemo;

import com.google.common.cache.CacheBuilder;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableCaching
public class CacheGuavaConfig {

    /**
     * 设置缓存管理器
     */
    @Bean
    public CacheManager cacheManager(){
        GuavaCacheManager cacheManager = new GuavaCacheManager();

        cacheManager.setCacheBuilder(CacheBuilder.newBuilder()
                // 缓存过期时间
                .expireAfterWrite(10, TimeUnit.SECONDS)
                // 缓存最大容量是 1000
                .maximumSize(1000)
        );
        return cacheManager;
    }
}
