package com.yangnk.async.jdk;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class FutureTest {

    static ExecutorService executorService = Executors.newFixedThreadPool(3);

    public static void main(String[] args) {
        for (int i = 0; i < 6; i++) {
            Future<String> future = executorService.submit(
                    new Callable<String>() {
                        @Override
                        public String call() throws Exception {
                            System.out.println(Thread.currentThread().getName());
                            Thread.sleep((long) (1000 + Math.random() * 1000));
                            return Thread.currentThread().getName();
                        }
                    }
            );
            System.out.println("threadName = " + future);
        }
    }
}
