package com.yangnk.completableFuturn;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;
import java.util.function.Supplier;

/**
 * @author yangnk
 * @desc
 * @date 2023/08/18 00:08
 **/
public class MultiTaskTest {

    public static void main(String[] args) {
        CompletableFuture<Void> f1 = CompletableFuture.runAsync(new Runnable() {

            @Override
            public void run() {
                System.out.println("烧水");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {

                System.out.println("洗茶杯");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "龙井";
            }
        });

        CompletableFuture<String> f3 = f1.thenCombine(f2, new BiFunction<Void, String, String>() {
            @Override
            public String apply(Void unused, String s) {
                return "上茶" + s;
            }
        });

        System.out.println(f3.join());
    }
}