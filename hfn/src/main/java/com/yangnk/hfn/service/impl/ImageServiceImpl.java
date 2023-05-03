package com.yangnk.hfn.service.impl;


import com.yangnk.hfn.dao.ImageMapper;
import com.yangnk.hfn.entity.Image;
import com.yangnk.hfn.entity.ImageExample;
import com.yangnk.hfn.service.ImageService;
import com.yangnk.hfn.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

@Slf4j
@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    ImageMapper imageMapper;

    @Autowired
    JedisPool jedisPool;

    public List<Image> getImages() {
        List<Image> images = imageMapper.selectByExample(new ImageExample());
        return images;
    }

    @Override
    public Image getImageInfo(String name) {
        Jedis jedis = jedisPool.getResource();
        List<String> imageListValue = RedisUtil.getListValue(jedis, name);
        Image image = null;
        if (imageListValue.size() == 0 || imageListValue == null) {
            image = imageMapper.selectByName(name);
            //缓存中没有则更新redis缓存数据
            RedisUtil.rpush(jedis, name, image.getImagealiasname(), image.getImageinfo());
//            Long res = RedisUtil.hset(jedis, name, image);

        } else {
            image = new Image();
            image.setImagename(name);
            image.setImagealiasname(imageListValue.get(0));
            image.setImageinfo(imageListValue.get(1));
        }

        if (ObjectUtils.isEmpty(image)) {
            return null;
        }
        log.info("========image info is:{}======", image);
        return image;
    }

    @Override
    public int saveImageInfo(Image image) {
        int res = imageMapper.insert(image);
        //缓存数据，在做更新数据库操作时做一次删除，保障数据一致性
        Jedis jedis = jedisPool.getResource();
        RedisUtil.delValue(jedis, image.getImagename());
        return res;
    }
}
