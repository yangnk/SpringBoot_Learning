package com.yangnk.springboottestexample.myTest;


import com.yangnk.mystarterdemo.MyStarterTemplate;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTest {

    @Autowired
    private MyStarterTemplate myStarterTemplate;

    @Test
    public void testMyStarter(){
        myStarterTemplate.printName();
    }

}
