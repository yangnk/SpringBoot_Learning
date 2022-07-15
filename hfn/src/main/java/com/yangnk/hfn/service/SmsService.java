package com.yangnk.hfn.service;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2022-04-08 20:47
 **/
public interface SmsService {
    /**
     * 向rabbitMQ发送smsCode
     *
     * @param smsCode
     */
    void sendSmsCode(String smsCode);
}
