package com.yangnk;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2022-04-29 14:37
 **/
@SpringBootTest
public class Test0429 {

    @Test
    public void testAlias() {
        String configLocation = "application-alias.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(configLocation);
        System.out.println("    alias-hello -> " + applicationContext.getBean("alias-hello"));
        System.out.println("double-alias-hello -> " + applicationContext.getBean("double-alias-hello"));
    }
}
