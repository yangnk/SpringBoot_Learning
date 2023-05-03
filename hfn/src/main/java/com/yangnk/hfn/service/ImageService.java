package com.yangnk.hfn.service;

import com.yangnk.hfn.entity.Image;

import java.util.List;

public interface ImageService {
    /**
     * 获取所有镜像信息
     * @return
     */
    List<Image> getImages();

    /**
     * 根据imageName查询image信息
     * @param name
     * @return
     */
    Image getImageInfo(String name);

    /**
     * 保存镜像信息
     * @param image
     * @return
     */
    int saveImageInfo(Image image);
}
