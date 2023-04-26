package com.yangnk.mysqldemo.service;

import com.yangnk.mysqldemo.dao.User1Mapper;
import com.yangnk.mysqldemo.entity.User1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2022-04-07 22:36
 **/
@Service
public class UserService {
    @Autowired
    User1Mapper userMapper;

    public User1 getUserMapper() {
        User1 user = userMapper.selectByPrimaryKey(2);
        System.out.println("==========================");
        System.out.println(user.toString());
        System.out.println("==========================");
        return user;
    }

    public String getUserName() {
        String name= userMapper.selectUserNameById(1);
        System.out.println("==========================");
        System.out.println(name);
        System.out.println("==========================");
        return name;
    }

    public User1 setUserMapper() {
        User1 user = new User1();
        user.setId(20);
        user.setUserName("hhh");
        user.setPassword("666666");
        user.setSex("abc");
        userMapper.insert(user);
        System.out.println("==========================");
        System.out.println(user.toString());
        System.out.println("==========================");
        return user;
    }
}
