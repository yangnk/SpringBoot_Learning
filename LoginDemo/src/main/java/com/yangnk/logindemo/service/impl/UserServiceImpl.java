package com.yangnk.logindemo.service.impl;

import com.alibaba.fastjson.JSON;
import com.yangnk.logindemo.controller.UserController;
import com.yangnk.logindemo.dao.UserMapper;
import com.yangnk.logindemo.entity.User;
import com.yangnk.logindemo.pojo.vo.UserVO;
import com.yangnk.logindemo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2022-04-08 15:35
 **/
@Service
public class UserServiceImpl implements UserService {
    private final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserMapper userMapper;
    @Autowired
    RedisTemplate<String, String> redisTemplate;
    @Autowired
    SmsServiceImpl smsService;

    @Override
    public User getUser(String userName) {
        List<User> userList = userMapper.selectByUserName(userName);
        User user = userList.get(0);
        System.out.println(user.toString());
        return user;

    }


    @Override
    public void saveUserInfo(UserVO userVO) {
        User user = new User();
        user.setUserName(userVO.getUserName());
        user.setPassword(userVO.getPassword());
        user.setSex(userVO.getSex());
        userMapper.insert(user);
        logger.info("===userName:{} save user info success.===", user.getUserName());
    }

    /**
     * 向redis中存验证码，时效5min
     *
     * @param userName
     * @param smsCode
     */
    private void setRedisSmsCode(String userName, String smsCode) {
        redisTemplate.opsForValue().set(userName, smsCode, 5, TimeUnit.MINUTES);
    }


    @Override
    public void sendSmsCode(String userName, String telephone) {
        int smsCode = new Random().nextInt(899999) + 100000;
        setRedisSmsCode(userName, String.valueOf(smsCode));
        smsService.sendSmsCode(String.valueOf(smsCode));
    }

    @Override
    public String getSmsCode(String userName) {
        String smsCode = getRedisSmsCode(userName);
        return smsCode;
    }


    /**
     * 根据用户名获取redis动态验证码
     *
     * @param userName
     * @return
     */
    private String getRedisSmsCode(String userName) {
        String smsCode = redisTemplate.opsForValue().get(userName);
        logger.info("===userName :{} get smsCode from redis is:{}===", userName, smsCode);
        return smsCode;
    }
}
