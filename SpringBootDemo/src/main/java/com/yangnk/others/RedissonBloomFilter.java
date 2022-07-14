//package com.yangnk.others;
//
///**
// * ${DESCRIPTION}
// *
// * @author yangningkai
// * @create 2022-02-18 16:31
// **/
//
//import org.redisson.Redisson;
//import org.redisson.api.RBucket;
//import org.redisson.api.RedissonClient;
//import org.redisson.config.Config;
//import org.springframework.context.annotation.Configuration;
//
//public class RedissonBloomFilter {
//
//    public static void main(String[] args) {
//        Config config = new Config();
//        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
////        config.useSingleServer().setPassword("123");
//        //构造Redisson
//        RedissonClient redisson = Redisson.create(config);
//        RBucket<Object> city = redisson.getBucket("city");
//        city.set("hangzhou");
//        System.out.println(city.get().toString());
////        RBloomFilter<String> bloomFilter = redisson.getBloomFilter("phoneList");
////        //初始化布隆过滤器：预计元素为100000000L,误差率为3%
////        bloomFilter.tryInit(100000000L,0.03);
////        //将号码10086插入到布隆过滤器中
////        bloomFilter.add("10086");
////
////        //判断下面号码是否在布隆过滤器中
////        System.out.println("=================================");
////        System.out.println(bloomFilter.contains("123456"));//false
////        System.out.println("=================================");
////        System.out.println(bloomFilter.contains("10086"));//true
//    }
//
//    /**
//     * ${DESCRIPTION}
//     *
//     * @author yangningkai
//     * @create 2022-02-25 14:55
//     **/
//    @Configuration
//    public static class MyConfigure {
//        public String setString() {
//            return new String();
//        }
//    }
//}
