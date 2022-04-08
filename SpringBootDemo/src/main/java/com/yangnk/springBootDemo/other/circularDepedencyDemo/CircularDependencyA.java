package com.yangnk.springBootDemo.other.circularDepedencyDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2022-03-04 22:37
 **/
@Component
public class CircularDependencyA {

    private CircularDependencyB circB;

    @Autowired
    public CircularDependencyA(@Lazy CircularDependencyB circB) {
        this.circB = circB;
        System.out.println("=====================");
        System.out.println("CircularDependencyA");
        System.out.println("=====================");
    }
}