package com.yangnk.springboothttpclient.httpclientService;

import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.*;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HttpService {
    private static final Logger LOGGER = LoggerFactory.getLogger(HttpService.class);

    public HttpService() {
    }

    public String doGet(String url) {
        return this.doGet(url, (Map)null);
    }

    public String doGet(String url, Map<String, String> parameters) {
        return this.doGet(url, (String)null, (Integer)null, (String)null, parameters);
    }

    public String doGet(String url, String hostName, Integer port, String schemeName, Map<String, String> parameters) {
        CloseableHttpClient client = this.buildClient(hostName, port, schemeName);
        return this.executeGet(client, url, parameters);
    }

    public String doPost(String url) {
        return this.doPost(url, (List)null);
    }

    public String doPost(String url, List<NameValuePair> nameValuePairs) {
        return this.doPost(url, (String)null, (Integer)null, (String)null, nameValuePairs, (List)null);
    }

    public void doPost(String url, List<NameValuePair> nameValuePairs, List<File> files) {
        this.doPost(url, (String)null, (Integer)null, (String)null, nameValuePairs, files);
    }

    public String doPost(String url, String hostName, Integer port, String schemeName, List<NameValuePair> nameValuePairs, List<File> files) {
        CloseableHttpClient client = this.buildClient(hostName, port, schemeName);
        return this.executePost(client, url, nameValuePairs, files);
    }

    private CloseableHttpClient buildClient(String hostName, Integer port, String schemeName) {

        RequestConfig config = RequestConfig.custom().setConnectTimeout(1).
                setConnectionRequestTimeout(1).
                setSocketTimeout(1).build();

        CloseableHttpClient httpClient;
        if (!StringUtils.isEmpty(hostName) && port != null) {
            if (StringUtils.isEmpty(schemeName)) {
                schemeName = "http";
            }

            HttpHost httpHost = new HttpHost(hostName, port, schemeName);
            DefaultProxyRoutePlanner routePlanner = new DefaultProxyRoutePlanner(httpHost);
            httpClient = HttpClients.custom()
                    .setRoutePlanner(routePlanner)
                    .setDefaultRequestConfig(config)
                    .build();
        } else {
//            httpClient = HttpClients.createDefault();
            httpClient = HttpClients.custom()
//                    .setRoutePlanner(routePlanner)
                    .setDefaultRequestConfig(config)
                    .build();
        }

        return httpClient;
    }

    private String executeGet(CloseableHttpClient client, String url, Map<String, String> paramMap) {
        Assert.notNull(url, "url is null");
        Assert.notNull(client, "closeableHttpClient is null");
        String key;
        if (MapUtils.isNotEmpty(paramMap)) {
            List<NameValuePair> paramList = Lists.newArrayListWithExpectedSize(paramMap.size());
            Iterator var5 = paramMap.keySet().iterator();

            while(var5.hasNext()) {
                key = (String)var5.next();
                paramList.add(new BasicNameValuePair(key, (String)paramMap.get(key)));
            }

            url = url + "?" + URLEncodedUtils.format(paramList, Consts.UTF_8);
        }

        CloseableHttpResponse response = null;

        try {
            HttpGet get = new HttpGet(url);
            response = client.execute(get);
            key = this.processResponse(response);
            return key;
        } catch (Exception var10) {
            LOGGER.info("messege:",var10);
//            LOGGER.error(var10.getMessage(), var10.toString());
        } finally {
            this.close(client, response);
        }

        return null;
    }

    private String executePost(CloseableHttpClient httpClient, String url, List<NameValuePair> nameValuePairs, List<File> files) {
        Assert.notNull(url, "url is null");
        Assert.notNull(httpClient, "closeableHttpClient is null");
        CloseableHttpResponse response = null;

        try {
            HttpPost post = new HttpPost(url);

            post.setProtocolVersion(HttpVersion.HTTP_1_0);
            post.addHeader(HTTP.CONN_DIRECTIVE,HTTP.CONN_CLOSE);


            HttpEntity entity = this.buildPostParam(nameValuePairs, files);
            if (entity != null) {
                post.setEntity(entity);
            }

            String json = "{\n    \"username\": \"sys_admin\",\n    \"password\": \"W90$YuEb\"\n}";
            StringEntity requestEntity = new StringEntity(json, "utf-8");
            post.setEntity(requestEntity);
            LOGGER.info("=== post.toString() ==== " + post.toString());
            response = httpClient.execute(post);
            LOGGER.info("=== executePost.response ==== " + response.toString());
            String var10 = this.processResponse(response);
            return var10;
        } catch (Exception var14) {
            LOGGER.error(var14.getMessage(), var14.toString());
        } finally {
            this.close(httpClient, response);
        }

        return null;
    }

    private HttpEntity buildPostParam(List<NameValuePair> nameValuePairs, List<File> files) {
        if (CollectionUtils.isEmpty(nameValuePairs) && CollectionUtils.isEmpty(files)) {
            return null;
        } else if (!CollectionUtils.isNotEmpty(files)) {
            try {
                return new UrlEncodedFormEntity(nameValuePairs);
            } catch (UnsupportedEncodingException var6) {
                LOGGER.error(var6.getMessage(), var6.toString());
                return null;
            }
        } else {
            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            Iterator var4 = files.iterator();

            while(var4.hasNext()) {
                File file = (File)var4.next();
                builder.addBinaryBody(file.getName(), file, ContentType.APPLICATION_OCTET_STREAM, file.getName());
            }

            var4 = nameValuePairs.iterator();

            while(var4.hasNext()) {
                NameValuePair nameValuePair = (NameValuePair)var4.next();
                builder.addTextBody(nameValuePair.getName(), nameValuePair.getValue(), ContentType.create("text/plain", Consts.UTF_8));
            }

            return builder.build();
        }
    }

    private String processResponse(CloseableHttpResponse response) {
        try {
            if (response != null && response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    String var3 = EntityUtils.toString(entity, Consts.UTF_8);
                    return var3;
                }
            }
        } catch (Exception var7) {
            LOGGER.error(var7.getMessage(), var7.toString());
        } finally {
            this.close((CloseableHttpClient)null, response);
        }

        return null;
    }

    private void close(CloseableHttpClient httpClient, CloseableHttpResponse response) {
        try {
            if (response != null) {
                response.close();
            }

            if (httpClient != null) {
                httpClient.close();
            }
        } catch (IOException var4) {
            LOGGER.error(var4.getMessage(), var4.toString());
        }

    }
}
