package com.yangnk.hfn.MY_TEST;

import lombok.SneakyThrows;

public class Test {

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                Thread.sleep(3000);
            }
        }, "t1");
        thread.start();

    }

}
