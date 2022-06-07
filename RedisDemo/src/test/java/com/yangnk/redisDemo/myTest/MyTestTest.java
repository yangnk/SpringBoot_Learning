package com.yangnk.redisDemo.myTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/** 
* RedisLockUtils Tester. 
* 
* @author <Authors name> 
* @since <pre>五月 13, 2022</pre> 
* @version 1.0 
*/
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTestTest {
    @Autowired
    MyTestService myTest;

    @Test
    public void testSetnxLock() throws Exception {
        myTest.Test();
    }
} 
