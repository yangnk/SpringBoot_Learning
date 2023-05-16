package com.yangnk.cycleDependenceSample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Service
@Component
@Scope("singleton")
public class Service1 {
    @Autowired
    private Service2 service2;

    @Autowired
    public Service1(Service2 service2) {
        this.service2 = service2;
    }

//    @Autowired
//    public void setService2(@Lazy Service2 service2) {
//        this.service2 = service2;
//    }

//    public void sayHello() {
//        System.out.println("hello1");
//    }
}
