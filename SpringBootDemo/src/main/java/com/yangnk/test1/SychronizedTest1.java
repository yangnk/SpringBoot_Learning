package com.yangnk.test1;

public class SychronizedTest1 {
    public static void main(String[] args) {
        synchronized (SychronizedTest1.class) {
            System.out.println("hello world");

        }
    }
}
