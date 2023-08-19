package com.yangnk.completableFuturn;

import java.util.concurrent.*;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author yangnk
 * @desc
 * @date 2023/08/17 23:24
 **/
public class AsyncTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);

//        CompletableFuture<Void> f1 = CompletableFuture.runAsync(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(3000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("f1 start");
//            }
//        }, executor);

        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                System.out.println("f2 start");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("f2 end");
                return "f2 return";
            }
        }, executor);



//        CompletableFuture<String> f3 = f2.thenApplyAsync(new Function<String, String>() {
//            @Override
//            public String apply(String s) {
//                System.out.println(s + ",f3 start");
//                return "f3 return";
//            }
//        }, executor);

//        CompletableFuture<Void> f3 = f2.thenAcceptAsync(new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println("f3 start");
//            }
//        }, executor);

//        CompletableFuture<Void> f4 = f2.thenRunAsync(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("f4 start");
//            }
//        }, executor);

//
//        CompletableFuture<String> f7 = f2.whenCompleteAsync((result, e) -> {
//                    System.out.println("f7 start");
//                    if (1 == 1) {
//                        throw new IllegalStateException("f7 IllegalStateException");
//                    }
//                }
//        ).exceptionally(new Function<Throwable, String>() {
//            @Override
//            public String apply(Throwable throwable) {
//                System.out.println("f8 exception: " + throwable);
//                return "f8 return";
//            }
//        });
////
//        CompletableFuture<String> f5 = f2.handleAsync(new BiFunction<String, Throwable, String>() {
//            @Override
//            public String apply(String s, Throwable throwable) {
//                System.out.println("f5 start");
//                if (1 == 1) {
//                    throw new IllegalStateException("f5 IllegalStateException");
//                }
//                return "f5 return";
//            }
//
//        }, executor).exceptionally(new Function<Throwable, String>() {
//            @Override
//            public String apply(Throwable throwable) {
//                System.out.println("f6 exception: " + throwable);
//                return "f6 return";
//            }
//        });
        CompletableFuture<String> f101 = f2.thenCompose(new Function<String, CompletionStage<String>>() {
            @Override
            public CompletionStage<String> apply(String s) {
                CompletableFuture<String> f100 = CompletableFuture.supplyAsync(new Supplier<String>() {
                    @Override
                    public String get() {
                        System.out.println("f100, " + s);
                        return "f100";
                    }
                });
                return f100;
            }
        });

//        boolean aTrue = f2.complete("true");
        System.out.println(f2.join());
        System.out.println(f101.join());


//        f4.get();
//        f4.join();
//        System.out.println(f5.get());
        executor.shutdown();

    }
}