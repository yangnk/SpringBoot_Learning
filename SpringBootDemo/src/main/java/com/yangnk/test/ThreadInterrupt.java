package com.yangnk.test;

import java.util.Date;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2022-04-01 19:33
 **/
public class ThreadInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new MyThread());
        thread.start();
        Thread.sleep(4000);
        thread.interrupt();
    }

    private static class MyThread implements Runnable {
        boolean isInterrupted = true;

        @Override
        public void run() {
            while (isInterrupted) {
                System.out.println("========================" + new Date());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    return;
                }
            }
        }
    }
}
