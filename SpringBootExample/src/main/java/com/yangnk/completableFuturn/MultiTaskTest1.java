package com.yangnk.completableFuturn;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.*;

/**
 * @author yangnk
 * @desc
 * @date 2023/08/18 00:08
 **/
public class MultiTaskTest1 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                System.out.println("f1 running");
                try {
                    Thread.sleep(6000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "f1 return";
            }
        }, executor);

        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                System.out.println("f2 running");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "f2 return";
            }
        }, executor);

        CompletableFuture<String> f30 = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                System.out.println("f30 running");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "f30 return";
            }
        }, executor);


        CompletableFuture<String> f3 = f1.thenCombine(f2, new BiFunction<String, String, String>() {
            @Override
            public String apply(String s, String s2) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(s + "," + s2 + "," + "f3 running");
                return "f3 ruturn";
            }
        });

        CompletableFuture<Void> f4 = f1.thenAcceptBoth(f2, new BiConsumer<String, String>() {
            @Override
            public void accept(String s, String s2) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(s + "," + s2 + "," + "f4 running");
            }
        });


        CompletableFuture<Void> f5 = f1.runAfterBoth(f2, new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("f5 running");
            }
        });


        CompletableFuture<String> f6 = f1.applyToEither(f2, new Function<String, String>() {
            @Override
            public String apply(String s) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(s + "," + "f6 running");
                return "return f6";
            }

        });


        CompletableFuture<Void> f7 = f1.acceptEither(f2, new Consumer<String>() {
            @Override
            public void accept(String s) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(s + "," + "f7 running");
            }
        });

        CompletableFuture<Void> f8 = f1.runAfterEither(f2, new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("f7 running");
            }
        });
//

        CompletableFuture<Void> f9 = CompletableFuture.allOf(f1, f2, f30);
        CompletableFuture<Object> f10 = CompletableFuture.anyOf(f1, f2, f30);
        System.out.println(f10.join());

        System.out.println("main running");


        executor.shutdown();
    }

}