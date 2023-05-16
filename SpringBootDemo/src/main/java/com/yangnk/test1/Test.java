package com.yangnk.test1;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Test {

    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();

        map.put("1","a");
        map.put("2","b");
        map.put("3", "c");

        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> item :
                entries) {
            String key = item.getKey();
            String value = item.getValue();

            System.out.println("key = " + key);
            System.out.println("value = " + value);
        }

    }
}
