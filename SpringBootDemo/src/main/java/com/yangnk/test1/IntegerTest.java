package com.yangnk.test1;

public class IntegerTest {

    static Integer integer = new Integer(0);



    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                integer++;
                System.out.println(">>>>>>>>>>>>thread1:i = " + i);
            }
        });


        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                integer++;
                System.out.println(">>>>>>>>>>>>thread2:i = " + i);
            }
        });

        thread1.start();
        thread2.start();
    }
}
