package com.yangnk.mysqldemo.service;

import com.yangnk.mysqldemo.entity.User;
import com.yangnk.mysqldemo.mapper.UserMapper;
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
    UserMapper userMapper;

    public void getUserMapper() {
        User user = userMapper.selectByPrimaryKey(1);
        System.out.println("==========================");
        System.out.println(user.toString());
        System.out.println("==========================");
    }
}
