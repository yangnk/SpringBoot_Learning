package com.yangnk.test1;

public class VisibilityTest {

    volatile boolean flag = true;

    void refresh() {
        System.out.println(">>>>>>>>>>refresh start");
        flag = false;
        System.out.println(">>>>>>>>>>refresh start");
    }


    void load() {
        System.out.println(">>>>>>>>>>load start");
        int i = 0;
        while (flag) {
            i++;
            System.out.println("i = " + i);
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
        System.out.println(">>>>>>>>>>load end");
    }

    public static void main(String[] args) throws InterruptedException {
        VisibilityTest visibilityTest = new VisibilityTest();

        Thread thread1 = new Thread(() -> {
            visibilityTest.load();
        });
        thread1.start();

        Thread.sleep(4000);

        Thread thread2 = new Thread(() -> {
            visibilityTest.refresh();
        });
        thread2.start();

    }
}
