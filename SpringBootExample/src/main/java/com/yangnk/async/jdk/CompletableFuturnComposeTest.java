package com.yangnk.async.jdk;

import java.util.concurrent.CompletableFuture;

/**
 * The type Completable futurn compose test.
 *
 * @author yangnk
 */
public class CompletableFuturnComposeTest {

    /**
     * Completable futurn compose.
     */
    public static void completableFuturnCompose() {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello";
        });
        completableFuture.whenComplete((s, throwable) -> {
            System.out.println(s);
        });



        CompletableFuture<String> completableFuture1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "world";
        });

        completableFuture1.whenComplete((s, throwable) -> {
            System.out.println(s);
        });

        CompletableFuture<String> completableFuture2 = completableFuture1.thenApplyAsync(t ->{
            return "after " + t;
        });
        completableFuture2.whenComplete((s, throwable) -> {
            System.out.println(s);
        });

        CompletableFuture.allOf(completableFuture, completableFuture1).join();
        System.out.println("1." + System.currentTimeMillis());
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        completableFuturnCompose();
        System.out.println("2." + System.currentTimeMillis());

    }
}
