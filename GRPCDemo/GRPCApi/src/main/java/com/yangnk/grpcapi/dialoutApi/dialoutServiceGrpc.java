package com.yangnk.grpcapi.dialoutApi;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * The greeting service definition.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.37.0)",
    comments = "Source: dialout.proto")
public final class dialoutServiceGrpc {

  private dialoutServiceGrpc() {}

  public static final String SERVICE_NAME = "dialoutService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<dialoutRequest,
      dialoutResponse> getSimpleDialoutMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "simpleDialout",
      requestType = dialoutRequest.class,
      responseType = dialoutResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<dialoutRequest,
      dialoutResponse> getSimpleDialoutMethod() {
    io.grpc.MethodDescriptor<dialoutRequest, dialoutResponse> getSimpleDialoutMethod;
    if ((getSimpleDialoutMethod = dialoutServiceGrpc.getSimpleDialoutMethod) == null) {
      synchronized (dialoutServiceGrpc.class) {
        if ((getSimpleDialoutMethod = dialoutServiceGrpc.getSimpleDialoutMethod) == null) {
          dialoutServiceGrpc.getSimpleDialoutMethod = getSimpleDialoutMethod =
              io.grpc.MethodDescriptor.<dialoutRequest, dialoutResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "simpleDialout"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dialoutRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dialoutResponse.getDefaultInstance()))
              .setSchemaDescriptor(new dialoutServiceMethodDescriptorSupplier("simpleDialout"))
              .build();
        }
      }
    }
    return getSimpleDialoutMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static dialoutServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<dialoutServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<dialoutServiceStub>() {
        @Override
        public dialoutServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new dialoutServiceStub(channel, callOptions);
        }
      };
    return dialoutServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static dialoutServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<dialoutServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<dialoutServiceBlockingStub>() {
        @Override
        public dialoutServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new dialoutServiceBlockingStub(channel, callOptions);
        }
      };
    return dialoutServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static dialoutServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<dialoutServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<dialoutServiceFutureStub>() {
        @Override
        public dialoutServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new dialoutServiceFutureStub(channel, callOptions);
        }
      };
    return dialoutServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static abstract class dialoutServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public void simpleDialout(dialoutRequest request,
                              io.grpc.stub.StreamObserver<dialoutResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSimpleDialoutMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSimpleDialoutMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                dialoutRequest,
                dialoutResponse>(
                  this, METHODID_SIMPLE_DIALOUT)))
          .build();
    }
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static final class dialoutServiceStub extends io.grpc.stub.AbstractAsyncStub<dialoutServiceStub> {
    private dialoutServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected dialoutServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new dialoutServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public void simpleDialout(dialoutRequest request,
                              io.grpc.stub.StreamObserver<dialoutResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSimpleDialoutMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static final class dialoutServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<dialoutServiceBlockingStub> {
    private dialoutServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected dialoutServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new dialoutServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public dialoutResponse simpleDialout(dialoutRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSimpleDialoutMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static final class dialoutServiceFutureStub extends io.grpc.stub.AbstractFutureStub<dialoutServiceFutureStub> {
    private dialoutServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected dialoutServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new dialoutServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<dialoutResponse> simpleDialout(
        dialoutRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSimpleDialoutMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SIMPLE_DIALOUT = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final dialoutServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(dialoutServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SIMPLE_DIALOUT:
          serviceImpl.simpleDialout((dialoutRequest) request,
              (io.grpc.stub.StreamObserver<dialoutResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class dialoutServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    dialoutServiceBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return dialoutProto.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("dialoutService");
    }
  }

  private static final class dialoutServiceFileDescriptorSupplier
      extends dialoutServiceBaseDescriptorSupplier {
    dialoutServiceFileDescriptorSupplier() {}
  }

  private static final class dialoutServiceMethodDescriptorSupplier
      extends dialoutServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    dialoutServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (dialoutServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new dialoutServiceFileDescriptorSupplier())
              .addMethod(getSimpleDialoutMethod())
              .build();
        }
      }
    }
    return result;
  }
}
