package com.yangnk.mystarterdemo;


import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties({
        MyStarterProperties.class,
})

@Configuration
public class MyStarterAutoConfiguration {

    @Bean
    MyStarterTemplate getMyStarterTemplate(MyStarterProperties myStarterProperties) {
        return new MyStarterTemplate(myStarterProperties);
    }
}
