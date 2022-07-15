package com.yangnk.hfn.service.impl;

import com.yangnk.hfn.dao.UserTblMapper;
import com.yangnk.hfn.entity.UserTbl;
import com.yangnk.hfn.pojo.vo.UserVO;
import com.yangnk.hfn.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
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
@Slf4j
public class UserServiceImpl implements UserService {
    private final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserTblMapper UserTblMapper;
    @Autowired
    RedisTemplate<String, String> redisTemplate;
    @Autowired
    SmsServiceImpl smsService;
    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Override
    public UserTbl getUser(String userName) {
        List<UserTbl> userList = UserTblMapper.selectByUserName(userName);
        UserTbl user = userList.get(0);
        System.out.println(user.toString());
        return user;

    }


    @Override
    public void saveUserInfo(UserVO userVO) {
        UserTbl user = new UserTbl();
        user.setUserName(userVO.getUserName());
        user.setPassword(userVO.getPassword());
        user.setSex(userVO.getSex());
        UserTblMapper.insert(user);
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
        rabbitTemplate.convertAndSend("hello", smsCode);//todo 向RabbitMQ中发送数据
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
