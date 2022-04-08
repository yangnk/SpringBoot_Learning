package com.yangnk.logindemo.service;

import com.yangnk.logindemo.entity.User;
import org.springframework.stereotype.Service;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2022-04-08 15:34
 **/
public interface UserService {
    public User getUser(String userName);

    /**
     * 向redis中存验证码，时效5min
     * @param smsCode
     */
    public void setRedisSmsCode(String smsCode);
}
