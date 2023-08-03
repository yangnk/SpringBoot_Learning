package com.yangnk.async.jdk;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {
    static ExecutorService executorService = Executors.newFixedThreadPool(3);

    public static void main(String[] args) {

        for (int i = 0; i < 6; i++) {
            executorService.submit(() -> {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
