package com.yangnk.mysqldemo.guavaCacheDemo;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.concurrent.ConcurrentHashMap;


@Service
@CacheConfig(cacheNames = "guavaCache") // 声明缓存的名称
public class CacheUserService {
    ConcurrentHashMap<String, UserEntity> concurrentHashMap = new ConcurrentHashMap();

    @Cacheable(key = "#name")
    public UserEntity getUserByName(String name) {
        UserEntity userEntity = concurrentHashMap.get(name);
        System.out.println("从数据库中获取数据，而不是读取缓存");
        return userEntity;
    }

    @CachePut(key = "#name")
    public UserEntity putUserByName(String name) {
        UserEntity userEntity = new UserEntity(name, 18);
        concurrentHashMap.put(name, userEntity);
        return userEntity;
    }
}
