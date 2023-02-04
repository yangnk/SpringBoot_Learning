package com.yangnk.test;

import org.myAbc.MyCall;
import java.lang.reflect.Method;

public class MyTest {
    public static void main(String[] args) {
        useAppClassLoader();
    }

    private static void useAppClassLoader() {
        ClassLoader classLoader = MyTest.class.getClassLoader();
        System.out.println("MyCall ClassLoader: " + classLoader);
        try {
            Class<?> clazz = MyCall.call2("com.yangnk.test.SayHi");
            SayHi instance = (SayHi) clazz.newInstance();
            Method method = clazz.getMethod("sayHi");
            method.invoke(instance);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

