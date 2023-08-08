package com.yangnk.grpcserver.dialoutService;

import io.grpc.*;
import io.grpc.netty.shaded.io.netty.util.internal.StringUtil;
import lombok.extern.slf4j.Slf4j;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yangnk
 * @desc
 * @date 2023/08/07 23:17
 **/
@Slf4j
public class MyServerGrpcInterceptor implements ServerInterceptor {
    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> serverCall, Metadata metadata, ServerCallHandler<ReqT, RespT> serverCallHandler) {
        //1.打印请求方法
        log.info("请求方法：{}", serverCall.getMethodDescriptor());

        //2.从请求的属性中获取远程地址
        String remoteAddr = serverCall.getAttributes().get(Grpc.TRANSPORT_ATTR_REMOTE_ADDR).toString();
        log.info("远程地址为：{}", remoteAddr);

        //3.获取header中的参数进行业务处理
        Map<String, String> map = new HashMap<String, String>();
        map.put("00000001", "admin");

        //获取header中参数
        Metadata.Key<String> token = Metadata.Key.of("token", Metadata.ASCII_STRING_MARSHALLER);
        Metadata.Key<String> userId = Metadata.Key.of("userId", Metadata.ASCII_STRING_MARSHALLER);

        String tokenStr = metadata.get(token);
        if (StringUtil.isNullOrEmpty(tokenStr)){
            System.err.println("未收到客户端token,关闭此连接");
            serverCall.close(Status.DATA_LOSS,metadata);
        }
        //获得token去中查询
        String userInfo = map.get(metadata.get(userId));
        if(StringUtil.isNullOrEmpty(userInfo)){
            System.err.println("客户端token错误,关闭此连接");
            serverCall.close(Status.DATA_LOSS,metadata);
        }

        //服务端写回参数
        ServerCall<ReqT, RespT> newServerCall = new ForwardingServerCall.SimpleForwardingServerCall<ReqT, RespT>(serverCall) {
            @Override
            public void sendHeaders(Metadata headers) {
                headers.put(userId,userInfo);
                super.sendHeaders(headers);
            }
        };
        return serverCallHandler.startCall(newServerCall, metadata);
    }
}