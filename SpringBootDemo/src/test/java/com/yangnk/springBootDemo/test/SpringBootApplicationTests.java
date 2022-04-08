//package com.yangnk.springBootDemo.test;
//
//import cn.hutool.extra.mail.MailUtil;
//import com.yangnk.circularDepedencyDemo.service.SendMail;
//import com.yangnk.circularDepedencyDemo.service.SendSms;
//import org.junit.jupiter.api.CdTest;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
///**
// * ${DESCRIPTION}
// *
// * @author yangningkai
// * @create 2022-01-25 19:23
// **/
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class SpringBootApplicationTests {
//
//    @Autowired
//    SendMail sendMail;
//
//    @Autowired
//    SendSms sendSms;
//
//    @CdTest
//    public void testSendMail() {
//        System.out.println("==================testSendMail==================");
//        sendMail.sendMail();
//    }
//
//    @CdTest
//    public void testSendSms() {
//        System.out.println("==================testSendSms==================");
//        sendSms.sendSms();
//    }
//}