package com.yangnk.TCCSample1;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)//启动器
@SpringBootTest//加载容器
class BusinessServiceTest {

    @Autowired
    BusinessService businessService;

    @Test
    void test() {
        businessService.doBusiness(100,200);
//        Jedis jedis = jedisPool.getResource();
//        String city = RedisUtil.getValue(jedis, "city");
//        System.out.println("city = " + city);
    }
}