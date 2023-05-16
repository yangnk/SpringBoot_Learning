//package com.yangnk.cycleDependenceSample;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Component
//public class CircularDependencyA {
//
//    private CircularDependencyB circularDependencyB;
//
//    @Autowired
//    public void setCircularDependencyB(CircularDependencyB circularDependencyB) {
//        this.circularDependencyB = circularDependencyB;
//    }
//
//    public CircularDependencyB getCircularDependencyB() {
//        return circularDependencyB;
//    }
//}