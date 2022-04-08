package com.yangnk.RedisExample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.Serializable;

/**
 * UserEntity Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>四月 7, 2022</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserEntityTest {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Autowired
    private RedisTemplate<String, Serializable> serializableRedisTemplate;


    @Test
    public void testString() throws Exception {
        redisTemplate.opsForValue().set("date", "0407");
        System.out.println(redisTemplate.opsForValue().get("date"));

    }

    @Test
    public void testUser() throws Exception {
        UserEntity userEntity = new UserEntity(1L, "tom", "male");
        serializableRedisTemplate.opsForValue().set("user", userEntity);
        UserEntity userEntity1 = (UserEntity) serializableRedisTemplate.opsForValue().get("user");
        System.out.println(userEntity1.toString());
    }
} 
