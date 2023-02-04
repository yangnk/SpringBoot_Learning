package com.yangnk.SPIDemo;

public class RedisStorage implements DataStorage{

    @Override
    public String search(String key) {
        return "【Redis】搜索" + key + "，结果：Yes";
    }
}
