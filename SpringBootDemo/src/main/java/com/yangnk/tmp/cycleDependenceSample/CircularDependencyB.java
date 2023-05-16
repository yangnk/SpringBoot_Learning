//package com.yangnk.cycleDependenceSample;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Component
//public class CircularDependencyB {
//
//    private CircularDependencyA circularDependencyA;
//
//    @Autowired
//    public void setCircularDependencyA(CircularDependencyA circularDependencyA) {
//        this.circularDependencyA = circularDependencyA;
//    }
//
//    public CircularDependencyA getCircularDependencyA() {
//        return circularDependencyA;
//    }
//
//}
