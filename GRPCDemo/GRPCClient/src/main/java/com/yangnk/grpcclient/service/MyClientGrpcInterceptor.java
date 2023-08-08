package com.yangnk.grpcclient.service;

import io.grpc.*;
import lombok.extern.slf4j.Slf4j;

/**
 * @author yangnk
 * @desc
 * @date 2023/08/08 00:15
 **/
@Slf4j
public class MyClientGrpcInterceptor implements ClientInterceptor {


    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> method, CallOptions callOptions, Channel next) {
        Metadata.Key<String> token = Metadata.Key.of("token", Metadata.ASCII_STRING_MARSHALLER);
        Metadata.Key<String> userId = Metadata.Key.of("userId", Metadata.ASCII_STRING_MARSHALLER);


        //1.打印日志
        log.info("请求名称：{}", method.getFullMethodName());

        //2.请求参数放到header中
        return new ForwardingClientCall.SimpleForwardingClientCall<ReqT, RespT>(next.newCall(method, callOptions)) {
            @Override
            public void start(Listener<RespT> responseListener, Metadata headers) {
                //此处为你登录后获得的token的值
                headers.put(userId, "00000001");
                headers.put(token, "A2D05E5ED2414B1F8C6AEB19F40EF77C");
                super.start(new ForwardingClientCallListener.SimpleForwardingClientCallListener<RespT>(responseListener) {
                    @Override
                    public void onHeaders(Metadata headers) {
                        log.info("请求返回信息为:" + headers);
                        super.onHeaders(headers);
                    }
                }, headers);
            }
        };
    }
}