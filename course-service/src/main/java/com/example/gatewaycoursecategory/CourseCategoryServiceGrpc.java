package com.example.gatewaycoursecategory;

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
    comments = "Source: course/courseCategory/GateWay_CourseCategory_Rpc.proto")
public final class CourseCategoryServiceGrpc {

  private CourseCategoryServiceGrpc() {}

  public static final String SERVICE_NAME = "courseCategory.CourseCategoryService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateCourseCategoriesMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.CreateCourseCategoriesRequest,
      com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.CreateCourseCategoriesResponse> METHOD_CREATE_COURSE_CATEGORIES = getCreateCourseCategoriesMethod();

  private static volatile io.grpc.MethodDescriptor<com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.CreateCourseCategoriesRequest,
      com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.CreateCourseCategoriesResponse> getCreateCourseCategoriesMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.CreateCourseCategoriesRequest,
      com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.CreateCourseCategoriesResponse> getCreateCourseCategoriesMethod() {
    io.grpc.MethodDescriptor<com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.CreateCourseCategoriesRequest, com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.CreateCourseCategoriesResponse> getCreateCourseCategoriesMethod;
    if ((getCreateCourseCategoriesMethod = CourseCategoryServiceGrpc.getCreateCourseCategoriesMethod) == null) {
      synchronized (CourseCategoryServiceGrpc.class) {
        if ((getCreateCourseCategoriesMethod = CourseCategoryServiceGrpc.getCreateCourseCategoriesMethod) == null) {
          CourseCategoryServiceGrpc.getCreateCourseCategoriesMethod = getCreateCourseCategoriesMethod = 
              io.grpc.MethodDescriptor.<com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.CreateCourseCategoriesRequest, com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.CreateCourseCategoriesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "courseCategory.CourseCategoryService", "CreateCourseCategories"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.CreateCourseCategoriesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.CreateCourseCategoriesResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CourseCategoryServiceMethodDescriptorSupplier("CreateCourseCategories"))
                  .build();
          }
        }
     }
     return getCreateCourseCategoriesMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetCategoriesByCourseMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.GetCategoriesByCourseRequest,
      com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.GetCategoriesByCourseResponse> METHOD_GET_CATEGORIES_BY_COURSE = getGetCategoriesByCourseMethod();

  private static volatile io.grpc.MethodDescriptor<com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.GetCategoriesByCourseRequest,
      com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.GetCategoriesByCourseResponse> getGetCategoriesByCourseMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.GetCategoriesByCourseRequest,
      com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.GetCategoriesByCourseResponse> getGetCategoriesByCourseMethod() {
    io.grpc.MethodDescriptor<com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.GetCategoriesByCourseRequest, com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.GetCategoriesByCourseResponse> getGetCategoriesByCourseMethod;
    if ((getGetCategoriesByCourseMethod = CourseCategoryServiceGrpc.getGetCategoriesByCourseMethod) == null) {
      synchronized (CourseCategoryServiceGrpc.class) {
        if ((getGetCategoriesByCourseMethod = CourseCategoryServiceGrpc.getGetCategoriesByCourseMethod) == null) {
          CourseCategoryServiceGrpc.getGetCategoriesByCourseMethod = getGetCategoriesByCourseMethod = 
              io.grpc.MethodDescriptor.<com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.GetCategoriesByCourseRequest, com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.GetCategoriesByCourseResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "courseCategory.CourseCategoryService", "GetCategoriesByCourse"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.GetCategoriesByCourseRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.GetCategoriesByCourseResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CourseCategoryServiceMethodDescriptorSupplier("GetCategoriesByCourse"))
                  .build();
          }
        }
     }
     return getGetCategoriesByCourseMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetCourseByCategoryMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.GetCourseByCategoryRequest,
      com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.GetCourseByCategoryResponse> METHOD_GET_COURSE_BY_CATEGORY = getGetCourseByCategoryMethod();

  private static volatile io.grpc.MethodDescriptor<com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.GetCourseByCategoryRequest,
      com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.GetCourseByCategoryResponse> getGetCourseByCategoryMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.GetCourseByCategoryRequest,
      com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.GetCourseByCategoryResponse> getGetCourseByCategoryMethod() {
    io.grpc.MethodDescriptor<com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.GetCourseByCategoryRequest, com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.GetCourseByCategoryResponse> getGetCourseByCategoryMethod;
    if ((getGetCourseByCategoryMethod = CourseCategoryServiceGrpc.getGetCourseByCategoryMethod) == null) {
      synchronized (CourseCategoryServiceGrpc.class) {
        if ((getGetCourseByCategoryMethod = CourseCategoryServiceGrpc.getGetCourseByCategoryMethod) == null) {
          CourseCategoryServiceGrpc.getGetCourseByCategoryMethod = getGetCourseByCategoryMethod = 
              io.grpc.MethodDescriptor.<com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.GetCourseByCategoryRequest, com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.GetCourseByCategoryResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "courseCategory.CourseCategoryService", "GetCourseByCategory"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.GetCourseByCategoryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.GetCourseByCategoryResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CourseCategoryServiceMethodDescriptorSupplier("GetCourseByCategory"))
                  .build();
          }
        }
     }
     return getGetCourseByCategoryMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateCourseCategoryMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.UpdateCourseCategoryRequest,
      com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.UpdateCourseCategoryResponse> METHOD_UPDATE_COURSE_CATEGORY = getUpdateCourseCategoryMethod();

  private static volatile io.grpc.MethodDescriptor<com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.UpdateCourseCategoryRequest,
      com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.UpdateCourseCategoryResponse> getUpdateCourseCategoryMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.UpdateCourseCategoryRequest,
      com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.UpdateCourseCategoryResponse> getUpdateCourseCategoryMethod() {
    io.grpc.MethodDescriptor<com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.UpdateCourseCategoryRequest, com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.UpdateCourseCategoryResponse> getUpdateCourseCategoryMethod;
    if ((getUpdateCourseCategoryMethod = CourseCategoryServiceGrpc.getUpdateCourseCategoryMethod) == null) {
      synchronized (CourseCategoryServiceGrpc.class) {
        if ((getUpdateCourseCategoryMethod = CourseCategoryServiceGrpc.getUpdateCourseCategoryMethod) == null) {
          CourseCategoryServiceGrpc.getUpdateCourseCategoryMethod = getUpdateCourseCategoryMethod = 
              io.grpc.MethodDescriptor.<com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.UpdateCourseCategoryRequest, com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.UpdateCourseCategoryResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "courseCategory.CourseCategoryService", "UpdateCourseCategory"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.UpdateCourseCategoryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.UpdateCourseCategoryResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CourseCategoryServiceMethodDescriptorSupplier("UpdateCourseCategory"))
                  .build();
          }
        }
     }
     return getUpdateCourseCategoryMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteCourseCategoryMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.DeleteCourseCategoryRequest,
      com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.DeleteCourseCategoryResponse> METHOD_DELETE_COURSE_CATEGORY = getDeleteCourseCategoryMethod();

  private static volatile io.grpc.MethodDescriptor<com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.DeleteCourseCategoryRequest,
      com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.DeleteCourseCategoryResponse> getDeleteCourseCategoryMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.DeleteCourseCategoryRequest,
      com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.DeleteCourseCategoryResponse> getDeleteCourseCategoryMethod() {
    io.grpc.MethodDescriptor<com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.DeleteCourseCategoryRequest, com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.DeleteCourseCategoryResponse> getDeleteCourseCategoryMethod;
    if ((getDeleteCourseCategoryMethod = CourseCategoryServiceGrpc.getDeleteCourseCategoryMethod) == null) {
      synchronized (CourseCategoryServiceGrpc.class) {
        if ((getDeleteCourseCategoryMethod = CourseCategoryServiceGrpc.getDeleteCourseCategoryMethod) == null) {
          CourseCategoryServiceGrpc.getDeleteCourseCategoryMethod = getDeleteCourseCategoryMethod = 
              io.grpc.MethodDescriptor.<com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.DeleteCourseCategoryRequest, com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.DeleteCourseCategoryResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "courseCategory.CourseCategoryService", "DeleteCourseCategory"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.DeleteCourseCategoryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.DeleteCourseCategoryResponse.getDefaultInstance()))
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
   */
  public static abstract class CourseCategoryServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void createCourseCategories(com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.CreateCourseCategoriesRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.CreateCourseCategoriesResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateCourseCategoriesMethod(), responseObserver);
    }

    /**
     */
    public void getCategoriesByCourse(com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.GetCategoriesByCourseRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.GetCategoriesByCourseResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetCategoriesByCourseMethod(), responseObserver);
    }

    /**
     */
    public void getCourseByCategory(com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.GetCourseByCategoryRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.GetCourseByCategoryResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetCourseByCategoryMethod(), responseObserver);
    }

    /**
     */
    public void updateCourseCategory(com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.UpdateCourseCategoryRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.UpdateCourseCategoryResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateCourseCategoryMethod(), responseObserver);
    }

    /**
     */
    public void deleteCourseCategory(com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.DeleteCourseCategoryRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.DeleteCourseCategoryResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteCourseCategoryMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateCourseCategoriesMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.CreateCourseCategoriesRequest,
                com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.CreateCourseCategoriesResponse>(
                  this, METHODID_CREATE_COURSE_CATEGORIES)))
          .addMethod(
            getGetCategoriesByCourseMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.GetCategoriesByCourseRequest,
                com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.GetCategoriesByCourseResponse>(
                  this, METHODID_GET_CATEGORIES_BY_COURSE)))
          .addMethod(
            getGetCourseByCategoryMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.GetCourseByCategoryRequest,
                com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.GetCourseByCategoryResponse>(
                  this, METHODID_GET_COURSE_BY_CATEGORY)))
          .addMethod(
            getUpdateCourseCategoryMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.UpdateCourseCategoryRequest,
                com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.UpdateCourseCategoryResponse>(
                  this, METHODID_UPDATE_COURSE_CATEGORY)))
          .addMethod(
            getDeleteCourseCategoryMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.DeleteCourseCategoryRequest,
                com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.DeleteCourseCategoryResponse>(
                  this, METHODID_DELETE_COURSE_CATEGORY)))
          .build();
    }
  }

  /**
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
    public void createCourseCategories(com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.CreateCourseCategoriesRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.CreateCourseCategoriesResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateCourseCategoriesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getCategoriesByCourse(com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.GetCategoriesByCourseRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.GetCategoriesByCourseResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetCategoriesByCourseMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getCourseByCategory(com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.GetCourseByCategoryRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.GetCourseByCategoryResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetCourseByCategoryMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateCourseCategory(com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.UpdateCourseCategoryRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.UpdateCourseCategoryResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateCourseCategoryMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteCourseCategory(com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.DeleteCourseCategoryRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.DeleteCourseCategoryResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteCourseCategoryMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
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
    public com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.CreateCourseCategoriesResponse createCourseCategories(com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.CreateCourseCategoriesRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateCourseCategoriesMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.GetCategoriesByCourseResponse getCategoriesByCourse(com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.GetCategoriesByCourseRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetCategoriesByCourseMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.GetCourseByCategoryResponse getCourseByCategory(com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.GetCourseByCategoryRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetCourseByCategoryMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.UpdateCourseCategoryResponse updateCourseCategory(com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.UpdateCourseCategoryRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateCourseCategoryMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.DeleteCourseCategoryResponse deleteCourseCategory(com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.DeleteCourseCategoryRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteCourseCategoryMethod(), getCallOptions(), request);
    }
  }

  /**
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
    public com.google.common.util.concurrent.ListenableFuture<com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.CreateCourseCategoriesResponse> createCourseCategories(
        com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.CreateCourseCategoriesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateCourseCategoriesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.GetCategoriesByCourseResponse> getCategoriesByCourse(
        com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.GetCategoriesByCourseRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetCategoriesByCourseMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.GetCourseByCategoryResponse> getCourseByCategory(
        com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.GetCourseByCategoryRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetCourseByCategoryMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.UpdateCourseCategoryResponse> updateCourseCategory(
        com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.UpdateCourseCategoryRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateCourseCategoryMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.DeleteCourseCategoryResponse> deleteCourseCategory(
        com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.DeleteCourseCategoryRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteCourseCategoryMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_COURSE_CATEGORIES = 0;
  private static final int METHODID_GET_CATEGORIES_BY_COURSE = 1;
  private static final int METHODID_GET_COURSE_BY_CATEGORY = 2;
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
        case METHODID_CREATE_COURSE_CATEGORIES:
          serviceImpl.createCourseCategories((com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.CreateCourseCategoriesRequest) request,
              (io.grpc.stub.StreamObserver<com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.CreateCourseCategoriesResponse>) responseObserver);
          break;
        case METHODID_GET_CATEGORIES_BY_COURSE:
          serviceImpl.getCategoriesByCourse((com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.GetCategoriesByCourseRequest) request,
              (io.grpc.stub.StreamObserver<com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.GetCategoriesByCourseResponse>) responseObserver);
          break;
        case METHODID_GET_COURSE_BY_CATEGORY:
          serviceImpl.getCourseByCategory((com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.GetCourseByCategoryRequest) request,
              (io.grpc.stub.StreamObserver<com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.GetCourseByCategoryResponse>) responseObserver);
          break;
        case METHODID_UPDATE_COURSE_CATEGORY:
          serviceImpl.updateCourseCategory((com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.UpdateCourseCategoryRequest) request,
              (io.grpc.stub.StreamObserver<com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.UpdateCourseCategoryResponse>) responseObserver);
          break;
        case METHODID_DELETE_COURSE_CATEGORY:
          serviceImpl.deleteCourseCategory((com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.DeleteCourseCategoryRequest) request,
              (io.grpc.stub.StreamObserver<com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.DeleteCourseCategoryResponse>) responseObserver);
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
      return com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.getDescriptor();
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
              .addMethod(getCreateCourseCategoriesMethod())
              .addMethod(getGetCategoriesByCourseMethod())
              .addMethod(getGetCourseByCategoryMethod())
              .addMethod(getUpdateCourseCategoryMethod())
              .addMethod(getDeleteCourseCategoryMethod())
              .build();
        }
      }
    }
    return result;
  }
}
