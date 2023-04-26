package com.yangnk.test1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

    static ReentrantLock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();
    static volatile boolean flag = true;

    public static void main(String[] args) {

        new Thread(() -> {
            while (true) {
                if (flag) {
                    lock.lock();
                    try {
                        System.out.println("thread1 start>>>>>>>>>>>>>");
                        Thread.sleep(2000);
                        flag = false;
                        condition.await();
//                        System.out.println("thread1 end>>>>>>>>>>>>>");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        lock.unlock();
                    }
                }
            }
        },"thread1").start();

        new Thread(() -> {
            while (true) {
                if (!flag) {
                    lock.lock();
                    try {
                        System.out.println("thread2 start>>>>>>>>>>>>>");
                        Thread.sleep(2000);
                        condition.signalAll();
                        flag = true;
//                        System.out.println("thread2 end>>>>>>>>>>>>>");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            }
        },"thread2").start();
    }
}
