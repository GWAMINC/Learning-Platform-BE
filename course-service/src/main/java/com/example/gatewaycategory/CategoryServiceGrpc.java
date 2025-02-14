package com.example.gatewaycategory;

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
 * Service cho Category
 * </pre>
 */
@jakarta.annotation.Generated(
    value = "by gRPC proto compiler (version 1.9.1)",
    comments = "Source: course/category/GateWay_Category_Rpc.proto")
public final class CategoryServiceGrpc {

  private CategoryServiceGrpc() {}

  public static final String SERVICE_NAME = "category.CategoryService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateCategoryMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.example.gatewaycategory.GateWayCategoryRpcProto.CreateCategoryRequest,
      com.example.gatewaycategory.GateWayCategoryRpcProto.CreateCategoryResponse> METHOD_CREATE_CATEGORY = getCreateCategoryMethod();

  private static volatile io.grpc.MethodDescriptor<com.example.gatewaycategory.GateWayCategoryRpcProto.CreateCategoryRequest,
      com.example.gatewaycategory.GateWayCategoryRpcProto.CreateCategoryResponse> getCreateCategoryMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.example.gatewaycategory.GateWayCategoryRpcProto.CreateCategoryRequest,
      com.example.gatewaycategory.GateWayCategoryRpcProto.CreateCategoryResponse> getCreateCategoryMethod() {
    io.grpc.MethodDescriptor<com.example.gatewaycategory.GateWayCategoryRpcProto.CreateCategoryRequest, com.example.gatewaycategory.GateWayCategoryRpcProto.CreateCategoryResponse> getCreateCategoryMethod;
    if ((getCreateCategoryMethod = CategoryServiceGrpc.getCreateCategoryMethod) == null) {
      synchronized (CategoryServiceGrpc.class) {
        if ((getCreateCategoryMethod = CategoryServiceGrpc.getCreateCategoryMethod) == null) {
          CategoryServiceGrpc.getCreateCategoryMethod = getCreateCategoryMethod = 
              io.grpc.MethodDescriptor.<com.example.gatewaycategory.GateWayCategoryRpcProto.CreateCategoryRequest, com.example.gatewaycategory.GateWayCategoryRpcProto.CreateCategoryResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "category.CategoryService", "CreateCategory"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewaycategory.GateWayCategoryRpcProto.CreateCategoryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewaycategory.GateWayCategoryRpcProto.CreateCategoryResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CategoryServiceMethodDescriptorSupplier("CreateCategory"))
                  .build();
          }
        }
     }
     return getCreateCategoryMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetCategoryMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.example.gatewaycategory.GateWayCategoryRpcProto.GetCategoryRequest,
      com.example.gatewaycategory.GateWayCategoryRpcProto.GetCategoryResponse> METHOD_GET_CATEGORY = getGetCategoryMethod();

  private static volatile io.grpc.MethodDescriptor<com.example.gatewaycategory.GateWayCategoryRpcProto.GetCategoryRequest,
      com.example.gatewaycategory.GateWayCategoryRpcProto.GetCategoryResponse> getGetCategoryMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.example.gatewaycategory.GateWayCategoryRpcProto.GetCategoryRequest,
      com.example.gatewaycategory.GateWayCategoryRpcProto.GetCategoryResponse> getGetCategoryMethod() {
    io.grpc.MethodDescriptor<com.example.gatewaycategory.GateWayCategoryRpcProto.GetCategoryRequest, com.example.gatewaycategory.GateWayCategoryRpcProto.GetCategoryResponse> getGetCategoryMethod;
    if ((getGetCategoryMethod = CategoryServiceGrpc.getGetCategoryMethod) == null) {
      synchronized (CategoryServiceGrpc.class) {
        if ((getGetCategoryMethod = CategoryServiceGrpc.getGetCategoryMethod) == null) {
          CategoryServiceGrpc.getGetCategoryMethod = getGetCategoryMethod = 
              io.grpc.MethodDescriptor.<com.example.gatewaycategory.GateWayCategoryRpcProto.GetCategoryRequest, com.example.gatewaycategory.GateWayCategoryRpcProto.GetCategoryResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "category.CategoryService", "GetCategory"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewaycategory.GateWayCategoryRpcProto.GetCategoryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewaycategory.GateWayCategoryRpcProto.GetCategoryResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CategoryServiceMethodDescriptorSupplier("GetCategory"))
                  .build();
          }
        }
     }
     return getGetCategoryMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetAllCategoriesMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.example.gatewaycategory.GateWayCategoryRpcProto.GetAllCategoriesRequest,
      com.example.gatewaycategory.GateWayCategoryRpcProto.GetAllCategoriesResponse> METHOD_GET_ALL_CATEGORIES = getGetAllCategoriesMethod();

  private static volatile io.grpc.MethodDescriptor<com.example.gatewaycategory.GateWayCategoryRpcProto.GetAllCategoriesRequest,
      com.example.gatewaycategory.GateWayCategoryRpcProto.GetAllCategoriesResponse> getGetAllCategoriesMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.example.gatewaycategory.GateWayCategoryRpcProto.GetAllCategoriesRequest,
      com.example.gatewaycategory.GateWayCategoryRpcProto.GetAllCategoriesResponse> getGetAllCategoriesMethod() {
    io.grpc.MethodDescriptor<com.example.gatewaycategory.GateWayCategoryRpcProto.GetAllCategoriesRequest, com.example.gatewaycategory.GateWayCategoryRpcProto.GetAllCategoriesResponse> getGetAllCategoriesMethod;
    if ((getGetAllCategoriesMethod = CategoryServiceGrpc.getGetAllCategoriesMethod) == null) {
      synchronized (CategoryServiceGrpc.class) {
        if ((getGetAllCategoriesMethod = CategoryServiceGrpc.getGetAllCategoriesMethod) == null) {
          CategoryServiceGrpc.getGetAllCategoriesMethod = getGetAllCategoriesMethod = 
              io.grpc.MethodDescriptor.<com.example.gatewaycategory.GateWayCategoryRpcProto.GetAllCategoriesRequest, com.example.gatewaycategory.GateWayCategoryRpcProto.GetAllCategoriesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "category.CategoryService", "GetAllCategories"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewaycategory.GateWayCategoryRpcProto.GetAllCategoriesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewaycategory.GateWayCategoryRpcProto.GetAllCategoriesResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CategoryServiceMethodDescriptorSupplier("GetAllCategories"))
                  .build();
          }
        }
     }
     return getGetAllCategoriesMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateCategoryMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.example.gatewaycategory.GateWayCategoryRpcProto.UpdateCategoryRequest,
      com.example.gatewaycategory.GateWayCategoryRpcProto.UpdateCategoryResponse> METHOD_UPDATE_CATEGORY = getUpdateCategoryMethod();

  private static volatile io.grpc.MethodDescriptor<com.example.gatewaycategory.GateWayCategoryRpcProto.UpdateCategoryRequest,
      com.example.gatewaycategory.GateWayCategoryRpcProto.UpdateCategoryResponse> getUpdateCategoryMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.example.gatewaycategory.GateWayCategoryRpcProto.UpdateCategoryRequest,
      com.example.gatewaycategory.GateWayCategoryRpcProto.UpdateCategoryResponse> getUpdateCategoryMethod() {
    io.grpc.MethodDescriptor<com.example.gatewaycategory.GateWayCategoryRpcProto.UpdateCategoryRequest, com.example.gatewaycategory.GateWayCategoryRpcProto.UpdateCategoryResponse> getUpdateCategoryMethod;
    if ((getUpdateCategoryMethod = CategoryServiceGrpc.getUpdateCategoryMethod) == null) {
      synchronized (CategoryServiceGrpc.class) {
        if ((getUpdateCategoryMethod = CategoryServiceGrpc.getUpdateCategoryMethod) == null) {
          CategoryServiceGrpc.getUpdateCategoryMethod = getUpdateCategoryMethod = 
              io.grpc.MethodDescriptor.<com.example.gatewaycategory.GateWayCategoryRpcProto.UpdateCategoryRequest, com.example.gatewaycategory.GateWayCategoryRpcProto.UpdateCategoryResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "category.CategoryService", "UpdateCategory"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewaycategory.GateWayCategoryRpcProto.UpdateCategoryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewaycategory.GateWayCategoryRpcProto.UpdateCategoryResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CategoryServiceMethodDescriptorSupplier("UpdateCategory"))
                  .build();
          }
        }
     }
     return getUpdateCategoryMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteCategoryMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.example.gatewaycategory.GateWayCategoryRpcProto.DeleteCategoryRequest,
      com.example.gatewaycategory.GateWayCategoryRpcProto.DeleteCategoryResponse> METHOD_DELETE_CATEGORY = getDeleteCategoryMethod();

  private static volatile io.grpc.MethodDescriptor<com.example.gatewaycategory.GateWayCategoryRpcProto.DeleteCategoryRequest,
      com.example.gatewaycategory.GateWayCategoryRpcProto.DeleteCategoryResponse> getDeleteCategoryMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.example.gatewaycategory.GateWayCategoryRpcProto.DeleteCategoryRequest,
      com.example.gatewaycategory.GateWayCategoryRpcProto.DeleteCategoryResponse> getDeleteCategoryMethod() {
    io.grpc.MethodDescriptor<com.example.gatewaycategory.GateWayCategoryRpcProto.DeleteCategoryRequest, com.example.gatewaycategory.GateWayCategoryRpcProto.DeleteCategoryResponse> getDeleteCategoryMethod;
    if ((getDeleteCategoryMethod = CategoryServiceGrpc.getDeleteCategoryMethod) == null) {
      synchronized (CategoryServiceGrpc.class) {
        if ((getDeleteCategoryMethod = CategoryServiceGrpc.getDeleteCategoryMethod) == null) {
          CategoryServiceGrpc.getDeleteCategoryMethod = getDeleteCategoryMethod = 
              io.grpc.MethodDescriptor.<com.example.gatewaycategory.GateWayCategoryRpcProto.DeleteCategoryRequest, com.example.gatewaycategory.GateWayCategoryRpcProto.DeleteCategoryResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "category.CategoryService", "DeleteCategory"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewaycategory.GateWayCategoryRpcProto.DeleteCategoryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewaycategory.GateWayCategoryRpcProto.DeleteCategoryResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CategoryServiceMethodDescriptorSupplier("DeleteCategory"))
                  .build();
          }
        }
     }
     return getDeleteCategoryMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CategoryServiceStub newStub(io.grpc.Channel channel) {
    return new CategoryServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CategoryServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CategoryServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CategoryServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CategoryServiceFutureStub(channel);
  }

  /**
   * <pre>
   * Service cho Category
   * </pre>
   */
  public static abstract class CategoryServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void createCategory(com.example.gatewaycategory.GateWayCategoryRpcProto.CreateCategoryRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewaycategory.GateWayCategoryRpcProto.CreateCategoryResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateCategoryMethod(), responseObserver);
    }

    /**
     */
    public void getCategory(com.example.gatewaycategory.GateWayCategoryRpcProto.GetCategoryRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewaycategory.GateWayCategoryRpcProto.GetCategoryResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetCategoryMethod(), responseObserver);
    }

    /**
     */
    public void getAllCategories(com.example.gatewaycategory.GateWayCategoryRpcProto.GetAllCategoriesRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewaycategory.GateWayCategoryRpcProto.GetAllCategoriesResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAllCategoriesMethod(), responseObserver);
    }

    /**
     */
    public void updateCategory(com.example.gatewaycategory.GateWayCategoryRpcProto.UpdateCategoryRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewaycategory.GateWayCategoryRpcProto.UpdateCategoryResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateCategoryMethod(), responseObserver);
    }

    /**
     */
    public void deleteCategory(com.example.gatewaycategory.GateWayCategoryRpcProto.DeleteCategoryRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewaycategory.GateWayCategoryRpcProto.DeleteCategoryResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteCategoryMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateCategoryMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.gatewaycategory.GateWayCategoryRpcProto.CreateCategoryRequest,
                com.example.gatewaycategory.GateWayCategoryRpcProto.CreateCategoryResponse>(
                  this, METHODID_CREATE_CATEGORY)))
          .addMethod(
            getGetCategoryMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.gatewaycategory.GateWayCategoryRpcProto.GetCategoryRequest,
                com.example.gatewaycategory.GateWayCategoryRpcProto.GetCategoryResponse>(
                  this, METHODID_GET_CATEGORY)))
          .addMethod(
            getGetAllCategoriesMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.gatewaycategory.GateWayCategoryRpcProto.GetAllCategoriesRequest,
                com.example.gatewaycategory.GateWayCategoryRpcProto.GetAllCategoriesResponse>(
                  this, METHODID_GET_ALL_CATEGORIES)))
          .addMethod(
            getUpdateCategoryMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.gatewaycategory.GateWayCategoryRpcProto.UpdateCategoryRequest,
                com.example.gatewaycategory.GateWayCategoryRpcProto.UpdateCategoryResponse>(
                  this, METHODID_UPDATE_CATEGORY)))
          .addMethod(
            getDeleteCategoryMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.gatewaycategory.GateWayCategoryRpcProto.DeleteCategoryRequest,
                com.example.gatewaycategory.GateWayCategoryRpcProto.DeleteCategoryResponse>(
                  this, METHODID_DELETE_CATEGORY)))
          .build();
    }
  }

  /**
   * <pre>
   * Service cho Category
   * </pre>
   */
  public static final class CategoryServiceStub extends io.grpc.stub.AbstractStub<CategoryServiceStub> {
    private CategoryServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CategoryServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CategoryServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CategoryServiceStub(channel, callOptions);
    }

    /**
     */
    public void createCategory(com.example.gatewaycategory.GateWayCategoryRpcProto.CreateCategoryRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewaycategory.GateWayCategoryRpcProto.CreateCategoryResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateCategoryMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getCategory(com.example.gatewaycategory.GateWayCategoryRpcProto.GetCategoryRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewaycategory.GateWayCategoryRpcProto.GetCategoryResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetCategoryMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllCategories(com.example.gatewaycategory.GateWayCategoryRpcProto.GetAllCategoriesRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewaycategory.GateWayCategoryRpcProto.GetAllCategoriesResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAllCategoriesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateCategory(com.example.gatewaycategory.GateWayCategoryRpcProto.UpdateCategoryRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewaycategory.GateWayCategoryRpcProto.UpdateCategoryResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateCategoryMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteCategory(com.example.gatewaycategory.GateWayCategoryRpcProto.DeleteCategoryRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewaycategory.GateWayCategoryRpcProto.DeleteCategoryResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteCategoryMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Service cho Category
   * </pre>
   */
  public static final class CategoryServiceBlockingStub extends io.grpc.stub.AbstractStub<CategoryServiceBlockingStub> {
    private CategoryServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CategoryServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CategoryServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CategoryServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.gatewaycategory.GateWayCategoryRpcProto.CreateCategoryResponse createCategory(com.example.gatewaycategory.GateWayCategoryRpcProto.CreateCategoryRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateCategoryMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.gatewaycategory.GateWayCategoryRpcProto.GetCategoryResponse getCategory(com.example.gatewaycategory.GateWayCategoryRpcProto.GetCategoryRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetCategoryMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.gatewaycategory.GateWayCategoryRpcProto.GetAllCategoriesResponse getAllCategories(com.example.gatewaycategory.GateWayCategoryRpcProto.GetAllCategoriesRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetAllCategoriesMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.gatewaycategory.GateWayCategoryRpcProto.UpdateCategoryResponse updateCategory(com.example.gatewaycategory.GateWayCategoryRpcProto.UpdateCategoryRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateCategoryMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.gatewaycategory.GateWayCategoryRpcProto.DeleteCategoryResponse deleteCategory(com.example.gatewaycategory.GateWayCategoryRpcProto.DeleteCategoryRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteCategoryMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Service cho Category
   * </pre>
   */
  public static final class CategoryServiceFutureStub extends io.grpc.stub.AbstractStub<CategoryServiceFutureStub> {
    private CategoryServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CategoryServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CategoryServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CategoryServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.gatewaycategory.GateWayCategoryRpcProto.CreateCategoryResponse> createCategory(
        com.example.gatewaycategory.GateWayCategoryRpcProto.CreateCategoryRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateCategoryMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.gatewaycategory.GateWayCategoryRpcProto.GetCategoryResponse> getCategory(
        com.example.gatewaycategory.GateWayCategoryRpcProto.GetCategoryRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetCategoryMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.gatewaycategory.GateWayCategoryRpcProto.GetAllCategoriesResponse> getAllCategories(
        com.example.gatewaycategory.GateWayCategoryRpcProto.GetAllCategoriesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAllCategoriesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.gatewaycategory.GateWayCategoryRpcProto.UpdateCategoryResponse> updateCategory(
        com.example.gatewaycategory.GateWayCategoryRpcProto.UpdateCategoryRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateCategoryMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.gatewaycategory.GateWayCategoryRpcProto.DeleteCategoryResponse> deleteCategory(
        com.example.gatewaycategory.GateWayCategoryRpcProto.DeleteCategoryRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteCategoryMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_CATEGORY = 0;
  private static final int METHODID_GET_CATEGORY = 1;
  private static final int METHODID_GET_ALL_CATEGORIES = 2;
  private static final int METHODID_UPDATE_CATEGORY = 3;
  private static final int METHODID_DELETE_CATEGORY = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CategoryServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CategoryServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_CATEGORY:
          serviceImpl.createCategory((com.example.gatewaycategory.GateWayCategoryRpcProto.CreateCategoryRequest) request,
              (io.grpc.stub.StreamObserver<com.example.gatewaycategory.GateWayCategoryRpcProto.CreateCategoryResponse>) responseObserver);
          break;
        case METHODID_GET_CATEGORY:
          serviceImpl.getCategory((com.example.gatewaycategory.GateWayCategoryRpcProto.GetCategoryRequest) request,
              (io.grpc.stub.StreamObserver<com.example.gatewaycategory.GateWayCategoryRpcProto.GetCategoryResponse>) responseObserver);
          break;
        case METHODID_GET_ALL_CATEGORIES:
          serviceImpl.getAllCategories((com.example.gatewaycategory.GateWayCategoryRpcProto.GetAllCategoriesRequest) request,
              (io.grpc.stub.StreamObserver<com.example.gatewaycategory.GateWayCategoryRpcProto.GetAllCategoriesResponse>) responseObserver);
          break;
        case METHODID_UPDATE_CATEGORY:
          serviceImpl.updateCategory((com.example.gatewaycategory.GateWayCategoryRpcProto.UpdateCategoryRequest) request,
              (io.grpc.stub.StreamObserver<com.example.gatewaycategory.GateWayCategoryRpcProto.UpdateCategoryResponse>) responseObserver);
          break;
        case METHODID_DELETE_CATEGORY:
          serviceImpl.deleteCategory((com.example.gatewaycategory.GateWayCategoryRpcProto.DeleteCategoryRequest) request,
              (io.grpc.stub.StreamObserver<com.example.gatewaycategory.GateWayCategoryRpcProto.DeleteCategoryResponse>) responseObserver);
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

  private static abstract class CategoryServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CategoryServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.gatewaycategory.GateWayCategoryRpcProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CategoryService");
    }
  }

  private static final class CategoryServiceFileDescriptorSupplier
      extends CategoryServiceBaseDescriptorSupplier {
    CategoryServiceFileDescriptorSupplier() {}
  }

  private static final class CategoryServiceMethodDescriptorSupplier
      extends CategoryServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CategoryServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (CategoryServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CategoryServiceFileDescriptorSupplier())
              .addMethod(getCreateCategoryMethod())
              .addMethod(getGetCategoryMethod())
              .addMethod(getGetAllCategoriesMethod())
              .addMethod(getUpdateCategoryMethod())
              .addMethod(getDeleteCategoryMethod())
              .build();
        }
      }
    }
    return result;
  }
}
