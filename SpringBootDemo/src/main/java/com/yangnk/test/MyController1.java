package com.yangnk.test;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Properties;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2022-03-04 16:10
 **/
@RestController
@Slf4j
 public class MyController1 {

    @Autowired
    MyService1 myService1;

    @RequestMapping("/hello1")
    public String sayHello() throws IOException {
        System.out.println("hello1");

        myService1.run();
        for (int i = 0; i < 3; i++) {
            log.info("222.==========i:{}, currentThreadName:{}===========", i, Thread.currentThread().getName());
        }



//        InputStream resourceAsStream = this.getClass().getResourceAsStream("/quota/test.json");
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream));
//        StringBuffer sb = new StringBuffer();
//        String line;
//
//        while ((line = bufferedReader.readLine()) != null) {
//            sb.append(line);
//        }


//        // 从properties文件中获取key值
//        InputStream input = MyController1.class.getClassLoader().getResourceAsStream("testApp.properties");
//        Properties prop = new Properties();
//        prop.load(input);
//        String value = prop.getProperty("testKey");
//        System.out.println("value = " + value);


        return new Date().toString();
    }

}

