package com.yangnk.test1;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicIntegerTest {
    static AtomicInteger atomicInteger = new AtomicInteger(0);

    static AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(new int[]{1, 2, 3});


    public static void main(String[] args) {
        atomicIntegerArray.set(0, 100);
        System.out.println("atomicIntegerArray.get(0) = " + atomicIntegerArray.get(0));

        int i = atomicIntegerArray.addAndGet(1, 200);

        System.out.println(">>>>>>>>>>>>i = " + i);


//        int i = atomicInteger.addAndGet(100);
//
//        System.out.println("i = " + i);


//
//        Thread thread1 = new Thread(() -> {
//            for (int i = 0; i < 100; i++) {
////                integer++;
//                int i1 = atomicInteger.incrementAndGet();
//                System.out.println(">>>>>>>>>>>>thread1:i1 = " + i1);
//            }
//        });
//
//
//        Thread thread2 = new Thread(() -> {
//            for (int i = 0; i < 100; i++) {
////                integer++;
//                int i1 = atomicInteger.incrementAndGet();
//                System.out.println(">>>>>>>>>>>>thread2:i1 = " + i1);
//            }
//        });
//
//        thread1.start();
//        thread2.start();
//
////        int i1 = atomicInteger.get();
////        System.out.println(">>>>>>>>>>>>>i1 = " + i1);
////
////        for (int i = 0; i < 100; i++) {
////            int i2 = atomicInteger.incrementAndGet();
////            System.out.println(">>>>>>>>>>>>>>>i2 = " + i2);
////        }

    }
}
