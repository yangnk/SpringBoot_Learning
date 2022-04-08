package com.yangnk.logindemo.service.impl;

import com.yangnk.logindemo.service.UserService;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/** 
* UserServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>四月 8, 2022</pre> 
* @version 1.0 
*/
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceImplTest {
    @Autowired
    UserService userService;

@Test
public void testGetUser() throws Exception {
    userService.getUser("aaa");
}
} 
