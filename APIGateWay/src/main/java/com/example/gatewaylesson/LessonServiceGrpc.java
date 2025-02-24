package com.example.gatewaylesson;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@jakarta.annotation.Generated(
    value = "by gRPC proto compiler (version 1.9.1)",
    comments = "Source: course/lesson/GateWay_Lesson_Rpc.proto")
public final class LessonServiceGrpc {

  private LessonServiceGrpc() {}

  public static final String SERVICE_NAME = "lesson.LessonService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateLessonMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.example.gatewaylesson.GateWayLessonRpcProto.CreateLessonRequest,
      com.example.gatewaylesson.GateWayLessonRpcProto.CreateLessonResponse> METHOD_CREATE_LESSON = getCreateLessonMethod();

  private static volatile io.grpc.MethodDescriptor<com.example.gatewaylesson.GateWayLessonRpcProto.CreateLessonRequest,
      com.example.gatewaylesson.GateWayLessonRpcProto.CreateLessonResponse> getCreateLessonMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.example.gatewaylesson.GateWayLessonRpcProto.CreateLessonRequest,
      com.example.gatewaylesson.GateWayLessonRpcProto.CreateLessonResponse> getCreateLessonMethod() {
    io.grpc.MethodDescriptor<com.example.gatewaylesson.GateWayLessonRpcProto.CreateLessonRequest, com.example.gatewaylesson.GateWayLessonRpcProto.CreateLessonResponse> getCreateLessonMethod;
    if ((getCreateLessonMethod = LessonServiceGrpc.getCreateLessonMethod) == null) {
      synchronized (LessonServiceGrpc.class) {
        if ((getCreateLessonMethod = LessonServiceGrpc.getCreateLessonMethod) == null) {
          LessonServiceGrpc.getCreateLessonMethod = getCreateLessonMethod = 
              io.grpc.MethodDescriptor.<com.example.gatewaylesson.GateWayLessonRpcProto.CreateLessonRequest, com.example.gatewaylesson.GateWayLessonRpcProto.CreateLessonResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "lesson.LessonService", "CreateLesson"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewaylesson.GateWayLessonRpcProto.CreateLessonRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewaylesson.GateWayLessonRpcProto.CreateLessonResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LessonServiceMethodDescriptorSupplier("CreateLesson"))
                  .build();
          }
        }
     }
     return getCreateLessonMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetLessonMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.example.gatewaylesson.GateWayLessonRpcProto.GetLessonRequest,
      com.example.gatewaylesson.GateWayLessonRpcProto.GetLessonResponse> METHOD_GET_LESSON = getGetLessonMethod();

  private static volatile io.grpc.MethodDescriptor<com.example.gatewaylesson.GateWayLessonRpcProto.GetLessonRequest,
      com.example.gatewaylesson.GateWayLessonRpcProto.GetLessonResponse> getGetLessonMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.example.gatewaylesson.GateWayLessonRpcProto.GetLessonRequest,
      com.example.gatewaylesson.GateWayLessonRpcProto.GetLessonResponse> getGetLessonMethod() {
    io.grpc.MethodDescriptor<com.example.gatewaylesson.GateWayLessonRpcProto.GetLessonRequest, com.example.gatewaylesson.GateWayLessonRpcProto.GetLessonResponse> getGetLessonMethod;
    if ((getGetLessonMethod = LessonServiceGrpc.getGetLessonMethod) == null) {
      synchronized (LessonServiceGrpc.class) {
        if ((getGetLessonMethod = LessonServiceGrpc.getGetLessonMethod) == null) {
          LessonServiceGrpc.getGetLessonMethod = getGetLessonMethod = 
              io.grpc.MethodDescriptor.<com.example.gatewaylesson.GateWayLessonRpcProto.GetLessonRequest, com.example.gatewaylesson.GateWayLessonRpcProto.GetLessonResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "lesson.LessonService", "GetLesson"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewaylesson.GateWayLessonRpcProto.GetLessonRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewaylesson.GateWayLessonRpcProto.GetLessonResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LessonServiceMethodDescriptorSupplier("GetLesson"))
                  .build();
          }
        }
     }
     return getGetLessonMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetAllLessonsByUnitMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.example.gatewaylesson.GateWayLessonRpcProto.GetAllLessonsByUnitRequest,
      com.example.gatewaylesson.GateWayLessonRpcProto.GetAllLessonsByUnitResponse> METHOD_GET_ALL_LESSONS_BY_UNIT = getGetAllLessonsByUnitMethod();

  private static volatile io.grpc.MethodDescriptor<com.example.gatewaylesson.GateWayLessonRpcProto.GetAllLessonsByUnitRequest,
      com.example.gatewaylesson.GateWayLessonRpcProto.GetAllLessonsByUnitResponse> getGetAllLessonsByUnitMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.example.gatewaylesson.GateWayLessonRpcProto.GetAllLessonsByUnitRequest,
      com.example.gatewaylesson.GateWayLessonRpcProto.GetAllLessonsByUnitResponse> getGetAllLessonsByUnitMethod() {
    io.grpc.MethodDescriptor<com.example.gatewaylesson.GateWayLessonRpcProto.GetAllLessonsByUnitRequest, com.example.gatewaylesson.GateWayLessonRpcProto.GetAllLessonsByUnitResponse> getGetAllLessonsByUnitMethod;
    if ((getGetAllLessonsByUnitMethod = LessonServiceGrpc.getGetAllLessonsByUnitMethod) == null) {
      synchronized (LessonServiceGrpc.class) {
        if ((getGetAllLessonsByUnitMethod = LessonServiceGrpc.getGetAllLessonsByUnitMethod) == null) {
          LessonServiceGrpc.getGetAllLessonsByUnitMethod = getGetAllLessonsByUnitMethod = 
              io.grpc.MethodDescriptor.<com.example.gatewaylesson.GateWayLessonRpcProto.GetAllLessonsByUnitRequest, com.example.gatewaylesson.GateWayLessonRpcProto.GetAllLessonsByUnitResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "lesson.LessonService", "GetAllLessonsByUnit"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewaylesson.GateWayLessonRpcProto.GetAllLessonsByUnitRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewaylesson.GateWayLessonRpcProto.GetAllLessonsByUnitResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LessonServiceMethodDescriptorSupplier("GetAllLessonsByUnit"))
                  .build();
          }
        }
     }
     return getGetAllLessonsByUnitMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateLessonMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.example.gatewaylesson.GateWayLessonRpcProto.UpdateLessonRequest,
      com.example.gatewaylesson.GateWayLessonRpcProto.UpdateLessonResponse> METHOD_UPDATE_LESSON = getUpdateLessonMethod();

  private static volatile io.grpc.MethodDescriptor<com.example.gatewaylesson.GateWayLessonRpcProto.UpdateLessonRequest,
      com.example.gatewaylesson.GateWayLessonRpcProto.UpdateLessonResponse> getUpdateLessonMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.example.gatewaylesson.GateWayLessonRpcProto.UpdateLessonRequest,
      com.example.gatewaylesson.GateWayLessonRpcProto.UpdateLessonResponse> getUpdateLessonMethod() {
    io.grpc.MethodDescriptor<com.example.gatewaylesson.GateWayLessonRpcProto.UpdateLessonRequest, com.example.gatewaylesson.GateWayLessonRpcProto.UpdateLessonResponse> getUpdateLessonMethod;
    if ((getUpdateLessonMethod = LessonServiceGrpc.getUpdateLessonMethod) == null) {
      synchronized (LessonServiceGrpc.class) {
        if ((getUpdateLessonMethod = LessonServiceGrpc.getUpdateLessonMethod) == null) {
          LessonServiceGrpc.getUpdateLessonMethod = getUpdateLessonMethod = 
              io.grpc.MethodDescriptor.<com.example.gatewaylesson.GateWayLessonRpcProto.UpdateLessonRequest, com.example.gatewaylesson.GateWayLessonRpcProto.UpdateLessonResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "lesson.LessonService", "UpdateLesson"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewaylesson.GateWayLessonRpcProto.UpdateLessonRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewaylesson.GateWayLessonRpcProto.UpdateLessonResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LessonServiceMethodDescriptorSupplier("UpdateLesson"))
                  .build();
          }
        }
     }
     return getUpdateLessonMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteLessonMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.example.gatewaylesson.GateWayLessonRpcProto.DeleteLessonRequest,
      com.example.gatewaylesson.GateWayLessonRpcProto.DeleteLessonResponse> METHOD_DELETE_LESSON = getDeleteLessonMethod();

  private static volatile io.grpc.MethodDescriptor<com.example.gatewaylesson.GateWayLessonRpcProto.DeleteLessonRequest,
      com.example.gatewaylesson.GateWayLessonRpcProto.DeleteLessonResponse> getDeleteLessonMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.example.gatewaylesson.GateWayLessonRpcProto.DeleteLessonRequest,
      com.example.gatewaylesson.GateWayLessonRpcProto.DeleteLessonResponse> getDeleteLessonMethod() {
    io.grpc.MethodDescriptor<com.example.gatewaylesson.GateWayLessonRpcProto.DeleteLessonRequest, com.example.gatewaylesson.GateWayLessonRpcProto.DeleteLessonResponse> getDeleteLessonMethod;
    if ((getDeleteLessonMethod = LessonServiceGrpc.getDeleteLessonMethod) == null) {
      synchronized (LessonServiceGrpc.class) {
        if ((getDeleteLessonMethod = LessonServiceGrpc.getDeleteLessonMethod) == null) {
          LessonServiceGrpc.getDeleteLessonMethod = getDeleteLessonMethod = 
              io.grpc.MethodDescriptor.<com.example.gatewaylesson.GateWayLessonRpcProto.DeleteLessonRequest, com.example.gatewaylesson.GateWayLessonRpcProto.DeleteLessonResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "lesson.LessonService", "DeleteLesson"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewaylesson.GateWayLessonRpcProto.DeleteLessonRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewaylesson.GateWayLessonRpcProto.DeleteLessonResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LessonServiceMethodDescriptorSupplier("DeleteLesson"))
                  .build();
          }
        }
     }
     return getDeleteLessonMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static LessonServiceStub newStub(io.grpc.Channel channel) {
    return new LessonServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LessonServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new LessonServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static LessonServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new LessonServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class LessonServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void createLesson(com.example.gatewaylesson.GateWayLessonRpcProto.CreateLessonRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewaylesson.GateWayLessonRpcProto.CreateLessonResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateLessonMethod(), responseObserver);
    }

    /**
     */
    public void getLesson(com.example.gatewaylesson.GateWayLessonRpcProto.GetLessonRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewaylesson.GateWayLessonRpcProto.GetLessonResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetLessonMethod(), responseObserver);
    }

    /**
     */
    public void getAllLessonsByUnit(com.example.gatewaylesson.GateWayLessonRpcProto.GetAllLessonsByUnitRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewaylesson.GateWayLessonRpcProto.GetAllLessonsByUnitResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAllLessonsByUnitMethod(), responseObserver);
    }

    /**
     */
    public void updateLesson(com.example.gatewaylesson.GateWayLessonRpcProto.UpdateLessonRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewaylesson.GateWayLessonRpcProto.UpdateLessonResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateLessonMethod(), responseObserver);
    }

    /**
     */
    public void deleteLesson(com.example.gatewaylesson.GateWayLessonRpcProto.DeleteLessonRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewaylesson.GateWayLessonRpcProto.DeleteLessonResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteLessonMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateLessonMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.gatewaylesson.GateWayLessonRpcProto.CreateLessonRequest,
                com.example.gatewaylesson.GateWayLessonRpcProto.CreateLessonResponse>(
                  this, METHODID_CREATE_LESSON)))
          .addMethod(
            getGetLessonMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.gatewaylesson.GateWayLessonRpcProto.GetLessonRequest,
                com.example.gatewaylesson.GateWayLessonRpcProto.GetLessonResponse>(
                  this, METHODID_GET_LESSON)))
          .addMethod(
            getGetAllLessonsByUnitMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.gatewaylesson.GateWayLessonRpcProto.GetAllLessonsByUnitRequest,
                com.example.gatewaylesson.GateWayLessonRpcProto.GetAllLessonsByUnitResponse>(
                  this, METHODID_GET_ALL_LESSONS_BY_UNIT)))
          .addMethod(
            getUpdateLessonMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.gatewaylesson.GateWayLessonRpcProto.UpdateLessonRequest,
                com.example.gatewaylesson.GateWayLessonRpcProto.UpdateLessonResponse>(
                  this, METHODID_UPDATE_LESSON)))
          .addMethod(
            getDeleteLessonMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.gatewaylesson.GateWayLessonRpcProto.DeleteLessonRequest,
                com.example.gatewaylesson.GateWayLessonRpcProto.DeleteLessonResponse>(
                  this, METHODID_DELETE_LESSON)))
          .build();
    }
  }

  /**
   */
  public static final class LessonServiceStub extends io.grpc.stub.AbstractStub<LessonServiceStub> {
    private LessonServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LessonServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LessonServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LessonServiceStub(channel, callOptions);
    }

    /**
     */
    public void createLesson(com.example.gatewaylesson.GateWayLessonRpcProto.CreateLessonRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewaylesson.GateWayLessonRpcProto.CreateLessonResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateLessonMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getLesson(com.example.gatewaylesson.GateWayLessonRpcProto.GetLessonRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewaylesson.GateWayLessonRpcProto.GetLessonResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetLessonMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllLessonsByUnit(com.example.gatewaylesson.GateWayLessonRpcProto.GetAllLessonsByUnitRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewaylesson.GateWayLessonRpcProto.GetAllLessonsByUnitResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAllLessonsByUnitMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateLesson(com.example.gatewaylesson.GateWayLessonRpcProto.UpdateLessonRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewaylesson.GateWayLessonRpcProto.UpdateLessonResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateLessonMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteLesson(com.example.gatewaylesson.GateWayLessonRpcProto.DeleteLessonRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewaylesson.GateWayLessonRpcProto.DeleteLessonResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteLessonMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class LessonServiceBlockingStub extends io.grpc.stub.AbstractStub<LessonServiceBlockingStub> {
    private LessonServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LessonServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LessonServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LessonServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.gatewaylesson.GateWayLessonRpcProto.CreateLessonResponse createLesson(com.example.gatewaylesson.GateWayLessonRpcProto.CreateLessonRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateLessonMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.gatewaylesson.GateWayLessonRpcProto.GetLessonResponse getLesson(com.example.gatewaylesson.GateWayLessonRpcProto.GetLessonRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetLessonMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.gatewaylesson.GateWayLessonRpcProto.GetAllLessonsByUnitResponse getAllLessonsByUnit(com.example.gatewaylesson.GateWayLessonRpcProto.GetAllLessonsByUnitRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetAllLessonsByUnitMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.gatewaylesson.GateWayLessonRpcProto.UpdateLessonResponse updateLesson(com.example.gatewaylesson.GateWayLessonRpcProto.UpdateLessonRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateLessonMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.gatewaylesson.GateWayLessonRpcProto.DeleteLessonResponse deleteLesson(com.example.gatewaylesson.GateWayLessonRpcProto.DeleteLessonRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteLessonMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class LessonServiceFutureStub extends io.grpc.stub.AbstractStub<LessonServiceFutureStub> {
    private LessonServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LessonServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LessonServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LessonServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.gatewaylesson.GateWayLessonRpcProto.CreateLessonResponse> createLesson(
        com.example.gatewaylesson.GateWayLessonRpcProto.CreateLessonRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateLessonMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.gatewaylesson.GateWayLessonRpcProto.GetLessonResponse> getLesson(
        com.example.gatewaylesson.GateWayLessonRpcProto.GetLessonRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetLessonMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.gatewaylesson.GateWayLessonRpcProto.GetAllLessonsByUnitResponse> getAllLessonsByUnit(
        com.example.gatewaylesson.GateWayLessonRpcProto.GetAllLessonsByUnitRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAllLessonsByUnitMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.gatewaylesson.GateWayLessonRpcProto.UpdateLessonResponse> updateLesson(
        com.example.gatewaylesson.GateWayLessonRpcProto.UpdateLessonRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateLessonMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.gatewaylesson.GateWayLessonRpcProto.DeleteLessonResponse> deleteLesson(
        com.example.gatewaylesson.GateWayLessonRpcProto.DeleteLessonRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteLessonMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_LESSON = 0;
  private static final int METHODID_GET_LESSON = 1;
  private static final int METHODID_GET_ALL_LESSONS_BY_UNIT = 2;
  private static final int METHODID_UPDATE_LESSON = 3;
  private static final int METHODID_DELETE_LESSON = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final LessonServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(LessonServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_LESSON:
          serviceImpl.createLesson((com.example.gatewaylesson.GateWayLessonRpcProto.CreateLessonRequest) request,
              (io.grpc.stub.StreamObserver<com.example.gatewaylesson.GateWayLessonRpcProto.CreateLessonResponse>) responseObserver);
          break;
        case METHODID_GET_LESSON:
          serviceImpl.getLesson((com.example.gatewaylesson.GateWayLessonRpcProto.GetLessonRequest) request,
              (io.grpc.stub.StreamObserver<com.example.gatewaylesson.GateWayLessonRpcProto.GetLessonResponse>) responseObserver);
          break;
        case METHODID_GET_ALL_LESSONS_BY_UNIT:
          serviceImpl.getAllLessonsByUnit((com.example.gatewaylesson.GateWayLessonRpcProto.GetAllLessonsByUnitRequest) request,
              (io.grpc.stub.StreamObserver<com.example.gatewaylesson.GateWayLessonRpcProto.GetAllLessonsByUnitResponse>) responseObserver);
          break;
        case METHODID_UPDATE_LESSON:
          serviceImpl.updateLesson((com.example.gatewaylesson.GateWayLessonRpcProto.UpdateLessonRequest) request,
              (io.grpc.stub.StreamObserver<com.example.gatewaylesson.GateWayLessonRpcProto.UpdateLessonResponse>) responseObserver);
          break;
        case METHODID_DELETE_LESSON:
          serviceImpl.deleteLesson((com.example.gatewaylesson.GateWayLessonRpcProto.DeleteLessonRequest) request,
              (io.grpc.stub.StreamObserver<com.example.gatewaylesson.GateWayLessonRpcProto.DeleteLessonResponse>) responseObserver);
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

  private static abstract class LessonServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LessonServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.gatewaylesson.GateWayLessonRpcProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("LessonService");
    }
  }

  private static final class LessonServiceFileDescriptorSupplier
      extends LessonServiceBaseDescriptorSupplier {
    LessonServiceFileDescriptorSupplier() {}
  }

  private static final class LessonServiceMethodDescriptorSupplier
      extends LessonServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    LessonServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (LessonServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new LessonServiceFileDescriptorSupplier())
              .addMethod(getCreateLessonMethod())
              .addMethod(getGetLessonMethod())
              .addMethod(getGetAllLessonsByUnitMethod())
              .addMethod(getUpdateLessonMethod())
              .addMethod(getDeleteLessonMethod())
              .build();
        }
      }
    }
    return result;
  }
}
