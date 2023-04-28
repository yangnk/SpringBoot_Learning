package com.yangnk.hfn.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.codec.JsonJacksonCodec;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Redisson 的配置类
 */
@Configuration
public class RedissionConfig {
    @Value("${spring.redis.host}")
    private String redisHost;

    private int port = 6379;

    @Bean
    public RedissonClient getRedisson() {
        Config config = new Config();
        config.useSingleServer().
                setAddress("redis://" + redisHost + ":" + port);
        config.setCodec(new JsonJacksonCodec());
        return Redisson.create(config);
    }
}
