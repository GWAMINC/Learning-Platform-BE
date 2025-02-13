package com.example.gatewaycourse;

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
 * <pre>
 * Service cho CourseCategory
 * </pre>
 */
@jakarta.annotation.Generated(
    value = "by gRPC proto compiler (version 1.9.1)",
    comments = "Source: GateWay_Course_Rpc.proto")
public final class CourseCategoryServiceGrpc {

  private CourseCategoryServiceGrpc() {}

  public static final String SERVICE_NAME = "course.CourseCategoryService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateCourseCategoryMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.example.gatewaycourse.GateWayCourseRpcProto.CreateCourseCategoryRequest,
      com.example.gatewaycourse.GateWayCourseRpcProto.CreateCourseCategoryResponse> METHOD_CREATE_COURSE_CATEGORY = getCreateCourseCategoryMethod();

  private static volatile io.grpc.MethodDescriptor<com.example.gatewaycourse.GateWayCourseRpcProto.CreateCourseCategoryRequest,
      com.example.gatewaycourse.GateWayCourseRpcProto.CreateCourseCategoryResponse> getCreateCourseCategoryMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.example.gatewaycourse.GateWayCourseRpcProto.CreateCourseCategoryRequest,
      com.example.gatewaycourse.GateWayCourseRpcProto.CreateCourseCategoryResponse> getCreateCourseCategoryMethod() {
    io.grpc.MethodDescriptor<com.example.gatewaycourse.GateWayCourseRpcProto.CreateCourseCategoryRequest, com.example.gatewaycourse.GateWayCourseRpcProto.CreateCourseCategoryResponse> getCreateCourseCategoryMethod;
    if ((getCreateCourseCategoryMethod = CourseCategoryServiceGrpc.getCreateCourseCategoryMethod) == null) {
      synchronized (CourseCategoryServiceGrpc.class) {
        if ((getCreateCourseCategoryMethod = CourseCategoryServiceGrpc.getCreateCourseCategoryMethod) == null) {
          CourseCategoryServiceGrpc.getCreateCourseCategoryMethod = getCreateCourseCategoryMethod = 
              io.grpc.MethodDescriptor.<com.example.gatewaycourse.GateWayCourseRpcProto.CreateCourseCategoryRequest, com.example.gatewaycourse.GateWayCourseRpcProto.CreateCourseCategoryResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "course.CourseCategoryService", "CreateCourseCategory"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewaycourse.GateWayCourseRpcProto.CreateCourseCategoryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewaycourse.GateWayCourseRpcProto.CreateCourseCategoryResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CourseCategoryServiceMethodDescriptorSupplier("CreateCourseCategory"))
                  .build();
          }
        }
     }
     return getCreateCourseCategoryMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetCourseCategoryMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.example.gatewaycourse.GateWayCourseRpcProto.GetCourseCategoryRequest,
      com.example.gatewaycourse.GateWayCourseRpcProto.GetCourseCategoryResponse> METHOD_GET_COURSE_CATEGORY = getGetCourseCategoryMethod();

  private static volatile io.grpc.MethodDescriptor<com.example.gatewaycourse.GateWayCourseRpcProto.GetCourseCategoryRequest,
      com.example.gatewaycourse.GateWayCourseRpcProto.GetCourseCategoryResponse> getGetCourseCategoryMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.example.gatewaycourse.GateWayCourseRpcProto.GetCourseCategoryRequest,
      com.example.gatewaycourse.GateWayCourseRpcProto.GetCourseCategoryResponse> getGetCourseCategoryMethod() {
    io.grpc.MethodDescriptor<com.example.gatewaycourse.GateWayCourseRpcProto.GetCourseCategoryRequest, com.example.gatewaycourse.GateWayCourseRpcProto.GetCourseCategoryResponse> getGetCourseCategoryMethod;
    if ((getGetCourseCategoryMethod = CourseCategoryServiceGrpc.getGetCourseCategoryMethod) == null) {
      synchronized (CourseCategoryServiceGrpc.class) {
        if ((getGetCourseCategoryMethod = CourseCategoryServiceGrpc.getGetCourseCategoryMethod) == null) {
          CourseCategoryServiceGrpc.getGetCourseCategoryMethod = getGetCourseCategoryMethod = 
              io.grpc.MethodDescriptor.<com.example.gatewaycourse.GateWayCourseRpcProto.GetCourseCategoryRequest, com.example.gatewaycourse.GateWayCourseRpcProto.GetCourseCategoryResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "course.CourseCategoryService", "GetCourseCategory"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewaycourse.GateWayCourseRpcProto.GetCourseCategoryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewaycourse.GateWayCourseRpcProto.GetCourseCategoryResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CourseCategoryServiceMethodDescriptorSupplier("GetCourseCategory"))
                  .build();
          }
        }
     }
     return getGetCourseCategoryMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetCourseCategoryByCourseIdMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.example.gatewaycourse.GateWayCourseRpcProto.GetCourseCategoryByCourseIdRequest,
      com.example.gatewaycourse.GateWayCourseRpcProto.GetCourseCategoryByCourseIdResponse> METHOD_GET_COURSE_CATEGORY_BY_COURSE_ID = getGetCourseCategoryByCourseIdMethod();

  private static volatile io.grpc.MethodDescriptor<com.example.gatewaycourse.GateWayCourseRpcProto.GetCourseCategoryByCourseIdRequest,
      com.example.gatewaycourse.GateWayCourseRpcProto.GetCourseCategoryByCourseIdResponse> getGetCourseCategoryByCourseIdMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.example.gatewaycourse.GateWayCourseRpcProto.GetCourseCategoryByCourseIdRequest,
      com.example.gatewaycourse.GateWayCourseRpcProto.GetCourseCategoryByCourseIdResponse> getGetCourseCategoryByCourseIdMethod() {
    io.grpc.MethodDescriptor<com.example.gatewaycourse.GateWayCourseRpcProto.GetCourseCategoryByCourseIdRequest, com.example.gatewaycourse.GateWayCourseRpcProto.GetCourseCategoryByCourseIdResponse> getGetCourseCategoryByCourseIdMethod;
    if ((getGetCourseCategoryByCourseIdMethod = CourseCategoryServiceGrpc.getGetCourseCategoryByCourseIdMethod) == null) {
      synchronized (CourseCategoryServiceGrpc.class) {
        if ((getGetCourseCategoryByCourseIdMethod = CourseCategoryServiceGrpc.getGetCourseCategoryByCourseIdMethod) == null) {
          CourseCategoryServiceGrpc.getGetCourseCategoryByCourseIdMethod = getGetCourseCategoryByCourseIdMethod = 
              io.grpc.MethodDescriptor.<com.example.gatewaycourse.GateWayCourseRpcProto.GetCourseCategoryByCourseIdRequest, com.example.gatewaycourse.GateWayCourseRpcProto.GetCourseCategoryByCourseIdResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "course.CourseCategoryService", "GetCourseCategoryByCourseId"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewaycourse.GateWayCourseRpcProto.GetCourseCategoryByCourseIdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewaycourse.GateWayCourseRpcProto.GetCourseCategoryByCourseIdResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CourseCategoryServiceMethodDescriptorSupplier("GetCourseCategoryByCourseId"))
                  .build();
          }
        }
     }
     return getGetCourseCategoryByCourseIdMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateCourseCategoryMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.example.gatewaycourse.GateWayCourseRpcProto.UpdateCourseCategoryRequest,
      com.example.gatewaycourse.GateWayCourseRpcProto.UpdateCourseCategoryResponse> METHOD_UPDATE_COURSE_CATEGORY = getUpdateCourseCategoryMethod();

  private static volatile io.grpc.MethodDescriptor<com.example.gatewaycourse.GateWayCourseRpcProto.UpdateCourseCategoryRequest,
      com.example.gatewaycourse.GateWayCourseRpcProto.UpdateCourseCategoryResponse> getUpdateCourseCategoryMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.example.gatewaycourse.GateWayCourseRpcProto.UpdateCourseCategoryRequest,
      com.example.gatewaycourse.GateWayCourseRpcProto.UpdateCourseCategoryResponse> getUpdateCourseCategoryMethod() {
    io.grpc.MethodDescriptor<com.example.gatewaycourse.GateWayCourseRpcProto.UpdateCourseCategoryRequest, com.example.gatewaycourse.GateWayCourseRpcProto.UpdateCourseCategoryResponse> getUpdateCourseCategoryMethod;
    if ((getUpdateCourseCategoryMethod = CourseCategoryServiceGrpc.getUpdateCourseCategoryMethod) == null) {
      synchronized (CourseCategoryServiceGrpc.class) {
        if ((getUpdateCourseCategoryMethod = CourseCategoryServiceGrpc.getUpdateCourseCategoryMethod) == null) {
          CourseCategoryServiceGrpc.getUpdateCourseCategoryMethod = getUpdateCourseCategoryMethod = 
              io.grpc.MethodDescriptor.<com.example.gatewaycourse.GateWayCourseRpcProto.UpdateCourseCategoryRequest, com.example.gatewaycourse.GateWayCourseRpcProto.UpdateCourseCategoryResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "course.CourseCategoryService", "UpdateCourseCategory"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewaycourse.GateWayCourseRpcProto.UpdateCourseCategoryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewaycourse.GateWayCourseRpcProto.UpdateCourseCategoryResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CourseCategoryServiceMethodDescriptorSupplier("UpdateCourseCategory"))
                  .build();
          }
        }
     }
     return getUpdateCourseCategoryMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteCourseCategoryMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.example.gatewaycourse.GateWayCourseRpcProto.DeleteCourseCategoryRequest,
      com.example.gatewaycourse.GateWayCourseRpcProto.DeleteCourseCategoryResponse> METHOD_DELETE_COURSE_CATEGORY = getDeleteCourseCategoryMethod();

  private static volatile io.grpc.MethodDescriptor<com.example.gatewaycourse.GateWayCourseRpcProto.DeleteCourseCategoryRequest,
      com.example.gatewaycourse.GateWayCourseRpcProto.DeleteCourseCategoryResponse> getDeleteCourseCategoryMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.example.gatewaycourse.GateWayCourseRpcProto.DeleteCourseCategoryRequest,
      com.example.gatewaycourse.GateWayCourseRpcProto.DeleteCourseCategoryResponse> getDeleteCourseCategoryMethod() {
    io.grpc.MethodDescriptor<com.example.gatewaycourse.GateWayCourseRpcProto.DeleteCourseCategoryRequest, com.example.gatewaycourse.GateWayCourseRpcProto.DeleteCourseCategoryResponse> getDeleteCourseCategoryMethod;
    if ((getDeleteCourseCategoryMethod = CourseCategoryServiceGrpc.getDeleteCourseCategoryMethod) == null) {
      synchronized (CourseCategoryServiceGrpc.class) {
        if ((getDeleteCourseCategoryMethod = CourseCategoryServiceGrpc.getDeleteCourseCategoryMethod) == null) {
          CourseCategoryServiceGrpc.getDeleteCourseCategoryMethod = getDeleteCourseCategoryMethod = 
              io.grpc.MethodDescriptor.<com.example.gatewaycourse.GateWayCourseRpcProto.DeleteCourseCategoryRequest, com.example.gatewaycourse.GateWayCourseRpcProto.DeleteCourseCategoryResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "course.CourseCategoryService", "DeleteCourseCategory"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewaycourse.GateWayCourseRpcProto.DeleteCourseCategoryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewaycourse.GateWayCourseRpcProto.DeleteCourseCategoryResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CourseCategoryServiceMethodDescriptorSupplier("DeleteCourseCategory"))
                  .build();
          }
        }
     }
     return getDeleteCourseCategoryMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CourseCategoryServiceStub newStub(io.grpc.Channel channel) {
    return new CourseCategoryServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CourseCategoryServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CourseCategoryServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CourseCategoryServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CourseCategoryServiceFutureStub(channel);
  }

  /**
   * <pre>
   * Service cho CourseCategory
   * </pre>
   */
  public static abstract class CourseCategoryServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void createCourseCategory(com.example.gatewaycourse.GateWayCourseRpcProto.CreateCourseCategoryRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewaycourse.GateWayCourseRpcProto.CreateCourseCategoryResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateCourseCategoryMethod(), responseObserver);
    }

    /**
     */
    public void getCourseCategory(com.example.gatewaycourse.GateWayCourseRpcProto.GetCourseCategoryRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewaycourse.GateWayCourseRpcProto.GetCourseCategoryResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetCourseCategoryMethod(), responseObserver);
    }

    /**
     */
    public void getCourseCategoryByCourseId(com.example.gatewaycourse.GateWayCourseRpcProto.GetCourseCategoryByCourseIdRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewaycourse.GateWayCourseRpcProto.GetCourseCategoryByCourseIdResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetCourseCategoryByCourseIdMethod(), responseObserver);
    }

    /**
     */
    public void updateCourseCategory(com.example.gatewaycourse.GateWayCourseRpcProto.UpdateCourseCategoryRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewaycourse.GateWayCourseRpcProto.UpdateCourseCategoryResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateCourseCategoryMethod(), responseObserver);
    }

    /**
     */
    public void deleteCourseCategory(com.example.gatewaycourse.GateWayCourseRpcProto.DeleteCourseCategoryRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewaycourse.GateWayCourseRpcProto.DeleteCourseCategoryResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteCourseCategoryMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateCourseCategoryMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.gatewaycourse.GateWayCourseRpcProto.CreateCourseCategoryRequest,
                com.example.gatewaycourse.GateWayCourseRpcProto.CreateCourseCategoryResponse>(
                  this, METHODID_CREATE_COURSE_CATEGORY)))
          .addMethod(
            getGetCourseCategoryMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.gatewaycourse.GateWayCourseRpcProto.GetCourseCategoryRequest,
                com.example.gatewaycourse.GateWayCourseRpcProto.GetCourseCategoryResponse>(
                  this, METHODID_GET_COURSE_CATEGORY)))
          .addMethod(
            getGetCourseCategoryByCourseIdMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.gatewaycourse.GateWayCourseRpcProto.GetCourseCategoryByCourseIdRequest,
                com.example.gatewaycourse.GateWayCourseRpcProto.GetCourseCategoryByCourseIdResponse>(
                  this, METHODID_GET_COURSE_CATEGORY_BY_COURSE_ID)))
          .addMethod(
            getUpdateCourseCategoryMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.gatewaycourse.GateWayCourseRpcProto.UpdateCourseCategoryRequest,
                com.example.gatewaycourse.GateWayCourseRpcProto.UpdateCourseCategoryResponse>(
                  this, METHODID_UPDATE_COURSE_CATEGORY)))
          .addMethod(
            getDeleteCourseCategoryMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.gatewaycourse.GateWayCourseRpcProto.DeleteCourseCategoryRequest,
                com.example.gatewaycourse.GateWayCourseRpcProto.DeleteCourseCategoryResponse>(
                  this, METHODID_DELETE_COURSE_CATEGORY)))
          .build();
    }
  }

  /**
   * <pre>
   * Service cho CourseCategory
   * </pre>
   */
  public static final class CourseCategoryServiceStub extends io.grpc.stub.AbstractStub<CourseCategoryServiceStub> {
    private CourseCategoryServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CourseCategoryServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CourseCategoryServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CourseCategoryServiceStub(channel, callOptions);
    }

    /**
     */
    public void createCourseCategory(com.example.gatewaycourse.GateWayCourseRpcProto.CreateCourseCategoryRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewaycourse.GateWayCourseRpcProto.CreateCourseCategoryResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateCourseCategoryMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getCourseCategory(com.example.gatewaycourse.GateWayCourseRpcProto.GetCourseCategoryRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewaycourse.GateWayCourseRpcProto.GetCourseCategoryResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetCourseCategoryMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getCourseCategoryByCourseId(com.example.gatewaycourse.GateWayCourseRpcProto.GetCourseCategoryByCourseIdRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewaycourse.GateWayCourseRpcProto.GetCourseCategoryByCourseIdResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetCourseCategoryByCourseIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateCourseCategory(com.example.gatewaycourse.GateWayCourseRpcProto.UpdateCourseCategoryRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewaycourse.GateWayCourseRpcProto.UpdateCourseCategoryResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateCourseCategoryMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteCourseCategory(com.example.gatewaycourse.GateWayCourseRpcProto.DeleteCourseCategoryRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewaycourse.GateWayCourseRpcProto.DeleteCourseCategoryResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteCourseCategoryMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Service cho CourseCategory
   * </pre>
   */
  public static final class CourseCategoryServiceBlockingStub extends io.grpc.stub.AbstractStub<CourseCategoryServiceBlockingStub> {
    private CourseCategoryServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CourseCategoryServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CourseCategoryServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CourseCategoryServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.gatewaycourse.GateWayCourseRpcProto.CreateCourseCategoryResponse createCourseCategory(com.example.gatewaycourse.GateWayCourseRpcProto.CreateCourseCategoryRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateCourseCategoryMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.gatewaycourse.GateWayCourseRpcProto.GetCourseCategoryResponse getCourseCategory(com.example.gatewaycourse.GateWayCourseRpcProto.GetCourseCategoryRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetCourseCategoryMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.gatewaycourse.GateWayCourseRpcProto.GetCourseCategoryByCourseIdResponse getCourseCategoryByCourseId(com.example.gatewaycourse.GateWayCourseRpcProto.GetCourseCategoryByCourseIdRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetCourseCategoryByCourseIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.gatewaycourse.GateWayCourseRpcProto.UpdateCourseCategoryResponse updateCourseCategory(com.example.gatewaycourse.GateWayCourseRpcProto.UpdateCourseCategoryRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateCourseCategoryMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.gatewaycourse.GateWayCourseRpcProto.DeleteCourseCategoryResponse deleteCourseCategory(com.example.gatewaycourse.GateWayCourseRpcProto.DeleteCourseCategoryRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteCourseCategoryMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Service cho CourseCategory
   * </pre>
   */
  public static final class CourseCategoryServiceFutureStub extends io.grpc.stub.AbstractStub<CourseCategoryServiceFutureStub> {
    private CourseCategoryServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CourseCategoryServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CourseCategoryServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CourseCategoryServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.gatewaycourse.GateWayCourseRpcProto.CreateCourseCategoryResponse> createCourseCategory(
        com.example.gatewaycourse.GateWayCourseRpcProto.CreateCourseCategoryRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateCourseCategoryMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.gatewaycourse.GateWayCourseRpcProto.GetCourseCategoryResponse> getCourseCategory(
        com.example.gatewaycourse.GateWayCourseRpcProto.GetCourseCategoryRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetCourseCategoryMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.gatewaycourse.GateWayCourseRpcProto.GetCourseCategoryByCourseIdResponse> getCourseCategoryByCourseId(
        com.example.gatewaycourse.GateWayCourseRpcProto.GetCourseCategoryByCourseIdRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetCourseCategoryByCourseIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.gatewaycourse.GateWayCourseRpcProto.UpdateCourseCategoryResponse> updateCourseCategory(
        com.example.gatewaycourse.GateWayCourseRpcProto.UpdateCourseCategoryRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateCourseCategoryMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.gatewaycourse.GateWayCourseRpcProto.DeleteCourseCategoryResponse> deleteCourseCategory(
        com.example.gatewaycourse.GateWayCourseRpcProto.DeleteCourseCategoryRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteCourseCategoryMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_COURSE_CATEGORY = 0;
  private static final int METHODID_GET_COURSE_CATEGORY = 1;
  private static final int METHODID_GET_COURSE_CATEGORY_BY_COURSE_ID = 2;
  private static final int METHODID_UPDATE_COURSE_CATEGORY = 3;
  private static final int METHODID_DELETE_COURSE_CATEGORY = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CourseCategoryServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CourseCategoryServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_COURSE_CATEGORY:
          serviceImpl.createCourseCategory((com.example.gatewaycourse.GateWayCourseRpcProto.CreateCourseCategoryRequest) request,
              (io.grpc.stub.StreamObserver<com.example.gatewaycourse.GateWayCourseRpcProto.CreateCourseCategoryResponse>) responseObserver);
          break;
        case METHODID_GET_COURSE_CATEGORY:
          serviceImpl.getCourseCategory((com.example.gatewaycourse.GateWayCourseRpcProto.GetCourseCategoryRequest) request,
              (io.grpc.stub.StreamObserver<com.example.gatewaycourse.GateWayCourseRpcProto.GetCourseCategoryResponse>) responseObserver);
          break;
        case METHODID_GET_COURSE_CATEGORY_BY_COURSE_ID:
          serviceImpl.getCourseCategoryByCourseId((com.example.gatewaycourse.GateWayCourseRpcProto.GetCourseCategoryByCourseIdRequest) request,
              (io.grpc.stub.StreamObserver<com.example.gatewaycourse.GateWayCourseRpcProto.GetCourseCategoryByCourseIdResponse>) responseObserver);
          break;
        case METHODID_UPDATE_COURSE_CATEGORY:
          serviceImpl.updateCourseCategory((com.example.gatewaycourse.GateWayCourseRpcProto.UpdateCourseCategoryRequest) request,
              (io.grpc.stub.StreamObserver<com.example.gatewaycourse.GateWayCourseRpcProto.UpdateCourseCategoryResponse>) responseObserver);
          break;
        case METHODID_DELETE_COURSE_CATEGORY:
          serviceImpl.deleteCourseCategory((com.example.gatewaycourse.GateWayCourseRpcProto.DeleteCourseCategoryRequest) request,
              (io.grpc.stub.StreamObserver<com.example.gatewaycourse.GateWayCourseRpcProto.DeleteCourseCategoryResponse>) responseObserver);
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

  private static abstract class CourseCategoryServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CourseCategoryServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.gatewaycourse.GateWayCourseRpcProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CourseCategoryService");
    }
  }

  private static final class CourseCategoryServiceFileDescriptorSupplier
      extends CourseCategoryServiceBaseDescriptorSupplier {
    CourseCategoryServiceFileDescriptorSupplier() {}
  }

  private static final class CourseCategoryServiceMethodDescriptorSupplier
      extends CourseCategoryServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CourseCategoryServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (CourseCategoryServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CourseCategoryServiceFileDescriptorSupplier())
              .addMethod(getCreateCourseCategoryMethod())
              .addMethod(getGetCourseCategoryMethod())
              .addMethod(getGetCourseCategoryByCourseIdMethod())
              .addMethod(getUpdateCourseCategoryMethod())
              .addMethod(getDeleteCourseCategoryMethod())
              .build();
        }
      }
    }
    return result;
  }
}
