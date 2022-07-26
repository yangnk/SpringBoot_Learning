package com.yangnk.springBootDemo.test;

import com.yangnk.SpringDemoApplication;
import com.yangnk.test.ImportConfig;
import com.yangnk.test.TestA;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2022-01-25 19:23
 **/

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { ImportConfig.class })
@SpringBootTest
public class SpringBootApplicationTests {
    @Autowired
    TestA testA;

    @Test
    public void TestA() {
        testA.printName();
    }


}
