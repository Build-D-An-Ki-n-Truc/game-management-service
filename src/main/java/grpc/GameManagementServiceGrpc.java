package grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.65.1)",
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

  private static volatile io.grpc.MethodDescriptor<grpc.GameManagementGetListByEventRequest,
      grpc.GameManagementGetAllResponse> getGetListByEventMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getListByEvent",
      requestType = grpc.GameManagementGetListByEventRequest.class,
      responseType = grpc.GameManagementGetAllResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.GameManagementGetListByEventRequest,
      grpc.GameManagementGetAllResponse> getGetListByEventMethod() {
    io.grpc.MethodDescriptor<grpc.GameManagementGetListByEventRequest, grpc.GameManagementGetAllResponse> getGetListByEventMethod;
    if ((getGetListByEventMethod = GameManagementServiceGrpc.getGetListByEventMethod) == null) {
      synchronized (GameManagementServiceGrpc.class) {
        if ((getGetListByEventMethod = GameManagementServiceGrpc.getGetListByEventMethod) == null) {
          GameManagementServiceGrpc.getGetListByEventMethod = getGetListByEventMethod =
              io.grpc.MethodDescriptor.<grpc.GameManagementGetListByEventRequest, grpc.GameManagementGetAllResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getListByEvent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.GameManagementGetListByEventRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.GameManagementGetAllResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GameManagementServiceMethodDescriptorSupplier("getListByEvent"))
              .build();
        }
      }
    }
    return getGetListByEventMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.GameManagementGetRequest,
      grpc.GameManagementGetResponse> getGetOneMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getOne",
      requestType = grpc.GameManagementGetRequest.class,
      responseType = grpc.GameManagementGetResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.GameManagementGetRequest,
      grpc.GameManagementGetResponse> getGetOneMethod() {
    io.grpc.MethodDescriptor<grpc.GameManagementGetRequest, grpc.GameManagementGetResponse> getGetOneMethod;
    if ((getGetOneMethod = GameManagementServiceGrpc.getGetOneMethod) == null) {
      synchronized (GameManagementServiceGrpc.class) {
        if ((getGetOneMethod = GameManagementServiceGrpc.getGetOneMethod) == null) {
          GameManagementServiceGrpc.getGetOneMethod = getGetOneMethod =
              io.grpc.MethodDescriptor.<grpc.GameManagementGetRequest, grpc.GameManagementGetResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getOne"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.GameManagementGetRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.GameManagementGetResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GameManagementServiceMethodDescriptorSupplier("getOne"))
              .build();
        }
      }
    }
    return getGetOneMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.GameManagementAddRequest,
      grpc.GameManagementResponse> getAddMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "add",
      requestType = grpc.GameManagementAddRequest.class,
      responseType = grpc.GameManagementResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.GameManagementAddRequest,
      grpc.GameManagementResponse> getAddMethod() {
    io.grpc.MethodDescriptor<grpc.GameManagementAddRequest, grpc.GameManagementResponse> getAddMethod;
    if ((getAddMethod = GameManagementServiceGrpc.getAddMethod) == null) {
      synchronized (GameManagementServiceGrpc.class) {
        if ((getAddMethod = GameManagementServiceGrpc.getAddMethod) == null) {
          GameManagementServiceGrpc.getAddMethod = getAddMethod =
              io.grpc.MethodDescriptor.<grpc.GameManagementAddRequest, grpc.GameManagementResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "add"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.GameManagementAddRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.GameManagementResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GameManagementServiceMethodDescriptorSupplier("add"))
              .build();
        }
      }
    }
    return getAddMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.GameManagementShakeRequest,
      grpc.GameManagementShakeResponse> getShakeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "shake",
      requestType = grpc.GameManagementShakeRequest.class,
      responseType = grpc.GameManagementShakeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.GameManagementShakeRequest,
      grpc.GameManagementShakeResponse> getShakeMethod() {
    io.grpc.MethodDescriptor<grpc.GameManagementShakeRequest, grpc.GameManagementShakeResponse> getShakeMethod;
    if ((getShakeMethod = GameManagementServiceGrpc.getShakeMethod) == null) {
      synchronized (GameManagementServiceGrpc.class) {
        if ((getShakeMethod = GameManagementServiceGrpc.getShakeMethod) == null) {
          GameManagementServiceGrpc.getShakeMethod = getShakeMethod =
              io.grpc.MethodDescriptor.<grpc.GameManagementShakeRequest, grpc.GameManagementShakeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "shake"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.GameManagementShakeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.GameManagementShakeResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GameManagementServiceMethodDescriptorSupplier("shake"))
              .build();
        }
      }
    }
    return getShakeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.GameManagementShakeRewardRequest,
      grpc.GameManagementShakeRewardResponse> getUpdateShakeRewardMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateShakeReward",
      requestType = grpc.GameManagementShakeRewardRequest.class,
      responseType = grpc.GameManagementShakeRewardResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.GameManagementShakeRewardRequest,
      grpc.GameManagementShakeRewardResponse> getUpdateShakeRewardMethod() {
    io.grpc.MethodDescriptor<grpc.GameManagementShakeRewardRequest, grpc.GameManagementShakeRewardResponse> getUpdateShakeRewardMethod;
    if ((getUpdateShakeRewardMethod = GameManagementServiceGrpc.getUpdateShakeRewardMethod) == null) {
      synchronized (GameManagementServiceGrpc.class) {
        if ((getUpdateShakeRewardMethod = GameManagementServiceGrpc.getUpdateShakeRewardMethod) == null) {
          GameManagementServiceGrpc.getUpdateShakeRewardMethod = getUpdateShakeRewardMethod =
              io.grpc.MethodDescriptor.<grpc.GameManagementShakeRewardRequest, grpc.GameManagementShakeRewardResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateShakeReward"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.GameManagementShakeRewardRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.GameManagementShakeRewardResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GameManagementServiceMethodDescriptorSupplier("updateShakeReward"))
              .build();
        }
      }
    }
    return getUpdateShakeRewardMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.GameManagementQuizQuestionsRequest,
      grpc.GameManagementQuizQuestionsResponse> getGetQuizQuestionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getQuizQuestions",
      requestType = grpc.GameManagementQuizQuestionsRequest.class,
      responseType = grpc.GameManagementQuizQuestionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.GameManagementQuizQuestionsRequest,
      grpc.GameManagementQuizQuestionsResponse> getGetQuizQuestionsMethod() {
    io.grpc.MethodDescriptor<grpc.GameManagementQuizQuestionsRequest, grpc.GameManagementQuizQuestionsResponse> getGetQuizQuestionsMethod;
    if ((getGetQuizQuestionsMethod = GameManagementServiceGrpc.getGetQuizQuestionsMethod) == null) {
      synchronized (GameManagementServiceGrpc.class) {
        if ((getGetQuizQuestionsMethod = GameManagementServiceGrpc.getGetQuizQuestionsMethod) == null) {
          GameManagementServiceGrpc.getGetQuizQuestionsMethod = getGetQuizQuestionsMethod =
              io.grpc.MethodDescriptor.<grpc.GameManagementQuizQuestionsRequest, grpc.GameManagementQuizQuestionsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getQuizQuestions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.GameManagementQuizQuestionsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.GameManagementQuizQuestionsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GameManagementServiceMethodDescriptorSupplier("getQuizQuestions"))
              .build();
        }
      }
    }
    return getGetQuizQuestionsMethod;
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

    /**
     */
    default void getListByEvent(grpc.GameManagementGetListByEventRequest request,
        io.grpc.stub.StreamObserver<grpc.GameManagementGetAllResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetListByEventMethod(), responseObserver);
    }

    /**
     */
    default void getOne(grpc.GameManagementGetRequest request,
        io.grpc.stub.StreamObserver<grpc.GameManagementGetResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetOneMethod(), responseObserver);
    }

    /**
     */
    default void add(grpc.GameManagementAddRequest request,
        io.grpc.stub.StreamObserver<grpc.GameManagementResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddMethod(), responseObserver);
    }

    /**
     */
    default void shake(grpc.GameManagementShakeRequest request,
        io.grpc.stub.StreamObserver<grpc.GameManagementShakeResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getShakeMethod(), responseObserver);
    }

    /**
     */
    default void updateShakeReward(grpc.GameManagementShakeRewardRequest request,
        io.grpc.stub.StreamObserver<grpc.GameManagementShakeRewardResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateShakeRewardMethod(), responseObserver);
    }

    /**
     */
    default void getQuizQuestions(grpc.GameManagementQuizQuestionsRequest request,
        io.grpc.stub.StreamObserver<grpc.GameManagementQuizQuestionsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetQuizQuestionsMethod(), responseObserver);
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

    /**
     */
    public void getListByEvent(grpc.GameManagementGetListByEventRequest request,
        io.grpc.stub.StreamObserver<grpc.GameManagementGetAllResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetListByEventMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getOne(grpc.GameManagementGetRequest request,
        io.grpc.stub.StreamObserver<grpc.GameManagementGetResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetOneMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void add(grpc.GameManagementAddRequest request,
        io.grpc.stub.StreamObserver<grpc.GameManagementResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void shake(grpc.GameManagementShakeRequest request,
        io.grpc.stub.StreamObserver<grpc.GameManagementShakeResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getShakeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateShakeReward(grpc.GameManagementShakeRewardRequest request,
        io.grpc.stub.StreamObserver<grpc.GameManagementShakeRewardResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateShakeRewardMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getQuizQuestions(grpc.GameManagementQuizQuestionsRequest request,
        io.grpc.stub.StreamObserver<grpc.GameManagementQuizQuestionsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetQuizQuestionsMethod(), getCallOptions()), request, responseObserver);
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

    /**
     */
    public grpc.GameManagementGetAllResponse getListByEvent(grpc.GameManagementGetListByEventRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetListByEventMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.GameManagementGetResponse getOne(grpc.GameManagementGetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetOneMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.GameManagementResponse add(grpc.GameManagementAddRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.GameManagementShakeResponse shake(grpc.GameManagementShakeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getShakeMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.GameManagementShakeRewardResponse updateShakeReward(grpc.GameManagementShakeRewardRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateShakeRewardMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.GameManagementQuizQuestionsResponse getQuizQuestions(grpc.GameManagementQuizQuestionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetQuizQuestionsMethod(), getCallOptions(), request);
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

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.GameManagementGetAllResponse> getListByEvent(
        grpc.GameManagementGetListByEventRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetListByEventMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.GameManagementGetResponse> getOne(
        grpc.GameManagementGetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetOneMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.GameManagementResponse> add(
        grpc.GameManagementAddRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.GameManagementShakeResponse> shake(
        grpc.GameManagementShakeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getShakeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.GameManagementShakeRewardResponse> updateShakeReward(
        grpc.GameManagementShakeRewardRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateShakeRewardMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.GameManagementQuizQuestionsResponse> getQuizQuestions(
        grpc.GameManagementQuizQuestionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetQuizQuestionsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_UPDATE_INFO = 0;
  private static final int METHODID_UPDATE_STATUS = 1;
  private static final int METHODID_GET_ALL = 2;
  private static final int METHODID_GET_LIST_BY_EVENT = 3;
  private static final int METHODID_GET_ONE = 4;
  private static final int METHODID_ADD = 5;
  private static final int METHODID_SHAKE = 6;
  private static final int METHODID_UPDATE_SHAKE_REWARD = 7;
  private static final int METHODID_GET_QUIZ_QUESTIONS = 8;

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
        case METHODID_GET_LIST_BY_EVENT:
          serviceImpl.getListByEvent((grpc.GameManagementGetListByEventRequest) request,
              (io.grpc.stub.StreamObserver<grpc.GameManagementGetAllResponse>) responseObserver);
          break;
        case METHODID_GET_ONE:
          serviceImpl.getOne((grpc.GameManagementGetRequest) request,
              (io.grpc.stub.StreamObserver<grpc.GameManagementGetResponse>) responseObserver);
          break;
        case METHODID_ADD:
          serviceImpl.add((grpc.GameManagementAddRequest) request,
              (io.grpc.stub.StreamObserver<grpc.GameManagementResponse>) responseObserver);
          break;
        case METHODID_SHAKE:
          serviceImpl.shake((grpc.GameManagementShakeRequest) request,
              (io.grpc.stub.StreamObserver<grpc.GameManagementShakeResponse>) responseObserver);
          break;
        case METHODID_UPDATE_SHAKE_REWARD:
          serviceImpl.updateShakeReward((grpc.GameManagementShakeRewardRequest) request,
              (io.grpc.stub.StreamObserver<grpc.GameManagementShakeRewardResponse>) responseObserver);
          break;
        case METHODID_GET_QUIZ_QUESTIONS:
          serviceImpl.getQuizQuestions((grpc.GameManagementQuizQuestionsRequest) request,
              (io.grpc.stub.StreamObserver<grpc.GameManagementQuizQuestionsResponse>) responseObserver);
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
        .addMethod(
          getGetListByEventMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              grpc.GameManagementGetListByEventRequest,
              grpc.GameManagementGetAllResponse>(
                service, METHODID_GET_LIST_BY_EVENT)))
        .addMethod(
          getGetOneMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              grpc.GameManagementGetRequest,
              grpc.GameManagementGetResponse>(
                service, METHODID_GET_ONE)))
        .addMethod(
          getAddMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              grpc.GameManagementAddRequest,
              grpc.GameManagementResponse>(
                service, METHODID_ADD)))
        .addMethod(
          getShakeMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              grpc.GameManagementShakeRequest,
              grpc.GameManagementShakeResponse>(
                service, METHODID_SHAKE)))
        .addMethod(
          getUpdateShakeRewardMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              grpc.GameManagementShakeRewardRequest,
              grpc.GameManagementShakeRewardResponse>(
                service, METHODID_UPDATE_SHAKE_REWARD)))
        .addMethod(
          getGetQuizQuestionsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              grpc.GameManagementQuizQuestionsRequest,
              grpc.GameManagementQuizQuestionsResponse>(
                service, METHODID_GET_QUIZ_QUESTIONS)))
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
              .addMethod(getGetListByEventMethod())
              .addMethod(getGetOneMethod())
              .addMethod(getAddMethod())
              .addMethod(getShakeMethod())
              .addMethod(getUpdateShakeRewardMethod())
              .addMethod(getGetQuizQuestionsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
