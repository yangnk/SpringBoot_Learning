package com.yangnk.test;

import com.yangnk.ThreadPoolTest.Experiment;

import java.util.ArrayList;
import java.util.List;

public class TestOOM {
    public static void main(String[] args) throws InterruptedException {
        List<Experiment> list = new ArrayList<>();
        while (true) {
            list.add(new Experiment());
//            Thread.sleep(10);
        }
    }

}
