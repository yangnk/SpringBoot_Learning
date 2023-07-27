package com.yangnk.springboottestexample.grpcExample;

import com.yangnk.springboottestexample.grpcExample.api.RPCDateRequest;
import com.yangnk.springboottestexample.grpcExample.api.RPCDateResponse;
import com.yangnk.springboottestexample.grpcExample.api.RPCDateServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GRPCClient {
    private static final String host = "localhost";
    private static final int serverPort = 9999;

    public static void main(String[] args) throws Exception {
        // 1. 拿到一个通信的channel
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress(host, serverPort).usePlaintext().build();
        try {
            // 2.拿到道理对象
            RPCDateServiceGrpc.RPCDateServiceBlockingStub rpcDateService = RPCDateServiceGrpc.newBlockingStub(managedChannel);
            RPCDateRequest rpcDateRequest = RPCDateRequest
                    .newBuilder()
                    .setUserName("yangnk")
                    .build();
            // 3. 请求
            RPCDateResponse rpcDateResponse = rpcDateService.getDate(rpcDateRequest);
            // 4. 输出结果
            System.out.println(rpcDateResponse.getServerDate());
        } finally {
            // 5.关闭channel, 释放资源.
            managedChannel.shutdown();
        }
    }
}
