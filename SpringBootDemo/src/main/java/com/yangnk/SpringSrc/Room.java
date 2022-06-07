package com.yangnk.SpringSrc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2022-05-05 21:29
 **/
@Component
public class Room {
    @Value("Xiaomi")
    private String television;
    @Value("Gree")

    private String airConditioner;
    @Value("Haier")

    private String refrigerator;
    @Value("Siemens")
    private String washer;
}

//
//<bean id="room" class="xyz.coolblog.demo.Room">
//<property name="television" value="Xiaomi"/>
//<property name="airConditioner" value="Gree"/>
//<property name="refrigerator" value="Haier"/>
//<property name="washer" value="Siemens"/>
//</bean>