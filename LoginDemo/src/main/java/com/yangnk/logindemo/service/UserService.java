package com.yangnk.logindemo.service;

import com.yangnk.logindemo.entity.User;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2022-04-08 15:34
 **/
public interface UserService {
    User getUser(String userName);

    /**
     * 将用户请求的验证码发送到用户手机，并且存入到有失效时长的redis中
     * @param userName
     * @param telephone
     */
    void sendSmsCode(String userName, String telephone);
}
