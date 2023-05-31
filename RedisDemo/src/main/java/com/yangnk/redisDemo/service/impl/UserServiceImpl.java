package com.yangnk.redisDemo.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yangnk.redisDemo.entity.User;
import com.yangnk.redisDemo.mapper.UserMapper;
import com.yangnk.redisDemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2022-06-07 10:13
 **/
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    JedisPool jedisPool;

    /**
     *
     * @param id
     * @return
     */
    public String selectByPrimaryKey(Integer id) {
        Jedis jedis = jedisPool.getResource();
        //如果查询出来的结果为空则查询数据库，再写入redis；如果查询处理的结果非空则直接返回
        String userInfo = jedis.get(String.valueOf(id));
        User user = null;
        if (!StringUtils.isEmpty(userInfo)) {
            return userInfo;
        } else {
//            String s = JSON.toJSONString(user);
            user = userMapper.selectByPrimaryKey(id);
            jedis.set(String.valueOf(id), JSON.toJSONString(user));
            return user.toString();
        }
    }

    public void add(User user) {
        Jedis jedis = jedisPool.getResource();
        userMapper.insert(user);
        jedis.del(String.valueOf(user.getId()));
        log.info("delete userId:{} success.",user.getId());
    }

    @Override
    public User selectByName(String name) {
        Jedis jedis = jedisPool.getResource();
        String userInfo = jedis.get(name);
        User user = null;
        if (!StringUtils.isEmpty(userInfo)) {
            return JSONObject.parseObject(userInfo, User.class);
        } else {
            user = userMapper.selectByName(name);
            jedis.set(name, JSON.toJSONString(user));
            return user;
        }
    }
}
