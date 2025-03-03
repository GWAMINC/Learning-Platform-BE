package com.example.gatewaycoupon;

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
    comments = "Source: course/coupon/GateWay_Coupon_Rpc.proto")
public final class CouponServiceGrpc {

  private CouponServiceGrpc() {}

  public static final String SERVICE_NAME = "coupon.CouponService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateCouponMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.example.gatewaycoupon.GateWayCouponRpcProto.CreateCouponRequest,
      com.example.gatewaycoupon.GateWayCouponRpcProto.CreateCouponResponse> METHOD_CREATE_COUPON = getCreateCouponMethod();

  private static volatile io.grpc.MethodDescriptor<com.example.gatewaycoupon.GateWayCouponRpcProto.CreateCouponRequest,
      com.example.gatewaycoupon.GateWayCouponRpcProto.CreateCouponResponse> getCreateCouponMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.example.gatewaycoupon.GateWayCouponRpcProto.CreateCouponRequest,
      com.example.gatewaycoupon.GateWayCouponRpcProto.CreateCouponResponse> getCreateCouponMethod() {
    io.grpc.MethodDescriptor<com.example.gatewaycoupon.GateWayCouponRpcProto.CreateCouponRequest, com.example.gatewaycoupon.GateWayCouponRpcProto.CreateCouponResponse> getCreateCouponMethod;
    if ((getCreateCouponMethod = CouponServiceGrpc.getCreateCouponMethod) == null) {
      synchronized (CouponServiceGrpc.class) {
        if ((getCreateCouponMethod = CouponServiceGrpc.getCreateCouponMethod) == null) {
          CouponServiceGrpc.getCreateCouponMethod = getCreateCouponMethod = 
              io.grpc.MethodDescriptor.<com.example.gatewaycoupon.GateWayCouponRpcProto.CreateCouponRequest, com.example.gatewaycoupon.GateWayCouponRpcProto.CreateCouponResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "coupon.CouponService", "CreateCoupon"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewaycoupon.GateWayCouponRpcProto.CreateCouponRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewaycoupon.GateWayCouponRpcProto.CreateCouponResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CouponServiceMethodDescriptorSupplier("CreateCoupon"))
                  .build();
          }
        }
     }
     return getCreateCouponMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetCouponMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.example.gatewaycoupon.GateWayCouponRpcProto.GetCouponRequest,
      com.example.gatewaycoupon.GateWayCouponRpcProto.GetCouponResponse> METHOD_GET_COUPON = getGetCouponMethod();

  private static volatile io.grpc.MethodDescriptor<com.example.gatewaycoupon.GateWayCouponRpcProto.GetCouponRequest,
      com.example.gatewaycoupon.GateWayCouponRpcProto.GetCouponResponse> getGetCouponMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.example.gatewaycoupon.GateWayCouponRpcProto.GetCouponRequest,
      com.example.gatewaycoupon.GateWayCouponRpcProto.GetCouponResponse> getGetCouponMethod() {
    io.grpc.MethodDescriptor<com.example.gatewaycoupon.GateWayCouponRpcProto.GetCouponRequest, com.example.gatewaycoupon.GateWayCouponRpcProto.GetCouponResponse> getGetCouponMethod;
    if ((getGetCouponMethod = CouponServiceGrpc.getGetCouponMethod) == null) {
      synchronized (CouponServiceGrpc.class) {
        if ((getGetCouponMethod = CouponServiceGrpc.getGetCouponMethod) == null) {
          CouponServiceGrpc.getGetCouponMethod = getGetCouponMethod = 
              io.grpc.MethodDescriptor.<com.example.gatewaycoupon.GateWayCouponRpcProto.GetCouponRequest, com.example.gatewaycoupon.GateWayCouponRpcProto.GetCouponResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "coupon.CouponService", "GetCoupon"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewaycoupon.GateWayCouponRpcProto.GetCouponRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewaycoupon.GateWayCouponRpcProto.GetCouponResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CouponServiceMethodDescriptorSupplier("GetCoupon"))
                  .build();
          }
        }
     }
     return getGetCouponMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetCouponByCodeMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.example.gatewaycoupon.GateWayCouponRpcProto.GetCouponByCodeRequest,
      com.example.gatewaycoupon.GateWayCouponRpcProto.GetCouponByCodeResponse> METHOD_GET_COUPON_BY_CODE = getGetCouponByCodeMethod();

  private static volatile io.grpc.MethodDescriptor<com.example.gatewaycoupon.GateWayCouponRpcProto.GetCouponByCodeRequest,
      com.example.gatewaycoupon.GateWayCouponRpcProto.GetCouponByCodeResponse> getGetCouponByCodeMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.example.gatewaycoupon.GateWayCouponRpcProto.GetCouponByCodeRequest,
      com.example.gatewaycoupon.GateWayCouponRpcProto.GetCouponByCodeResponse> getGetCouponByCodeMethod() {
    io.grpc.MethodDescriptor<com.example.gatewaycoupon.GateWayCouponRpcProto.GetCouponByCodeRequest, com.example.gatewaycoupon.GateWayCouponRpcProto.GetCouponByCodeResponse> getGetCouponByCodeMethod;
    if ((getGetCouponByCodeMethod = CouponServiceGrpc.getGetCouponByCodeMethod) == null) {
      synchronized (CouponServiceGrpc.class) {
        if ((getGetCouponByCodeMethod = CouponServiceGrpc.getGetCouponByCodeMethod) == null) {
          CouponServiceGrpc.getGetCouponByCodeMethod = getGetCouponByCodeMethod = 
              io.grpc.MethodDescriptor.<com.example.gatewaycoupon.GateWayCouponRpcProto.GetCouponByCodeRequest, com.example.gatewaycoupon.GateWayCouponRpcProto.GetCouponByCodeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "coupon.CouponService", "GetCouponByCode"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewaycoupon.GateWayCouponRpcProto.GetCouponByCodeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewaycoupon.GateWayCouponRpcProto.GetCouponByCodeResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CouponServiceMethodDescriptorSupplier("GetCouponByCode"))
                  .build();
          }
        }
     }
     return getGetCouponByCodeMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetAllCouponsMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.example.gatewaycoupon.GateWayCouponRpcProto.GetAllCouponsRequest,
      com.example.gatewaycoupon.GateWayCouponRpcProto.GetAllCouponsResponse> METHOD_GET_ALL_COUPONS = getGetAllCouponsMethod();

  private static volatile io.grpc.MethodDescriptor<com.example.gatewaycoupon.GateWayCouponRpcProto.GetAllCouponsRequest,
      com.example.gatewaycoupon.GateWayCouponRpcProto.GetAllCouponsResponse> getGetAllCouponsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.example.gatewaycoupon.GateWayCouponRpcProto.GetAllCouponsRequest,
      com.example.gatewaycoupon.GateWayCouponRpcProto.GetAllCouponsResponse> getGetAllCouponsMethod() {
    io.grpc.MethodDescriptor<com.example.gatewaycoupon.GateWayCouponRpcProto.GetAllCouponsRequest, com.example.gatewaycoupon.GateWayCouponRpcProto.GetAllCouponsResponse> getGetAllCouponsMethod;
    if ((getGetAllCouponsMethod = CouponServiceGrpc.getGetAllCouponsMethod) == null) {
      synchronized (CouponServiceGrpc.class) {
        if ((getGetAllCouponsMethod = CouponServiceGrpc.getGetAllCouponsMethod) == null) {
          CouponServiceGrpc.getGetAllCouponsMethod = getGetAllCouponsMethod = 
              io.grpc.MethodDescriptor.<com.example.gatewaycoupon.GateWayCouponRpcProto.GetAllCouponsRequest, com.example.gatewaycoupon.GateWayCouponRpcProto.GetAllCouponsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "coupon.CouponService", "GetAllCoupons"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewaycoupon.GateWayCouponRpcProto.GetAllCouponsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewaycoupon.GateWayCouponRpcProto.GetAllCouponsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CouponServiceMethodDescriptorSupplier("GetAllCoupons"))
                  .build();
          }
        }
     }
     return getGetAllCouponsMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateCouponMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.example.gatewaycoupon.GateWayCouponRpcProto.UpdateCouponRequest,
      com.example.gatewaycoupon.GateWayCouponRpcProto.UpdateCouponResponse> METHOD_UPDATE_COUPON = getUpdateCouponMethod();

  private static volatile io.grpc.MethodDescriptor<com.example.gatewaycoupon.GateWayCouponRpcProto.UpdateCouponRequest,
      com.example.gatewaycoupon.GateWayCouponRpcProto.UpdateCouponResponse> getUpdateCouponMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.example.gatewaycoupon.GateWayCouponRpcProto.UpdateCouponRequest,
      com.example.gatewaycoupon.GateWayCouponRpcProto.UpdateCouponResponse> getUpdateCouponMethod() {
    io.grpc.MethodDescriptor<com.example.gatewaycoupon.GateWayCouponRpcProto.UpdateCouponRequest, com.example.gatewaycoupon.GateWayCouponRpcProto.UpdateCouponResponse> getUpdateCouponMethod;
    if ((getUpdateCouponMethod = CouponServiceGrpc.getUpdateCouponMethod) == null) {
      synchronized (CouponServiceGrpc.class) {
        if ((getUpdateCouponMethod = CouponServiceGrpc.getUpdateCouponMethod) == null) {
          CouponServiceGrpc.getUpdateCouponMethod = getUpdateCouponMethod = 
              io.grpc.MethodDescriptor.<com.example.gatewaycoupon.GateWayCouponRpcProto.UpdateCouponRequest, com.example.gatewaycoupon.GateWayCouponRpcProto.UpdateCouponResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "coupon.CouponService", "UpdateCoupon"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewaycoupon.GateWayCouponRpcProto.UpdateCouponRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewaycoupon.GateWayCouponRpcProto.UpdateCouponResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CouponServiceMethodDescriptorSupplier("UpdateCoupon"))
                  .build();
          }
        }
     }
     return getUpdateCouponMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteCouponMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.example.gatewaycoupon.GateWayCouponRpcProto.DeleteCouponRequest,
      com.example.gatewaycoupon.GateWayCouponRpcProto.DeleteCouponResponse> METHOD_DELETE_COUPON = getDeleteCouponMethod();

  private static volatile io.grpc.MethodDescriptor<com.example.gatewaycoupon.GateWayCouponRpcProto.DeleteCouponRequest,
      com.example.gatewaycoupon.GateWayCouponRpcProto.DeleteCouponResponse> getDeleteCouponMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.example.gatewaycoupon.GateWayCouponRpcProto.DeleteCouponRequest,
      com.example.gatewaycoupon.GateWayCouponRpcProto.DeleteCouponResponse> getDeleteCouponMethod() {
    io.grpc.MethodDescriptor<com.example.gatewaycoupon.GateWayCouponRpcProto.DeleteCouponRequest, com.example.gatewaycoupon.GateWayCouponRpcProto.DeleteCouponResponse> getDeleteCouponMethod;
    if ((getDeleteCouponMethod = CouponServiceGrpc.getDeleteCouponMethod) == null) {
      synchronized (CouponServiceGrpc.class) {
        if ((getDeleteCouponMethod = CouponServiceGrpc.getDeleteCouponMethod) == null) {
          CouponServiceGrpc.getDeleteCouponMethod = getDeleteCouponMethod = 
              io.grpc.MethodDescriptor.<com.example.gatewaycoupon.GateWayCouponRpcProto.DeleteCouponRequest, com.example.gatewaycoupon.GateWayCouponRpcProto.DeleteCouponResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "coupon.CouponService", "DeleteCoupon"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewaycoupon.GateWayCouponRpcProto.DeleteCouponRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewaycoupon.GateWayCouponRpcProto.DeleteCouponResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CouponServiceMethodDescriptorSupplier("DeleteCoupon"))
                  .build();
          }
        }
     }
     return getDeleteCouponMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CouponServiceStub newStub(io.grpc.Channel channel) {
    return new CouponServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CouponServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CouponServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CouponServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CouponServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class CouponServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void createCoupon(com.example.gatewaycoupon.GateWayCouponRpcProto.CreateCouponRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewaycoupon.GateWayCouponRpcProto.CreateCouponResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateCouponMethod(), responseObserver);
    }

    /**
     */
    public void getCoupon(com.example.gatewaycoupon.GateWayCouponRpcProto.GetCouponRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewaycoupon.GateWayCouponRpcProto.GetCouponResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetCouponMethod(), responseObserver);
    }

    /**
     */
    public void getCouponByCode(com.example.gatewaycoupon.GateWayCouponRpcProto.GetCouponByCodeRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewaycoupon.GateWayCouponRpcProto.GetCouponByCodeResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetCouponByCodeMethod(), responseObserver);
    }

    /**
     */
    public void getAllCoupons(com.example.gatewaycoupon.GateWayCouponRpcProto.GetAllCouponsRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewaycoupon.GateWayCouponRpcProto.GetAllCouponsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAllCouponsMethod(), responseObserver);
    }

    /**
     */
    public void updateCoupon(com.example.gatewaycoupon.GateWayCouponRpcProto.UpdateCouponRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewaycoupon.GateWayCouponRpcProto.UpdateCouponResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateCouponMethod(), responseObserver);
    }

    /**
     */
    public void deleteCoupon(com.example.gatewaycoupon.GateWayCouponRpcProto.DeleteCouponRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewaycoupon.GateWayCouponRpcProto.DeleteCouponResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteCouponMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateCouponMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.gatewaycoupon.GateWayCouponRpcProto.CreateCouponRequest,
                com.example.gatewaycoupon.GateWayCouponRpcProto.CreateCouponResponse>(
                  this, METHODID_CREATE_COUPON)))
          .addMethod(
            getGetCouponMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.gatewaycoupon.GateWayCouponRpcProto.GetCouponRequest,
                com.example.gatewaycoupon.GateWayCouponRpcProto.GetCouponResponse>(
                  this, METHODID_GET_COUPON)))
          .addMethod(
            getGetCouponByCodeMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.gatewaycoupon.GateWayCouponRpcProto.GetCouponByCodeRequest,
                com.example.gatewaycoupon.GateWayCouponRpcProto.GetCouponByCodeResponse>(
                  this, METHODID_GET_COUPON_BY_CODE)))
          .addMethod(
            getGetAllCouponsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.gatewaycoupon.GateWayCouponRpcProto.GetAllCouponsRequest,
                com.example.gatewaycoupon.GateWayCouponRpcProto.GetAllCouponsResponse>(
                  this, METHODID_GET_ALL_COUPONS)))
          .addMethod(
            getUpdateCouponMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.gatewaycoupon.GateWayCouponRpcProto.UpdateCouponRequest,
                com.example.gatewaycoupon.GateWayCouponRpcProto.UpdateCouponResponse>(
                  this, METHODID_UPDATE_COUPON)))
          .addMethod(
            getDeleteCouponMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.gatewaycoupon.GateWayCouponRpcProto.DeleteCouponRequest,
                com.example.gatewaycoupon.GateWayCouponRpcProto.DeleteCouponResponse>(
                  this, METHODID_DELETE_COUPON)))
          .build();
    }
  }

  /**
   */
  public static final class CouponServiceStub extends io.grpc.stub.AbstractStub<CouponServiceStub> {
    private CouponServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CouponServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CouponServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CouponServiceStub(channel, callOptions);
    }

    /**
     */
    public void createCoupon(com.example.gatewaycoupon.GateWayCouponRpcProto.CreateCouponRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewaycoupon.GateWayCouponRpcProto.CreateCouponResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateCouponMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getCoupon(com.example.gatewaycoupon.GateWayCouponRpcProto.GetCouponRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewaycoupon.GateWayCouponRpcProto.GetCouponResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetCouponMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getCouponByCode(com.example.gatewaycoupon.GateWayCouponRpcProto.GetCouponByCodeRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewaycoupon.GateWayCouponRpcProto.GetCouponByCodeResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetCouponByCodeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllCoupons(com.example.gatewaycoupon.GateWayCouponRpcProto.GetAllCouponsRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewaycoupon.GateWayCouponRpcProto.GetAllCouponsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAllCouponsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateCoupon(com.example.gatewaycoupon.GateWayCouponRpcProto.UpdateCouponRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewaycoupon.GateWayCouponRpcProto.UpdateCouponResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateCouponMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteCoupon(com.example.gatewaycoupon.GateWayCouponRpcProto.DeleteCouponRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewaycoupon.GateWayCouponRpcProto.DeleteCouponResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteCouponMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CouponServiceBlockingStub extends io.grpc.stub.AbstractStub<CouponServiceBlockingStub> {
    private CouponServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CouponServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CouponServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CouponServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.gatewaycoupon.GateWayCouponRpcProto.CreateCouponResponse createCoupon(com.example.gatewaycoupon.GateWayCouponRpcProto.CreateCouponRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateCouponMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.gatewaycoupon.GateWayCouponRpcProto.GetCouponResponse getCoupon(com.example.gatewaycoupon.GateWayCouponRpcProto.GetCouponRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetCouponMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.gatewaycoupon.GateWayCouponRpcProto.GetCouponByCodeResponse getCouponByCode(com.example.gatewaycoupon.GateWayCouponRpcProto.GetCouponByCodeRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetCouponByCodeMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.gatewaycoupon.GateWayCouponRpcProto.GetAllCouponsResponse getAllCoupons(com.example.gatewaycoupon.GateWayCouponRpcProto.GetAllCouponsRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetAllCouponsMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.gatewaycoupon.GateWayCouponRpcProto.UpdateCouponResponse updateCoupon(com.example.gatewaycoupon.GateWayCouponRpcProto.UpdateCouponRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateCouponMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.gatewaycoupon.GateWayCouponRpcProto.DeleteCouponResponse deleteCoupon(com.example.gatewaycoupon.GateWayCouponRpcProto.DeleteCouponRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteCouponMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CouponServiceFutureStub extends io.grpc.stub.AbstractStub<CouponServiceFutureStub> {
    private CouponServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CouponServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CouponServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CouponServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.gatewaycoupon.GateWayCouponRpcProto.CreateCouponResponse> createCoupon(
        com.example.gatewaycoupon.GateWayCouponRpcProto.CreateCouponRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateCouponMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.gatewaycoupon.GateWayCouponRpcProto.GetCouponResponse> getCoupon(
        com.example.gatewaycoupon.GateWayCouponRpcProto.GetCouponRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetCouponMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.gatewaycoupon.GateWayCouponRpcProto.GetCouponByCodeResponse> getCouponByCode(
        com.example.gatewaycoupon.GateWayCouponRpcProto.GetCouponByCodeRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetCouponByCodeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.gatewaycoupon.GateWayCouponRpcProto.GetAllCouponsResponse> getAllCoupons(
        com.example.gatewaycoupon.GateWayCouponRpcProto.GetAllCouponsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAllCouponsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.gatewaycoupon.GateWayCouponRpcProto.UpdateCouponResponse> updateCoupon(
        com.example.gatewaycoupon.GateWayCouponRpcProto.UpdateCouponRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateCouponMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.gatewaycoupon.GateWayCouponRpcProto.DeleteCouponResponse> deleteCoupon(
        com.example.gatewaycoupon.GateWayCouponRpcProto.DeleteCouponRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteCouponMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_COUPON = 0;
  private static final int METHODID_GET_COUPON = 1;
  private static final int METHODID_GET_COUPON_BY_CODE = 2;
  private static final int METHODID_GET_ALL_COUPONS = 3;
  private static final int METHODID_UPDATE_COUPON = 4;
  private static final int METHODID_DELETE_COUPON = 5;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CouponServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CouponServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_COUPON:
          serviceImpl.createCoupon((com.example.gatewaycoupon.GateWayCouponRpcProto.CreateCouponRequest) request,
              (io.grpc.stub.StreamObserver<com.example.gatewaycoupon.GateWayCouponRpcProto.CreateCouponResponse>) responseObserver);
          break;
        case METHODID_GET_COUPON:
          serviceImpl.getCoupon((com.example.gatewaycoupon.GateWayCouponRpcProto.GetCouponRequest) request,
              (io.grpc.stub.StreamObserver<com.example.gatewaycoupon.GateWayCouponRpcProto.GetCouponResponse>) responseObserver);
          break;
        case METHODID_GET_COUPON_BY_CODE:
          serviceImpl.getCouponByCode((com.example.gatewaycoupon.GateWayCouponRpcProto.GetCouponByCodeRequest) request,
              (io.grpc.stub.StreamObserver<com.example.gatewaycoupon.GateWayCouponRpcProto.GetCouponByCodeResponse>) responseObserver);
          break;
        case METHODID_GET_ALL_COUPONS:
          serviceImpl.getAllCoupons((com.example.gatewaycoupon.GateWayCouponRpcProto.GetAllCouponsRequest) request,
              (io.grpc.stub.StreamObserver<com.example.gatewaycoupon.GateWayCouponRpcProto.GetAllCouponsResponse>) responseObserver);
          break;
        case METHODID_UPDATE_COUPON:
          serviceImpl.updateCoupon((com.example.gatewaycoupon.GateWayCouponRpcProto.UpdateCouponRequest) request,
              (io.grpc.stub.StreamObserver<com.example.gatewaycoupon.GateWayCouponRpcProto.UpdateCouponResponse>) responseObserver);
          break;
        case METHODID_DELETE_COUPON:
          serviceImpl.deleteCoupon((com.example.gatewaycoupon.GateWayCouponRpcProto.DeleteCouponRequest) request,
              (io.grpc.stub.StreamObserver<com.example.gatewaycoupon.GateWayCouponRpcProto.DeleteCouponResponse>) responseObserver);
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

  private static abstract class CouponServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CouponServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.gatewaycoupon.GateWayCouponRpcProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CouponService");
    }
  }

  private static final class CouponServiceFileDescriptorSupplier
      extends CouponServiceBaseDescriptorSupplier {
    CouponServiceFileDescriptorSupplier() {}
  }

  private static final class CouponServiceMethodDescriptorSupplier
      extends CouponServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CouponServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (CouponServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CouponServiceFileDescriptorSupplier())
              .addMethod(getCreateCouponMethod())
              .addMethod(getGetCouponMethod())
              .addMethod(getGetCouponByCodeMethod())
              .addMethod(getGetAllCouponsMethod())
              .addMethod(getUpdateCouponMethod())
              .addMethod(getDeleteCouponMethod())
              .build();
        }
      }
    }
    return result;
  }
}
