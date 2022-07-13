package com.yangnk.redisDemo.myTest;

import com.yangnk.redisDemo.TEST_MY.MyTestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * RedisLockUtils Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>五月 13, 2022</pre>
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
