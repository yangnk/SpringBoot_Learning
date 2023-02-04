package com.yangnk.logindemo.myTest;

import java.util.Random;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2022-04-08 20:15
 **/
public class MyMain {
    public static void main(String[] args) {
        while (true) {

            System.out.println(new Random().nextInt(899999) + 100000);
        }
    }
}
