package com.yangnk.async.jdk;

/**
 * 通过创建新线程实现异步执行
 */
public class ThreadTest implements Runnable{

    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadTest());
        thread.start();
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName());
    }
}
