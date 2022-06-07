package com.yangnk.SpringSrc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Test0429a Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>四月 29, 2022</pre>
 */

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { Room.class })
@SpringBootTest
public class Test0429aTest {

    @Autowired
    Room room;

    @Test
    public void testHello() throws Exception {
        room.toString();

    }


} 
