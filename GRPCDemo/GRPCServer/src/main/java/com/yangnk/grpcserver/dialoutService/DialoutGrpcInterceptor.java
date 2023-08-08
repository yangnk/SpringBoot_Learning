package com.yangnk.grpcserver.dialoutService;

import io.grpc.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
//import org.springframework.util.StringUtils;

@Slf4j
public class DialoutGrpcInterceptor implements ServerInterceptor {
    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> serverCall, Metadata metadata, ServerCallHandler<ReqT, RespT> serverCallHandler) {

        String inetSocketString = serverCall.getAttributes().get(Grpc.TRANSPORT_ATTR_REMOTE_ADDR).toString();
        log.info("请求客户端的ip为:{}", inetSocketString);

        return new ForwardingServerCallListener.SimpleForwardingServerCallListener<ReqT>(serverCallHandler.startCall(serverCall, metadata)) {
            private long startTime = 0; //处理开始时间
            private ReqT request;
            private boolean valid = false; //认证状态

            @Override
            public void onComplete() {
                //记录请求参数及耗时
                System.out.println("process cost: " + (System.nanoTime() - startTime));
//                System.out.println("process param: " + request.toString());
                super.onComplete();
            }

            @Override
            public void onMessage(ReqT message) {
                startTime = System.nanoTime();
                request = message;
                log.info("请求客户端的request为:{}", request.toString());
                log.info("开始处理request数据");
                if (StringUtils.equals("king", "id")) {
                    super.onMessage(message);
                } else {
                    valid = false;
                }
            }

            @Override
            public void onHalfClose() {
                //验证失败则返回 Status.UNAUTHENTICATED
                if (!valid) {
                    serverCall.close(Status.UNAUTHENTICATED.withDescription("auth failed"), new Metadata());
                } else {
                    super.onHalfClose();
                }
            }
        };
    }
}
