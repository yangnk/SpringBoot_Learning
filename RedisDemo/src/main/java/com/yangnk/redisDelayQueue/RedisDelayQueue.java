package com.yangnk.redisDelayQueue;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2022-05-17 00:04
 **/

//java + redis zset实现延迟队列（定时到期执行任务）
//https://blog.csdn.net/liaomingwu/article/details/123069700

//    设计思路：
//            利用redis的zset可以按照score排序的特性来实现延迟队列。
//            需要一个添加任务的线程，一个监听zset中任务是否过期的线程。其中添加任务的线程将任务和时间添加到zset中，其中时间为目前时间+延时时间。
//            另一方面监听线程轮训zset中的数据，按照目前时间取出zset中的值，这样就会取出过期时间的任务，之后再讲该任务删除，用以实现延期任务的效果。

public class RedisDelayQueue {

    public static void main(String[] args) {

        System.out.println("begin time:" + LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

        RedisProduceThread produceThread = new RedisProduceThread();
        produceThread.start();

        RedisConsumeThread consumeThread = new RedisConsumeThread();
        consumeThread.start();
    }

//    public static class DelayTask {
//
//        /* 触发时间*/
//        private long time;
//        private String name;
//
//        public long getTime() {
//            return time;
//        }
//
//        public void setTime(long time) {
//            this.time = time;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//    }

    // 添加任务线程
    public static class RedisProduceThread extends Thread {

        public RedisProduceThread() {
        }

        @Override
        public void run() {

            Jedis jedis = new Jedis("127.0.0.1", 6379);

            while (true) {
                long timeMillis = System.currentTimeMillis();

                Random rnd = new Random();
                int i = rnd.nextInt(30);

                double delay = timeMillis / 1000 + i;

                jedis.zadd("myzset", delay, "item-" + i);

                Double doubleDelay = delay;
                long longDelay = doubleDelay.longValue();

                System.out.println("添加业务:item-" + i + ",添加时间：" + timeMillis / 1000 + " ,到期时间：" + longDelay + ",延迟时间:" + i + " 秒");

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }
    }

    // 读取到期任务线程
    public static class RedisConsumeThread extends Thread {

        public RedisConsumeThread() {
        }

        @Override
        public void run() {

            Jedis jedis = new Jedis("127.0.0.1",6379);

            while (true) {

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                // 从redis读取时间最小的数据
                long timestamp = System.currentTimeMillis() / 1000;

                Set<Tuple> myzset = jedis.zrangeWithScores("myzset", 0, 1);

                // 如果读取记录为空
                if(myzset.isEmpty())
                {
                    // 延时1秒
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    continue;
                }

                Iterator<Tuple> iterator = myzset.iterator();

                while (iterator.hasNext())
                {
                    Tuple tuple = iterator.next();
                    String item = tuple.getElement();
                    Double score = tuple.getScore();

                    // 如果当前记录到期
                    if(timestamp >= score)
                    {
                        long lscore = score.longValue();

                        // 执行业务处理
                        System.out.println("到期业务:" + item + " ,到期时间：" + lscore + ",系统时间：" + timestamp);

                        // 处理完成后，删除当前记录
                        jedis.zrem("myzset", item);

                        // 继续循环读取下一条
                    }
                    else
                    {
                        // 最小记录未到期，延时1秒
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }


            }

        }
    }

}

