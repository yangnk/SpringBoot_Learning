package com.yangnk.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProfileTest {

    @Value("${spring.profiles.active}")
    String profile;

    void print() {
        System.out.println("ProfileTest.profile = " + profile);
    }
}
