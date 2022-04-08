package com.yangnk.logindemo.service.impl;

import com.yangnk.logindemo.dao.UserMapper;
import com.yangnk.logindemo.entity.User;
import com.yangnk.logindemo.entity.UserExample;
import com.yangnk.logindemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2022-04-08 15:35
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @Override

    public User getUser(String userName) {
        List<User> userList = userMapper.selectByUserName(userName);
        User user = userList.get(0);
        System.out.println(user.toString());
        return user;
    }

    @Override
    public void setRedisSmsCode(String smsCode) {
//        redisTemplate.opsForValue().set(,,,);

    }
}
