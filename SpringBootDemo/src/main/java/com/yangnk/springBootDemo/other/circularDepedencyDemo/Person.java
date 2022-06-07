package com.yangnk.springBootDemo.other.circularDepedencyDemo;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2022-03-04 22:26
 **/
public class Person {
    private String name;
    private Integer age;

    public Person() {
    }

    public Person(String name, Integer age) {
        System.out.println(" 对象被创建了.............");
        this.name = name;
        this.age = age;
    }

    // 省略 getter setter 和 toString 方法
}