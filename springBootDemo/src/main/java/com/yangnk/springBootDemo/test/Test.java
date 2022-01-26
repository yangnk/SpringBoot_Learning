package com.yangnk.springBootDemo.test;

import cn.hutool.extra.mail.MailUtil;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2022-01-25 19:42
 **/
public class Test {
    public static void main(String[] args) {
        MailUtil.send("yangningkai@foxmail.com", "测试", "邮件来自Hutool测试", false);
    }
}
