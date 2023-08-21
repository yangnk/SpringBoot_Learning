package com.yangnk.dynamicThreadPool.v2;

import cn.hutool.core.thread.NamedThreadFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/**
 * @author yangnk
 * @desc
 * @date 2023/08/21 16:54
 **/
public class ThreadChangeDemo {

    public static void main(String[] args) {
        dynamicModifyExecutor();
    }

    private static ThreadPoolExecutor buildThreadPoolExecutor() {
        return new ThreadPoolExecutor(2,
                5,
                60,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10),
                new NamedThreadFactory("test-", false));
    }

    private static void dynamicModifyExecutor() {
        ThreadPoolExecutor executor = buildThreadPoolExecutor();
        executor.allowCoreThreadTimeOut(true);
        for (int i = 0; i < 15; i++) {
            executor.execute(() -> {
                threadPoolStatus(executor,"创建任务");
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        threadPoolStatus(executor,"改变之前");
        executor.setCorePoolSize(10);
        executor.setMaximumPoolSize(10);
        ResizeableCapacityLinkedBlockingQueue<Runnable> queue = (ResizeableCapacityLinkedBlockingQueue)executor.getQueue();
        queue.setCapacity(100);
        threadPoolStatus(executor,"改变之后");
        while (executor.getActiveCount() > 0) {

        }
        executor.shutdown();
    }

    /**
     * 打印线程池状态
     *
     * @param executor
     * @param name
     */
    private static void threadPoolStatus(ThreadPoolExecutor executor, String name) {
        BlockingQueue<Runnable> queue = executor.getQueue();
        System.out.println(Thread.currentThread().getName() + "-" + name + "-:" +
                "核心线程数：" + executor.getCorePoolSize() +
                " 活动线程数：" + executor.getActiveCount() +
                " 最大线程数：" + executor.getMaximumPoolSize() +
                " 线程池活跃度：" +
                divide(executor.getActiveCount(), executor.getMaximumPoolSize()) +
                " 任务完成数：" + executor.getCompletedTaskCount() +
                " 队列大小：" + (queue.size() + queue.remainingCapacity()) +
                " 当前排队线程数：" + queue.size() +
                " 队列剩余大小：" + queue.remainingCapacity() +
                " 队列使用度：" + divide(queue.size(), queue.size() + queue.remainingCapacity()));
    }

    private static String divide(int num1, int num2) {
        return String.format("%1.2f%%", Double.parseDouble(num1 + "") / Double.parseDouble(num2 + "") * 100);
    }
}