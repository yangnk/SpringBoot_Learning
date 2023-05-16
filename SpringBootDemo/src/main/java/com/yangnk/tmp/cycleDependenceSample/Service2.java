package com.yangnk.cycleDependenceSample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

//@Service
@Component
@Scope("singleton")
public class Service2 {

//    @Autowired
    private Service1 service1;

    @Autowired
    public Service2(Service1 service1) {
        this.service1 = service1;
    }

//    @Autowired
//    public void setService1(Service1 service1) {
//        this.service1 = service1;
//    }


    //    @Autowired
//    public void setService1(Service1 service1) {
//        this.service1 = service1;
//    }

//    public void sayHello() {
//        System.out.println("hello2");
//    }
}
