package com.yangnk.jpademo.service;

import com.yangnk.jpademo.dao.UserRepository;
import com.yangnk.jpademo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2022-04-13 14:56
 **/
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getUser() {
        List<User> userList = userRepository.selectUser();
        for (User item : userList) {
            System.out.println(item.toString());

        }
        return userList;
    }
}
