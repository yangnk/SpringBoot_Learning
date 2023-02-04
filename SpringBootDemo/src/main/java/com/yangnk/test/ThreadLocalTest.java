package com.yangnk.test;

public class ThreadLocalTest {

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            String ni = String.valueOf(i);
            new Thread(() -> {
                serviceA("accountId_" + ni);
                serviceB();
            }, "thread_" + i).start();
        }
    }

    static class Resource {
        public final static ThreadLocal<String> t = new ThreadLocal<>();
        public final static ThreadLocal<String> t1 = new ThreadLocal<>();

        public static void set(String s) {
            Resource.t.set(s);
        }

        public static String get() {
            return Resource.t.get();
        }
        public static void set1(String s) {
            Resource.t1.set(s);
        }

        public static String get1() {
            return Resource.t1.get();
        }
    }

    static void serviceA(String accountId) {
        String name = Thread.currentThread().getName();
        Resource.set(name);
        Resource.set1(accountId);
        System.out.println("serverA: name = " + name + ", accountId = " + accountId);
    }

    static void serviceB() {
        String name = Thread.currentThread().getName();
        String accountId = Resource.get1();
        System.out.println("serverB: name = " + name + ", accountId = " + accountId);
    }
}
