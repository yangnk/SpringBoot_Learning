package com.yangnk.test2;

import java.util.concurrent.ConcurrentHashMap;

public class Test1 {

    public static void main(String[] args) {
        ConcurrentHashMap<String, ConcurrentHashMap<String, String>> hashMap = new ConcurrentHashMap<>();

        hashMap.put("123", new ConcurrentHashMap<>(0));
        int size = hashMap.get("123").size();
        System.out.println("size = " + size);
        System.out.println("hashMap = " + hashMap);
        ConcurrentHashMap<String, String> hashMap1 = new ConcurrentHashMap<>();
        hashMap1.put("vm1", "status1");
        hashMap1.put("vm2", "status2");
        hashMap.put("123", hashMap1);

        System.out.println("hashMap = " + hashMap);

    }
}
