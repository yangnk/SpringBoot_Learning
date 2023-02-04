package com.yangnk.logindemo.service.impl;

import com.yangnk.logindemo.myTest.JdbcTest;
import com.yangnk.logindemo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * UserServiceImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>四月 8, 2022</pre>
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceImplTest {
    @Autowired
    UserService userService;

    @Autowired
    SmsServiceImpl smsService;

    @Autowired
    JdbcTest jdbcTest;


    @Test
    public void jdbcTest() throws Exception {
        int count = jdbcTest.getCount();
    }

    @Test
    public void testGetUser() throws Exception {
        userService.getUser("aaa");
    }

    @Test
    public void testSetRedisSmsCode() throws Exception {
//        userService.setRedisSmsCode("aaa", "123456");
    }

    @Test
    public void testSendSms() throws Exception {
//        userService.getUser("aaa");
//        while (true) {

        smsService.sendSmsCode("111111");
//        }
    }

} 
