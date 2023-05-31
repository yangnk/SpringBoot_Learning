package com.yangnk.test3;

import org.springframework.stereotype.Service;

@Service
public class MyServiceImpl implements MyService{
    @Override
    public String getName(String name) {
        return name + ", hello";
    }
}
