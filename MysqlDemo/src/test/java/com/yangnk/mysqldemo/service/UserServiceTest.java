package com.yangnk.mysqldemo.service;

import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/** 
* UserService Tester. 
* 
* @author <Authors name> 
* @since <pre>四月 7, 2022</pre> 
* @version 1.0 
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
} 
