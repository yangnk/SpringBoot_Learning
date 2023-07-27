package com.yangnk.grpcserver.service;

import com.yangnk.grpcapi.api.HelloReply;
import com.yangnk.grpcapi.api.HelloRequest;
import com.yangnk.grpcapi.api.SimpleGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import java.util.Date;

@GrpcService
public class GrpcServerService extends SimpleGrpc.SimpleImplBase {

    @Override
    public void sayHello(HelloRequest request,
                         StreamObserver<HelloReply> responseObserver) {
        HelloReply reply = HelloReply.newBuilder().setMessage("你好， " + request.getName() + ", " + new Date()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}