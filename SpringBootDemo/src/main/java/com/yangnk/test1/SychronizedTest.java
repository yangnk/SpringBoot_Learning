package com.yangnk.test1;

public class SychronizedTest {
    private static int num = 0;

    private synchronized void add() {
        System.out.println("start add");
        for (int i = 0; i < 10000; i++) {
            num++;
            System.out.println("after add, num = " + num);
        }
    }

    private synchronized void sub() {
        System.out.println("start sub");
        for (int i = 0; i < 10000; i++) {
            num--;
            System.out.println("after sub, num = " + num);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SychronizedTest sychronizedTest = new SychronizedTest();
        Thread thread1 = new Thread(()->{
            sychronizedTest.add();
        });
        Thread thread2 = new Thread(()->{
            sychronizedTest.sub();
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();


        System.out.println("num = " + num);
    }
}
