package com.yangnk.mysqldemo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * UserService Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>四月 7, 2022</pre>
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {
    @Autowired
    UserService userService;

    @Test
    public void testGetUserMapper() throws Exception {
        userService.getUserMapper();
    }

    @Test
    public void testSetUserMapper() throws Exception {
        userService.setUserMapper();
    }

} 
