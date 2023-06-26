package com.yangnk.mystarterdemo;

public class MyStarterTemplate {

    MyStarterProperties myStarterProperties;

    public MyStarterTemplate(MyStarterProperties myStarterProperties) {
        this.myStarterProperties = myStarterProperties;
    }

    public void printName() {
        System.out.println("myStarterProperties.getName() = " + myStarterProperties.getName());
    }
}
