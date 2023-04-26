package com.yangnk.springboothttpclient.httpclientService.test;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class Test {

    public static void main(String[] args) {
        testMultithreading3(10);
    }

    /**
     * 连接复用：会复用连接池中的已有连接
     *
     * @param num 次数
     */
    public static void testMultithreading3(int num) {
        String url = "http://www.baidu.com";

        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpGet get = new HttpGet(url);

        MultiHttpClientConnThread[] threads = new MultiHttpClientConnThread[num];
        for (int i = 0; i < num; i++) {
            threads[i] = new MultiHttpClientConnThread(httpClient, get);
        }

        try {
            for (int i = 0; i < num; i++) {
                threads[i].start();
            }

            for (int i = 0; i < num; i++) {
                threads[i].join();
            }
        } catch (InterruptedException e) {
            System.out.println("线程执行异常" + e);
        }
    }
}
