package com.yangnk.RedisExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.Serializable;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2022-04-07 17:40
 **/
public class UserEntity implements Serializable {

    private static final long serialVersionUID = -6699353467856034592L;

    private Long id;
    private String userName;
    private String userSex;

    @Override
    public String toString() {
        return "UserEntity{" + "id=" + id + ", userName='" + userName + '\'' + ", userSex='" + userSex + '\'' + '}';
    }

    public UserEntity() {
    }

    public UserEntity(Long id, String userName, String userSex) {
        this.id = id;
        this.userName = userName;
        this.userSex = userSex;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

}
