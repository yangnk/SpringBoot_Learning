package com.yangnk.dynamicThreadPool;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.concurrent.*;

@Service
@Slf4j
public class MyService {

    @Autowired
    ThreadPoolExecutor executor;

    void startExeperiment(int size) {
        for (int i = 0; i < size; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(">>>>>>>>" + Thread.currentThread().getName());
                    try {
                        int corePoolSize = executor.getCorePoolSize();
                        int maximumPoolSize = executor.getMaximumPoolSize();
                        int size1 = executor.getQueue().size();
                        int activeCount = executor.getActiveCount();
                        log.info("corePoolSize:{},maximumPoolSize:{},activeCount:{},queueSize:{}", corePoolSize, maximumPoolSize, activeCount, size1);
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    void changeSize(int size) {
        executor.setCorePoolSize(executor.getCorePoolSize() + size);
        executor.setMaximumPoolSize(executor.getMaximumPoolSize() + size);
    }

    void noVmExeperiment(int size) {
        int corePoolSize = executor.getCorePoolSize();
        int maxPoolSize = executor.getMaximumPoolSize();
        executor.setCorePoolSize(corePoolSize + size);
        executor.setMaximumPoolSize(maxPoolSize + size);
        CountDownLatch latch = new CountDownLatch(size);
        for (int i = 0; i < size; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>noVmExeperiment:" + Thread.currentThread().getName());
                    try {
                        int corePoolSize1 = executor.getCorePoolSize();
                        int maximumPoolSize = executor.getMaximumPoolSize();
                        int size1 = executor.getQueue().size();
                        int activeCount = executor.getActiveCount();
                        log.info("corePoolSize1:{},maximumPoolSize:{},activeCount:{},queueSize:{}", corePoolSize1, maximumPoolSize, activeCount, size1);
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    latch.countDown();
                }
            });
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("end of countDown");
        executor.setCorePoolSize(corePoolSize);//执行完成后核心线程数回退到默认值
        executor.setMaximumPoolSize(maxPoolSize);//执行完成后核心线程数回退到默认值
    }
}
