package com.yangnk.dynamicThreadPool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.concurrent.ThreadPoolExecutor;

@Service
public class MyServce {
    @Autowired
    @Qualifier("threadPoolExecutor")
    ThreadPoolExecutor threadPoolExecutor;

    public void execTask(int size) {
        for (int i = 0; i < size; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            threadPoolExecutor.execute(new MyThread());
        }
    }

    public void changeExecutor(int coreSize, int maxSize) {
        System.out.println("before coreSize = " + threadPoolExecutor.getPoolSize());
        System.out.println("before maxSize = " + threadPoolExecutor.getMaximumPoolSize());
        threadPoolExecutor.setCorePoolSize(coreSize);
        threadPoolExecutor.setMaximumPoolSize(maxSize);
        System.out.println("after coreSize = " + threadPoolExecutor.getCorePoolSize());
        System.out.println("after maxSize = " + threadPoolExecutor.getMaximumPoolSize());
        }


    private static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println(System.currentTimeMillis() + ":" + Thread.currentThread().getName() + " start.");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(System.currentTimeMillis() + ":" + Thread.currentThread().getName() + " end.");
        }
    }
}
