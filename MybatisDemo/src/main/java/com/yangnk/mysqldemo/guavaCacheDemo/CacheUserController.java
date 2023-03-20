package com.yangnk.mysqldemo.guavaCacheDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cache")
public class CacheUserController {

    @Autowired
    private CacheUserService userService;

    @Autowired
    private CacheManager cacheManager;

    @GetMapping("/users/{name}")
    public ResponseEntity<UserEntity> getUser(@PathVariable String name) {
        System.out.println("=========查询=========");
        UserEntity user = userService.getUserByName(name);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/users/{name}")
    public ResponseEntity<UserEntity> putUser(@PathVariable String name) {
        System.out.println("=========存储=========");
        UserEntity user = userService.putUserByName(name);
        return ResponseEntity.ok(user);
    }
}
