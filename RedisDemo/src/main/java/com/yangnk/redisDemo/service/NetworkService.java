package com.yangnk.redisDemo.service;

import com.yangnk.redisDemo.dao.NetworkMapper;
import com.yangnk.redisDemo.entity.Network;
import com.yangnk.redisDemo.utils.RedisUtils;
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
public class NetworkService {
    @Autowired
    NetworkMapper networkMapper;
    @Autowired
    RedisUtils redisUtils;
    @Autowired
    JedisPool jedisPool;

    /**
     * 根据id查找network网络信息
     * @param id
     * @return
     */
    public String selectByPrimaryKey(Integer id) {
        Network network = networkMapper.selectByPrimaryKey(id);
        System.out.println(network.getNetwork().toString());
        return network.getNetwork();
    }

    /**
     * 将network网络数据添加到mysql和redis中
     * @param network
     */
    public void addNetwork(Network network) {
        //添加到mysql数据库中
        int result = networkMapper.insert(network);
        log.info("=====addNetwork into mysql:{}=====",network.toString());
        //添加到缓存数据库redis中
        if (result > 0) {
            Jedis jedis = jedisPool.getResource();
            redisUtils.setValue(jedis, network.getId().toString(), network.getNetwork());
            log.info("=====addNetwork into redis:{}=====",network.toString());
        }
    }

    /**
     * 根据id查询网络信息，先查redis，redis没有再查询mysql
     * @param id
     */
    public String selectNetwork(String id) {
        //先查询redis，redis中有从redis中取；没有的话从mysql中取，并更新到redis中
        Jedis jedis = jedisPool.getResource();
        String value = redisUtils.getValue(jedis, id);
        log.info("=====selectNetwork from redis, value is:{}=====", value);
        if (!StringUtils.isEmpty(value)) {
            return value;
        } else {
            Network network = networkMapper.selectByPrimaryKey(Integer.parseInt(id));
            redisUtils.setValue(jedis, id, network.getNetwork());
            log.info("=====selectNetwork from mysql and add redis, value is:{}=====", value);
            return network.getNetwork();
        }
    }
}
