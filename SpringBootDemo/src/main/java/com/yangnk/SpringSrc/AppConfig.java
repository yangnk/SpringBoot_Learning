package com.yangnk.SpringSrc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2022-04-29 16:19
 **/
@Configuration
public class AppConfig {

    @Bean(name = "entitlement")
    public Entitlement entitlement() {

        Entitlement ent = new Entitlement();
        ent.setName("Entitlement");
        ent.setTime(20);

        return ent;
    }

    @Bean(name = "helloFactoryBean")
    public HelloFactoryBean helloFactoryBean() {
        return new HelloFactoryBean();
    }
}

