package com.yangnk.springboottestexample.grpcExample;

import com.yangnk.springboottestexample.grpcExample.api.RPCDateRequest;
import com.yangnk.springboottestexample.grpcExample.api.RPCDateResponse;
import com.yangnk.springboottestexample.grpcExample.api.RPCDateServiceGrpc;
import io.grpc.stub.StreamObserver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// RPCDateServiceGrpc.RPCDateServiceImplBase 这个就是接口.
// RPCDateServiceImpl 我们需要继承他的,实现方法回调
public class RPCDateServiceImpl extends RPCDateServiceGrpc.RPCDateServiceImplBase {
    @Override
    public void getDate(RPCDateRequest request, StreamObserver<RPCDateResponse> responseObserver) {
        // 请求结果,我们定义的
        RPCDateResponse rpcDateResponse = null;
        String userName = request.getUserName();
        String response = String.format("你好: %s, 今天是%s.", userName, LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        try {
            // 定义响应,是一个builder构造器.
            rpcDateResponse = RPCDateResponse
                    .newBuilder()
                    .setServerDate(response)
                    .build();
        } catch (Exception e) {
            responseObserver.onError(e);
        } finally {
            // 这种写法是observer,异步写法,老外喜欢用这个框架.
            responseObserver.onNext(rpcDateResponse);
        }
        responseObserver.onCompleted();
    }
}