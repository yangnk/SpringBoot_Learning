package com.yangnk.threadPoolTest;

import lombok.Data;

/**
 * @author yangningkai
 * @create 2022-07-13 15:24
 **/
@Data
public class Experiment{
    String name;
    String network;
    String form;
    int priority;

    public Experiment() {
    }

    public Experiment(String name, String network, String form, int priority) {
        this.name = name;
        this.network = network;
        this.form = form;
        this.priority = priority;
    }
}
