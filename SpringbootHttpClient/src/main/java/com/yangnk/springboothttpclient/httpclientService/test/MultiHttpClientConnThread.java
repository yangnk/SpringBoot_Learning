package com.yangnk.springboothttpclient.httpclientService.test;


import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;

import java.io.IOException;

// 执行请求的线程
public class MultiHttpClientConnThread extends Thread {

    private CloseableHttpClient client;

    private HttpGet get;

    public MultiHttpClientConnThread(CloseableHttpClient httpClient, HttpGet get) {
        this.client = httpClient;
        this.get = get;
    }

    @Override
    public void run() {
        CloseableHttpResponse response = null;
        try {
            response = client.execute(get);
            EntityUtils.consume(response.getEntity());

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                IOUtils.closeQuietly(response);
            }
        }
    }
}

