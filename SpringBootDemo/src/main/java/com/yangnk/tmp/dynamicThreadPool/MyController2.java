package com.yangnk.dynamicThreadPool;


import com.yangnk.dynamicThreadPool.MyServce;
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
 public class MyController2 {

    @Autowired
    MyServce myServce;

    @RequestMapping("/hello1")
    public String hello1(@RequestParam("size") int size){
        myServce.execTask(size);
        return new Date().toString();
    }


    @RequestMapping("/hello2")
    public String hello2(@RequestParam("coreSize") int coreSize,@RequestParam("maxSize") int maxSize){
        myServce.changeExecutor(coreSize, maxSize);
        return new Date().toString();
    }
}

