package com.yangnk.TCCSample1;

import com.yangnk.dao.TUserMapper;
import com.yangnk.entity.TUser;
import com.yangnk.entity.TUserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController1 {

    @Autowired
    TUserMapper tUserMapper;

    @GetMapping("/test")
    public String index() {
        List<TUser> tUsers = tUserMapper.selectByExample(new TUserExample());
        return tUsers.toString();
    }

}

