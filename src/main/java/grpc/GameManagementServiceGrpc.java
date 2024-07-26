package grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.62.2)",
    comments = "Source: service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class GameManagementServiceGrpc {

  private GameManagementServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "grpc.GameManagementService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.GameManagementInfoRequest,
      grpc.GameManagementResponse> getUpdateInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateInfo",
      requestType = grpc.GameManagementInfoRequest.class,
      responseType = grpc.GameManagementResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.GameManagementInfoRequest,
      grpc.GameManagementResponse> getUpdateInfoMethod() {
    io.grpc.MethodDescriptor<grpc.GameManagementInfoRequest, grpc.GameManagementResponse> getUpdateInfoMethod;
    if ((getUpdateInfoMethod = GameManagementServiceGrpc.getUpdateInfoMethod) == null) {
      synchronized (GameManagementServiceGrpc.class) {
        if ((getUpdateInfoMethod = GameManagementServiceGrpc.getUpdateInfoMethod) == null) {
          GameManagementServiceGrpc.getUpdateInfoMethod = getUpdateInfoMethod =
              io.grpc.MethodDescriptor.<grpc.GameManagementInfoRequest, grpc.GameManagementResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.GameManagementInfoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.GameManagementResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GameManagementServiceMethodDescriptorSupplier("updateInfo"))
              .build();
        }
      }
    }
    return getUpdateInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.GameManagementStatusRequest,
      grpc.GameManagementResponse> getUpdateStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateStatus",
      requestType = grpc.GameManagementStatusRequest.class,
      responseType = grpc.GameManagementResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.GameManagementStatusRequest,
      grpc.GameManagementResponse> getUpdateStatusMethod() {
    io.grpc.MethodDescriptor<grpc.GameManagementStatusRequest, grpc.GameManagementResponse> getUpdateStatusMethod;
    if ((getUpdateStatusMethod = GameManagementServiceGrpc.getUpdateStatusMethod) == null) {
      synchronized (GameManagementServiceGrpc.class) {
        if ((getUpdateStatusMethod = GameManagementServiceGrpc.getUpdateStatusMethod) == null) {
          GameManagementServiceGrpc.getUpdateStatusMethod = getUpdateStatusMethod =
              io.grpc.MethodDescriptor.<grpc.GameManagementStatusRequest, grpc.GameManagementResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.GameManagementStatusRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.GameManagementResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GameManagementServiceMethodDescriptorSupplier("updateStatus"))
              .build();
        }
      }
    }
    return getUpdateStatusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.GameManagementGetAllRequest,
      grpc.GameManagementGetAllResponse> getGetAllMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAll",
      requestType = grpc.GameManagementGetAllRequest.class,
      responseType = grpc.GameManagementGetAllResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.GameManagementGetAllRequest,
      grpc.GameManagementGetAllResponse> getGetAllMethod() {
    io.grpc.MethodDescriptor<grpc.GameManagementGetAllRequest, grpc.GameManagementGetAllResponse> getGetAllMethod;
    if ((getGetAllMethod = GameManagementServiceGrpc.getGetAllMethod) == null) {
      synchronized (GameManagementServiceGrpc.class) {
        if ((getGetAllMethod = GameManagementServiceGrpc.getGetAllMethod) == null) {
          GameManagementServiceGrpc.getGetAllMethod = getGetAllMethod =
              io.grpc.MethodDescriptor.<grpc.GameManagementGetAllRequest, grpc.GameManagementGetAllResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getAll"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.GameManagementGetAllRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.GameManagementGetAllResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GameManagementServiceMethodDescriptorSupplier("getAll"))
              .build();
        }
      }
    }
    return getGetAllMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GameManagementServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GameManagementServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GameManagementServiceStub>() {
        @java.lang.Override
        public GameManagementServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GameManagementServiceStub(channel, callOptions);
        }
      };
    return GameManagementServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GameManagementServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GameManagementServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GameManagementServiceBlockingStub>() {
        @java.lang.Override
        public GameManagementServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GameManagementServiceBlockingStub(channel, callOptions);
        }
      };
    return GameManagementServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GameManagementServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GameManagementServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GameManagementServiceFutureStub>() {
        @java.lang.Override
        public GameManagementServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GameManagementServiceFutureStub(channel, callOptions);
        }
      };
    return GameManagementServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void updateInfo(grpc.GameManagementInfoRequest request,
        io.grpc.stub.StreamObserver<grpc.GameManagementResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateInfoMethod(), responseObserver);
    }

    /**
     */
    default void updateStatus(grpc.GameManagementStatusRequest request,
        io.grpc.stub.StreamObserver<grpc.GameManagementResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateStatusMethod(), responseObserver);
    }

    /**
     */
    default void getAll(grpc.GameManagementGetAllRequest request,
        io.grpc.stub.StreamObserver<grpc.GameManagementGetAllResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service GameManagementService.
   */
  public static abstract class GameManagementServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return GameManagementServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service GameManagementService.
   */
  public static final class GameManagementServiceStub
      extends io.grpc.stub.AbstractAsyncStub<GameManagementServiceStub> {
    private GameManagementServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GameManagementServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GameManagementServiceStub(channel, callOptions);
    }

    /**
     */
    public void updateInfo(grpc.GameManagementInfoRequest request,
        io.grpc.stub.StreamObserver<grpc.GameManagementResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateStatus(grpc.GameManagementStatusRequest request,
        io.grpc.stub.StreamObserver<grpc.GameManagementResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateStatusMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAll(grpc.GameManagementGetAllRequest request,
        io.grpc.stub.StreamObserver<grpc.GameManagementGetAllResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAllMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service GameManagementService.
   */
  public static final class GameManagementServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<GameManagementServiceBlockingStub> {
    private GameManagementServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GameManagementServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GameManagementServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public grpc.GameManagementResponse updateInfo(grpc.GameManagementInfoRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateInfoMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.GameManagementResponse updateStatus(grpc.GameManagementStatusRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateStatusMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.GameManagementGetAllResponse getAll(grpc.GameManagementGetAllRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAllMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service GameManagementService.
   */
  public static final class GameManagementServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<GameManagementServiceFutureStub> {
    private GameManagementServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GameManagementServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GameManagementServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.GameManagementResponse> updateInfo(
        grpc.GameManagementInfoRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateInfoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.GameManagementResponse> updateStatus(
        grpc.GameManagementStatusRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateStatusMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.GameManagementGetAllResponse> getAll(
        grpc.GameManagementGetAllRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAllMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_UPDATE_INFO = 0;
  private static final int METHODID_UPDATE_STATUS = 1;
  private static final int METHODID_GET_ALL = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_UPDATE_INFO:
          serviceImpl.updateInfo((grpc.GameManagementInfoRequest) request,
              (io.grpc.stub.StreamObserver<grpc.GameManagementResponse>) responseObserver);
          break;
        case METHODID_UPDATE_STATUS:
          serviceImpl.updateStatus((grpc.GameManagementStatusRequest) request,
              (io.grpc.stub.StreamObserver<grpc.GameManagementResponse>) responseObserver);
          break;
        case METHODID_GET_ALL:
          serviceImpl.getAll((grpc.GameManagementGetAllRequest) request,
              (io.grpc.stub.StreamObserver<grpc.GameManagementGetAllResponse>) responseObserver);
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

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getUpdateInfoMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              grpc.GameManagementInfoRequest,
              grpc.GameManagementResponse>(
                service, METHODID_UPDATE_INFO)))
        .addMethod(
          getUpdateStatusMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              grpc.GameManagementStatusRequest,
              grpc.GameManagementResponse>(
                service, METHODID_UPDATE_STATUS)))
        .addMethod(
          getGetAllMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              grpc.GameManagementGetAllRequest,
              grpc.GameManagementGetAllResponse>(
                service, METHODID_GET_ALL)))
        .build();
  }

  private static abstract class GameManagementServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GameManagementServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.Service.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("GameManagementService");
    }
  }

  private static final class GameManagementServiceFileDescriptorSupplier
      extends GameManagementServiceBaseDescriptorSupplier {
    GameManagementServiceFileDescriptorSupplier() {}
  }

  private static final class GameManagementServiceMethodDescriptorSupplier
      extends GameManagementServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    GameManagementServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (GameManagementServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GameManagementServiceFileDescriptorSupplier())
              .addMethod(getUpdateInfoMethod())
              .addMethod(getUpdateStatusMethod())
              .addMethod(getGetAllMethod())
              .build();
        }
      }
    }
    return result;
  }
}
