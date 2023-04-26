package com.yangnk.test1;

public class Test4 {
    static Object lock = new Object();
    static volatile boolean flag = true;

    public static void main(String[] args) {

        new Thread(() -> {
            while (true) {
                if (flag) {
                    synchronized (lock) {
                        try {
                            System.out.println(">>>>>>>>>>>thread1");
                            Thread.sleep(2000);
                            flag = false;
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, "thread1").start();

        new Thread(() -> {
            while (true) {
                if (!flag) {
                    synchronized (lock) {
                        try {
                            System.out.println(">>>>>>>>>>>thread2");
                            lock.notify();
                            Thread.sleep(2000);
                            flag = true;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, "thread2").start();
    }
}
