package com.yangnk.async.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

interface AsyncService {

    String sendSms(String callPrefix, String mobile, String actionType, String content);

    String sendEmail(String email, String subject, String content);
}

@Slf4j
@Service
public class AsyncTest implements AsyncService {

    @Override
    @Async("taskExecutor")
    public String sendSms(String callPrefix, String mobile, String actionType, String content) {
        try {

            Thread.sleep(1000);
            System.out.println( "发送sms成功");

        } catch (Exception e) {
            log.error("发送短信异常 -> ", e);
        }
        return "发送sms成功";
    }


    @Override
    @Async("taskExecutor")
    public String sendEmail(String email, String subject, String content) {
        try {

            Thread.sleep(1000);
            System.out.println( "发送email成功");

        } catch (Exception e) {
            log.error("发送email异常 -> ", e);
        }
        return "发送成功";
    }
}

