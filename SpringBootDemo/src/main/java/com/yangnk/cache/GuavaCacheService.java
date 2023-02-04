package com.yangnk.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.junit.platform.commons.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GuavaCacheService {

    public static void main(String[] args) {
        GuavaCacheService guavaCacheService = new GuavaCacheService();
        ArrayList<String> list = new ArrayList<>();
        list.add("value");
        guavaCacheService.put("key", list);
        System.out.println("guavaCacheService = " + guavaCacheService.get("key"));

    }

    /**
     * 缓存操作对象
     */
    private final LoadingCache<String, List<String>> nameCache = loadCache(new CacheLoader<String, List<String>>() {
        @Override
        public List<String> load(String s) throws Exception {
            return null;
        }
//        @Override
//        public List<String> load(String key) {
//            // 从数据库加载，当key对应的value不存在时的处理逻辑
//            return databaseManager.getNamesByClassId(key);
//        }
    });

    /**
     * 缓存设置
     * 缓存项最大数量：10000
     * 缓存有效时间（天）：1
     */
    private LoadingCache<String, List<String>> loadCache(CacheLoader<String, List<String>> cacheLoader) {
        return CacheBuilder.newBuilder()
                .concurrencyLevel(Runtime.getRuntime().availableProcessors())
                // 设置初始容量
                .initialCapacity(1000)
                // 缓存池大小
                .maximumSize(10000)
                // 设置 设定时间 后 刷新缓存
                .refreshAfterWrite(1, TimeUnit.DAYS)
                .build(cacheLoader);
    }

    /**
     * 设置缓存值
     * 若已有该key值，则会先移除(会触发removalListener移除监听器)，再添加
     */
    public void put(String key, List<String> value) {
        if (StringUtils.isBlank(key) || value == null) {
            return;
        }
        try {
            nameCache.put(key, value);
        } catch (Exception e) {
//            log.info("设置缓存值出错", e);
        }
    }

    /**
     * 获取缓存值
     * 如果键不存在值，将调用CacheLoader的load方法，将load方法的返回值加载到缓存
     */
    public List<String> get(String key) {
        List<String> token = null;
        try {
            token = nameCache.get(key);
        } catch (Exception e) {
//            log.info("获取缓存值出错", e);
        }
        return token;
    }
}
