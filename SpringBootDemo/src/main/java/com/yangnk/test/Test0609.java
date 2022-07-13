package com.yangnk.test;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2022-06-09 11:01
 **/
public class Test0609 {
    public final static void main(String[] args) throws Exception {


        HttpClient httpclient = new DefaultHttpClient();

        try {

            HttpGet httpget = new HttpGet("http://www.baidu.com/");

            System.out.println("executing request " + httpget.getURI());

            // 创建response处理器

            ResponseHandler<String> responseHandler = new BasicResponseHandler();

            String responseBody = httpclient.execute(httpget, responseHandler);

            System.out.println("----------------------------------------");

            System.out.println(responseBody);

            System.out.println("----------------------------------------");


        } finally {

            //HttpClient不再使用时，关闭连接管理器以保证所有资源的释放

            httpclient.getConnectionManager().shutdown();

        }

    }
}
