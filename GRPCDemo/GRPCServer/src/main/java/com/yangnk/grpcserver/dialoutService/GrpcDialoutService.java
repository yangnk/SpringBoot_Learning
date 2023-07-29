package com.yangnk.grpcserver.dialoutService;

import com.yangnk.grpcapi.api.HelloReply;
import com.yangnk.grpcapi.api.HelloRequest;
import com.yangnk.grpcapi.api.SimpleGrpc;
import com.yangnk.grpcapi.dialoutApi.dialoutRequest;
import com.yangnk.grpcapi.dialoutApi.dialoutResponse;
import com.yangnk.grpcapi.dialoutApi.dialoutServiceGrpc;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import java.util.Date;
import static com.yangnk.grpcapi.dialoutApi.dialoutServiceGrpc.getSimpleDialoutMethod;

@GrpcService
@Slf4j
public class GrpcDialoutService extends dialoutServiceGrpc.dialoutServiceImplBase {
    @Override
    public void simpleDialout(dialoutRequest request,
                              io.grpc.stub.StreamObserver<dialoutResponse> responseObserver) {

        dialoutResponse dialoutResponseVar = dialoutResponse.newBuilder().setMessage("dialoutMsg").build();
        responseObserver.onNext(dialoutResponseVar);
        responseObserver.onCompleted();
//        io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSimpleDialoutMethod(), responseObserver);
    }
}