package com.yangnk.redisDemo.service;

import com.yangnk.redisDemo.entity.User;

public interface UserService {
    String selectByPrimaryKey(Integer id);

    void add(User user);

    User selectByName(String name);
}
