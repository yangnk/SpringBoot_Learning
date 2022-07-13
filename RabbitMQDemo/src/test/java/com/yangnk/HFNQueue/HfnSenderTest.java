package com.yangnk.HFNQueue;

import com.yangnk.HFNQueue.common.HfnSender;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * HfnSender Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>五月 8, 2022</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HfnSenderTest {

    @Autowired
    HfnSender hfnSender;

    @Test
    public void testSend() throws Exception {
        while (true) {
            hfnSender.send();
            Thread.sleep(1000);
        }
    }
} 
