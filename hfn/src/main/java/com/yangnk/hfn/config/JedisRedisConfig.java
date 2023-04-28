package com.yangnk.hfn.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.Serializable;
import java.time.Duration;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2022-04-07 17:30
 **/
@Configuration
@Slf4j
public class JedisRedisConfig {

    @Value("${spring.redis.database}")
    private int database;
    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private int port;
    //    @Value("${spring.redis.password}")
//    private String password;
    @Value("${spring.redis.timeout}")
    private int timeout;
    @Value("${spring.redis.jedis.pool.max-active}")
    private int maxActive;
    @Value("${spring.redis.jedis.pool.max-wait}")
    private long maxWaitMillis;
    @Value("${spring.redis.jedis.pool.max-idle}")
    private int maxIdle;
    @Value("${spring.redis.jedis.pool.min-idle}")
    private int minIdle;

    /**
     * 连接池配置信息
     */

    @Bean
    public JedisPool redisPoolFactory() {
        try {
            JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
            jedisPoolConfig.setMaxIdle(maxIdle);
//            jedisPoolConfig.setMaxWaitMillis(maxWait);
            jedisPoolConfig.setMaxTotal(maxActive);
            jedisPoolConfig.setMinIdle(minIdle);
//            // 密码为空设置为null
//            if (org.apache.commons.lang3.StringUtils.isBlank(password)) {
//                password = null;
//            }
            JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout);
            log.info("初始化Redis连接池JedisPool成功!地址: {}:{}", host, port);
            return jedisPool;
        } catch (Exception e) {
            log.error("初始化Redis连接池JedisPool异常:{}", e.getMessage());
        }
        return null;
    }

    @Bean
    public JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        // 最大连接数
        jedisPoolConfig.setMaxTotal(maxActive);
        // 当池内没有可用连接时，最大等待时间
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
        // 最大空闲连接数
        jedisPoolConfig.setMinIdle(maxIdle);
        // 最小空闲连接数
        jedisPoolConfig.setMinIdle(minIdle);
        // 其他属性可以自行添加
        return jedisPoolConfig;
    }

    /**
     * Jedis 连接
     *
     * @param jedisPoolConfig
     * @return
     */
    @Bean(name = "JedisConnectionFactory")
    public JedisConnectionFactory jedisConnectionFactory(JedisPoolConfig jedisPoolConfig) {
        JedisClientConfiguration jedisClientConfiguration = JedisClientConfiguration.builder().usePooling().poolConfig(jedisPoolConfig).and().readTimeout(Duration.ofMillis(timeout)).build();
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setHostName(host);
        redisStandaloneConfiguration.setPort(port);
//        redisStandaloneConfiguration.setPassword(RedisPassword.of(password));
        return new JedisConnectionFactory(redisStandaloneConfiguration, jedisClientConfiguration);
    }

    /**
     * 缓存管理器
     *
     * @param connectionFactory
     * @return
     */
    @Bean
    public RedisCacheManager cacheManager(@Qualifier(value = "JedisConnectionFactory") RedisConnectionFactory connectionFactory) {
        return RedisCacheManager.create(connectionFactory);
    }

    @Bean
    public RedisTemplate<String, Serializable> redisTemplate(@Qualifier(value = "JedisConnectionFactory") JedisConnectionFactory connectionFactory) {
        RedisTemplate<String, Serializable> redisTemplate = new RedisTemplate<>();
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplate.setConnectionFactory(jedisConnectionFactory(jedisPoolConfig()));
        return redisTemplate;
    }

}

