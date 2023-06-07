package com.yangnk.springExtend;


import org.springframework.context.EnvironmentAware;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@Order(value = 1)
public class EnvironmentAwareTest implements EnvironmentAware {

    Environment environment;
    @Override
    public void setEnvironment(Environment environment) {

        this.environment = environment;
        System.out.println(">>>>>>>>>>>>>>>>>>>name = " + environment.getProperty("name"));
    }
}
