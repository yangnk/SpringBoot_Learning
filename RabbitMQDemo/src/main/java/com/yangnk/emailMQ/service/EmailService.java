package com.yangnk.emailMQ.service;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2019-04-25 下午6:03
 **/
public interface EmailService {

    /**
     * 发送邮件
     *
     * @param message
     * @throws Exception
     */
    public void sendEmail(String message) throws Exception;
}
