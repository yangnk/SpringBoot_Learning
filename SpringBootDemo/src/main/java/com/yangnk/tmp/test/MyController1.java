package com.yangnk.test;


//import com.yangnk.dynamicThreadPool.MyServce;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2022-03-04 16:10
 **/
@RestController
@Slf4j
@TestAnnotation(value = "test")
public class MyController1 {

//    @Autowired
//    MyServce myServce;


    @RequestMapping("/hello1")
    public String hello1() {

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new Date().toString();
    }


//    @RequestMapping("/hello1")
//    public String sayHell1(@RequestParam("size") int size){
//        myServce.execTask(size);
//
//        return new Date().toString();
//    }


//    @RequestMapping("/hello2")
//    public String sayHello2(@RequestParam("coreSize") int coreSize,@RequestParam("maxSize") int maxSize){
//        myServce.changeExecutor(coreSize, maxSize);
//        return new Date().toString();
//    }
}

