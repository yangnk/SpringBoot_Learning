package com.yangnk.ThreadPoolTest;

import java.util.Comparator;
import java.util.concurrent.*;

/**
 * @author yangningkai
 * @create 2022-07-13 15:16
 **/

//实现优先队列的线程池
public class ThreadPoolTest {
    public static void main(String[] args) {
        BlockingQueue<Runnable> myQueue = new PriorityBlockingQueue(10, new Comparator<Thread1>() {
            @Override
            public int compare(Thread1 o1, Thread1 o2) {
                return o1.experiment.priority - o2.experiment.priority;
            }
        });
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,
                20,
                1000,
                TimeUnit.MILLISECONDS,
                myQueue,
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy());

        for (int i = 0; i < 10; i++) {
            int num = (int) (Math.random() * 10);
            Experiment experiment = new Experiment("a" + num, "b" + num, "c" + num, num);
            threadPoolExecutor.execute(new Thread1(experiment));
        }
    }

    private static class Thread1 implements Runnable {
        Experiment experiment;
        public Thread1(Experiment experiment) {
            this.experiment = experiment;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            System.out.println(experiment.name);
        }
    }
}
