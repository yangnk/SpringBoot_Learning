package com.yangnk.redisDemo.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/** 
* RedisLockUtils Tester. 
* 
* @author <Authors name> 
* @since <pre>五月 13, 2022</pre> 
* @version 1.0 
*/
@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisUtilsTest {
    @Autowired
    RedisUtils redisUtils;
    @Autowired
    JedisPool jedisPool;

    @Test
    public void testSetnxLock() throws Exception {
        Jedis jedis = jedisPool.getResource();
        redisUtils.setnxLock(jedis, "lock", "1", 30);
    }

    @Test
    public void testSetValue() throws Exception {
        Jedis jedis = jedisPool.getResource();
        redisUtils.setValue(jedis, "key0606", "value2152");
    }

    @Test
    public void testGetValue() throws Exception {
        Jedis jedis = jedisPool.getResource();
        String key0606 = redisUtils.getValue(jedis, "key0606");
        System.out.println(key0606);

    }

} 
