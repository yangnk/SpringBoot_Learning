package com.yangnk.dynamicThreadPool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.concurrent.*;

@Service
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
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    void noVmExeperiment(int size) {
        int corePoolSize = executor.getCorePoolSize();
        executor.setCorePoolSize(corePoolSize + size);//执行该类任务时动态扩容核心线程数
        for (int i = 0; i < size; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(">>>>>>>>noVmExeperiment:" + Thread.currentThread().getName());
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        executor.setCorePoolSize(corePoolSize);//执行完成后核心线程数回退到默认值
    }
}
