package com.yangnk.test1;

public class Test3 {

    public static void main(String[] args) {
        boolean interruptered = true;

        Thread thread = new Thread(() -> {
            while (!Thread.interrupted()) {
                System.out.println("System.currentTimeMillis() = " + System.currentTimeMillis());

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
//                    Thread.currentThread().interrupt();
                }
            }

        });
        thread.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
