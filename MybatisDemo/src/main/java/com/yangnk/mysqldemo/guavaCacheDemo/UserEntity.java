package com.yangnk.mysqldemo.guavaCacheDemo;

import lombok.Data;

@Data
public class UserEntity {
    String name;
    Integer age;

    public UserEntity(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
