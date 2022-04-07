package com.yangnk.springBootDemo.service;

import cn.hutool.extra.mail.MailUtil;
import org.springframework.stereotype.Service;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2022-01-25 19:44
 **/
@Service
public class SendMail {

    public void sendMail() {
        for (int i = 0; i < 5; i++) {
            MailUtil.send("yangningkai@qq.com", "sendMail测试:"+i, "邮件来自Hutool测试", false);
        }
    }
}
