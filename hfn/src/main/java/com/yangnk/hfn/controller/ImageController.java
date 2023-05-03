package com.yangnk.hfn.controller;

import com.yangnk.hfn.entity.Image;
import com.yangnk.hfn.service.ImageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/image")
public class ImageController {

    @Autowired
    ImageService imageService;

    @RequestMapping(value = "/getImageList", method = RequestMethod.GET)
    public String getImageList() {
        List<Image> images = imageService.getImages();
        log.info("images list info:{}", images.toString());
        return images.toString();
    }

    @RequestMapping(value = "/getImageInfo", method = RequestMethod.GET)
    public String getImageInfo(@RequestParam(value = "name") String name) {
        Image image = imageService.getImageInfo(name);
        if (image == null) {
            return "image " + name + " not exist.";
        }
        return image.toString();
    }

    @RequestMapping(value = "/saveImageInfo", method = RequestMethod.POST)
    public String saveImageInfo(@RequestBody Image image) {
        int count = imageService.saveImageInfo(image);
        return image.toString();
    }
}
