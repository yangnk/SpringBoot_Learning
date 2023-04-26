package com.yangnk.test;

//DCL
public class SingletonTest {
    public static volatile SingletonTest singletonTest;

    private SingletonTest() {
    }

    public static SingletonTest getInstance() {
        if (singletonTest == null) {
            synchronized (SingletonTest.class) {
                if (singletonTest == null) {
                    return new SingletonTest();
                }
            }
        }
        return singletonTest;
    }
}
