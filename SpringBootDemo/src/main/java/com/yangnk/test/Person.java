package com.yangnk.test;

import org.springframework.stereotype.Component;

@Component
public class Person {
    public int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
