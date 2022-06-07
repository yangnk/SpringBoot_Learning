package com.yangnk.redisDemo.myTest;

import org.springframework.stereotype.Service;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2022-05-13 16:22
 **/
@Service
public class MyTestService {
    public String Test() {
        System.out.println("test");
        return "test";
    }
}
