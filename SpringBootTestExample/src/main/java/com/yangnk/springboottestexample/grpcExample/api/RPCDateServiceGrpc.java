package com.yangnk.springboottestexample.grpcExample.api;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 * <pre>
 * 服务接口.定义请求参数和相应结果
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.2.0)",
    comments = "Source: RPCDateService.proto")
public final class RPCDateServiceGrpc {

  private RPCDateServiceGrpc() {}

  public static final String SERVICE_NAME = "com.yangnk.springboottestexample.grpcExample.api.RPCDateService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.yangnk.springboottestexample.grpcExample.api.RPCDateRequest,
      com.yangnk.springboottestexample.grpcExample.api.RPCDateResponse> METHOD_GET_DATE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "com.yangnk.springboottestexample.grpcExample.api.RPCDateService", "getDate"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.yangnk.springboottestexample.grpcExample.api.RPCDateRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.yangnk.springboottestexample.grpcExample.api.RPCDateResponse.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RPCDateServiceStub newStub(io.grpc.Channel channel) {
    return new RPCDateServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RPCDateServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new RPCDateServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static RPCDateServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new RPCDateServiceFutureStub(channel);
  }

  /**
   * <pre>
   * 服务接口.定义请求参数和相应结果
   * </pre>
   */
  public static abstract class RPCDateServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getDate(com.yangnk.springboottestexample.grpcExample.api.RPCDateRequest request,
        io.grpc.stub.StreamObserver<com.yangnk.springboottestexample.grpcExample.api.RPCDateResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_DATE, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_GET_DATE,
            asyncUnaryCall(
              new MethodHandlers<
                com.yangnk.springboottestexample.grpcExample.api.RPCDateRequest,
                com.yangnk.springboottestexample.grpcExample.api.RPCDateResponse>(
                  this, METHODID_GET_DATE)))
          .build();
    }
  }

  /**
   * <pre>
   * 服务接口.定义请求参数和相应结果
   * </pre>
   */
  public static final class RPCDateServiceStub extends io.grpc.stub.AbstractStub<RPCDateServiceStub> {
    private RPCDateServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RPCDateServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RPCDateServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RPCDateServiceStub(channel, callOptions);
    }

    /**
     */
    public void getDate(com.yangnk.springboottestexample.grpcExample.api.RPCDateRequest request,
        io.grpc.stub.StreamObserver<com.yangnk.springboottestexample.grpcExample.api.RPCDateResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_DATE, getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * 服务接口.定义请求参数和相应结果
   * </pre>
   */
  public static final class RPCDateServiceBlockingStub extends io.grpc.stub.AbstractStub<RPCDateServiceBlockingStub> {
    private RPCDateServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RPCDateServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RPCDateServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RPCDateServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.yangnk.springboottestexample.grpcExample.api.RPCDateResponse getDate(com.yangnk.springboottestexample.grpcExample.api.RPCDateRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_DATE, getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * 服务接口.定义请求参数和相应结果
   * </pre>
   */
  public static final class RPCDateServiceFutureStub extends io.grpc.stub.AbstractStub<RPCDateServiceFutureStub> {
    private RPCDateServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RPCDateServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RPCDateServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RPCDateServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.yangnk.springboottestexample.grpcExample.api.RPCDateResponse> getDate(
        com.yangnk.springboottestexample.grpcExample.api.RPCDateRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_DATE, getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_DATE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RPCDateServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RPCDateServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_DATE:
          serviceImpl.getDate((com.yangnk.springboottestexample.grpcExample.api.RPCDateRequest) request,
              (io.grpc.stub.StreamObserver<com.yangnk.springboottestexample.grpcExample.api.RPCDateResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class RPCDateServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.yangnk.springboottestexample.grpcExample.api.RPCDateServiceApi.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (RPCDateServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RPCDateServiceDescriptorSupplier())
              .addMethod(METHOD_GET_DATE)
              .build();
        }
      }
    }
    return result;
  }
}
