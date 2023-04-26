package com.yangnk.test1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class ThreadTest {

    public static void main(String[] args) throws InterruptedException {

        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        long start = System.currentTimeMillis();

//        ExecutorService executor = Executors.newSingleThreadExecutor();


        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 6, 3, TimeUnit.SECONDS, new ArrayBlockingQueue<>(3));

        CountDownLatch countDownLatch = new CountDownLatch(1);
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100000; i++) {
                    int anInt = random.nextInt();
                    list.add(anInt);
                }
                countDownLatch.countDown();
            }
        });
        countDownLatch.await();
        threadPoolExecutor.shutdown();
        long end = System.currentTimeMillis();
        System.out.println("end - start = " + (end - start));
        System.out.println("list.size() = " + list.size());


//        Random random = new Random();
//        List<Integer> list = new ArrayList<>();
//        long start = System.currentTimeMillis();
//
//        Thread thread = new Thread(() -> {
//            for (int i = 0; i < 100; i++) {
//                int anInt = random.nextInt();
//                list.add(anInt);
//            }
//        });
//        thread.start();
//        thread.join();
//        long end = System.currentTimeMillis();
//
//        System.out.println("end - start = " + (end - start));
//        System.out.println("list.size() = " + list.size());
    }
}
