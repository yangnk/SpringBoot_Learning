package com.yangnk.grpcserver.service;

import com.yangnk.grpcserver.dialoutService.DialoutGrpcInterceptor;
import com.yangnk.grpcserver.dialoutService.MyServerGrpcInterceptor;
import io.grpc.ServerInterceptor;
import net.devh.boot.grpc.server.interceptor.GrpcGlobalServerInterceptor;
import org.springframework.context.annotation.Configuration;


@Configuration(proxyBeanMethods = false)
public class GlobalInterceptorConfiguration {
    @GrpcGlobalServerInterceptor
    ServerInterceptor logServerInterceptor() {
        return new LogGrpcInterceptor();
    }

    @GrpcGlobalServerInterceptor
    ServerInterceptor dialoutServerInterceptor() {
        return new DialoutGrpcInterceptor();
    }

    @GrpcGlobalServerInterceptor
    ServerInterceptor myServerInterceptor() {
        return new MyServerGrpcInterceptor();
    }
}