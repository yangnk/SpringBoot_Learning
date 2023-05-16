package com.yangnk.test1;

import java.util.concurrent.locks.LockSupport;

public class Test2 {

    public static void main(String[] args) {
        System.out.println("System.currentTimeMillis() = " + System.currentTimeMillis());

//        LockSupport.parkNanos(100000);

        Thread thread = Thread.currentThread();
        new Thread(() -> {

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LockSupport.unpark(thread);
            System.out.println(">>>>>>System.currentTimeMillis() = " + System.currentTimeMillis());


        }).start();
        LockSupport.park();
        System.out.println("System.currentTimeMillis() = " + System.currentTimeMillis());

    }
}
