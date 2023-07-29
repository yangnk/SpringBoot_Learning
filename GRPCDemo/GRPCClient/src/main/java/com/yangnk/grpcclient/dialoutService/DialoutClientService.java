package com.yangnk.grpcclient.dialoutService;

import com.yangnk.grpcapi.api.HelloReply;
import com.yangnk.grpcapi.api.HelloRequest;
import com.yangnk.grpcapi.api.SimpleGrpc;
import com.yangnk.grpcapi.dialoutApi.dialoutRequest;
import com.yangnk.grpcapi.dialoutApi.dialoutResponse;
import com.yangnk.grpcapi.dialoutApi.dialoutServiceGrpc;
import io.grpc.StatusRuntimeException;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DialoutClientService {

    @GrpcClient("local-grpc-server")
    dialoutServiceGrpc.dialoutServiceBlockingStub dialoutServiceBlockingStub;

    public String sendMessage(final String name) {
        try {
            dialoutRequest request = dialoutRequest.newBuilder().setDeviceMsg("msg").setSensorPath("path").setJsonData("data").build();
            log.info("请求的参数为:{}", request.toString());
            dialoutResponse response = this.dialoutServiceBlockingStub.simpleDialout(request);
            log.info("返回的参数为:{}", response.toString());
            return response.getMessage();
        } catch (final StatusRuntimeException e) {
            return "FAILED with " + e.getStatus().getCode().name();
        }
    }
}
