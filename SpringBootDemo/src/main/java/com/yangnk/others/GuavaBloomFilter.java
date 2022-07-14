//package com.yangnk.others;
//
///**
// * ${DESCRIPTION}
// *
// * @author yangningkai
// * @create 2022-02-18 16:44
// **/
//
//import com.google.common.base.Charsets;
//import com.google.common.hash.BloomFilter;
//import com.google.common.hash.Funnel;
//import com.google.common.hash.Funnels;
//
//public class GuavaBloomFilter {
//    public static void main(String[] args) {
//        BloomFilter<String> bloomFilter = BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8), 100000, 0.01);
//
//        bloomFilter.put("10086");
//
//        System.out.println(bloomFilter.mightContain("123456"));
//        System.out.println(bloomFilter.mightContain("10086"));
//    }
//}