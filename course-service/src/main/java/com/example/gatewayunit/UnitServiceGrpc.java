package com.example.gatewayunit;

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
    comments = "Source: course/unit/GateWay_Unit_Rpc.proto")
public final class UnitServiceGrpc {

  private UnitServiceGrpc() {}

  public static final String SERVICE_NAME = "unit.UnitService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateUnitMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.example.gatewayunit.GateWayUnitRpcProto.CreateUnitRequest,
      com.example.gatewayunit.GateWayUnitRpcProto.CreateUnitResponse> METHOD_CREATE_UNIT = getCreateUnitMethod();

  private static volatile io.grpc.MethodDescriptor<com.example.gatewayunit.GateWayUnitRpcProto.CreateUnitRequest,
      com.example.gatewayunit.GateWayUnitRpcProto.CreateUnitResponse> getCreateUnitMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.example.gatewayunit.GateWayUnitRpcProto.CreateUnitRequest,
      com.example.gatewayunit.GateWayUnitRpcProto.CreateUnitResponse> getCreateUnitMethod() {
    io.grpc.MethodDescriptor<com.example.gatewayunit.GateWayUnitRpcProto.CreateUnitRequest, com.example.gatewayunit.GateWayUnitRpcProto.CreateUnitResponse> getCreateUnitMethod;
    if ((getCreateUnitMethod = UnitServiceGrpc.getCreateUnitMethod) == null) {
      synchronized (UnitServiceGrpc.class) {
        if ((getCreateUnitMethod = UnitServiceGrpc.getCreateUnitMethod) == null) {
          UnitServiceGrpc.getCreateUnitMethod = getCreateUnitMethod = 
              io.grpc.MethodDescriptor.<com.example.gatewayunit.GateWayUnitRpcProto.CreateUnitRequest, com.example.gatewayunit.GateWayUnitRpcProto.CreateUnitResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "unit.UnitService", "CreateUnit"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewayunit.GateWayUnitRpcProto.CreateUnitRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewayunit.GateWayUnitRpcProto.CreateUnitResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new UnitServiceMethodDescriptorSupplier("CreateUnit"))
                  .build();
          }
        }
     }
     return getCreateUnitMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetUnitsByCourseMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.example.gatewayunit.GateWayUnitRpcProto.GetUnitsByCourseRequest,
      com.example.gatewayunit.GateWayUnitRpcProto.GetUnitsByCourseResponse> METHOD_GET_UNITS_BY_COURSE = getGetUnitsByCourseMethod();

  private static volatile io.grpc.MethodDescriptor<com.example.gatewayunit.GateWayUnitRpcProto.GetUnitsByCourseRequest,
      com.example.gatewayunit.GateWayUnitRpcProto.GetUnitsByCourseResponse> getGetUnitsByCourseMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.example.gatewayunit.GateWayUnitRpcProto.GetUnitsByCourseRequest,
      com.example.gatewayunit.GateWayUnitRpcProto.GetUnitsByCourseResponse> getGetUnitsByCourseMethod() {
    io.grpc.MethodDescriptor<com.example.gatewayunit.GateWayUnitRpcProto.GetUnitsByCourseRequest, com.example.gatewayunit.GateWayUnitRpcProto.GetUnitsByCourseResponse> getGetUnitsByCourseMethod;
    if ((getGetUnitsByCourseMethod = UnitServiceGrpc.getGetUnitsByCourseMethod) == null) {
      synchronized (UnitServiceGrpc.class) {
        if ((getGetUnitsByCourseMethod = UnitServiceGrpc.getGetUnitsByCourseMethod) == null) {
          UnitServiceGrpc.getGetUnitsByCourseMethod = getGetUnitsByCourseMethod = 
              io.grpc.MethodDescriptor.<com.example.gatewayunit.GateWayUnitRpcProto.GetUnitsByCourseRequest, com.example.gatewayunit.GateWayUnitRpcProto.GetUnitsByCourseResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "unit.UnitService", "GetUnitsByCourse"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewayunit.GateWayUnitRpcProto.GetUnitsByCourseRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewayunit.GateWayUnitRpcProto.GetUnitsByCourseResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new UnitServiceMethodDescriptorSupplier("GetUnitsByCourse"))
                  .build();
          }
        }
     }
     return getGetUnitsByCourseMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateUnitMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.example.gatewayunit.GateWayUnitRpcProto.UpdateUnitRequest,
      com.example.gatewayunit.GateWayUnitRpcProto.UpdateUnitResponse> METHOD_UPDATE_UNIT = getUpdateUnitMethod();

  private static volatile io.grpc.MethodDescriptor<com.example.gatewayunit.GateWayUnitRpcProto.UpdateUnitRequest,
      com.example.gatewayunit.GateWayUnitRpcProto.UpdateUnitResponse> getUpdateUnitMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.example.gatewayunit.GateWayUnitRpcProto.UpdateUnitRequest,
      com.example.gatewayunit.GateWayUnitRpcProto.UpdateUnitResponse> getUpdateUnitMethod() {
    io.grpc.MethodDescriptor<com.example.gatewayunit.GateWayUnitRpcProto.UpdateUnitRequest, com.example.gatewayunit.GateWayUnitRpcProto.UpdateUnitResponse> getUpdateUnitMethod;
    if ((getUpdateUnitMethod = UnitServiceGrpc.getUpdateUnitMethod) == null) {
      synchronized (UnitServiceGrpc.class) {
        if ((getUpdateUnitMethod = UnitServiceGrpc.getUpdateUnitMethod) == null) {
          UnitServiceGrpc.getUpdateUnitMethod = getUpdateUnitMethod = 
              io.grpc.MethodDescriptor.<com.example.gatewayunit.GateWayUnitRpcProto.UpdateUnitRequest, com.example.gatewayunit.GateWayUnitRpcProto.UpdateUnitResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "unit.UnitService", "UpdateUnit"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewayunit.GateWayUnitRpcProto.UpdateUnitRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewayunit.GateWayUnitRpcProto.UpdateUnitResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new UnitServiceMethodDescriptorSupplier("UpdateUnit"))
                  .build();
          }
        }
     }
     return getUpdateUnitMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteUnitMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.example.gatewayunit.GateWayUnitRpcProto.DeleteUnitRequest,
      com.example.gatewayunit.GateWayUnitRpcProto.DeleteUnitResponse> METHOD_DELETE_UNIT = getDeleteUnitMethod();

  private static volatile io.grpc.MethodDescriptor<com.example.gatewayunit.GateWayUnitRpcProto.DeleteUnitRequest,
      com.example.gatewayunit.GateWayUnitRpcProto.DeleteUnitResponse> getDeleteUnitMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.example.gatewayunit.GateWayUnitRpcProto.DeleteUnitRequest,
      com.example.gatewayunit.GateWayUnitRpcProto.DeleteUnitResponse> getDeleteUnitMethod() {
    io.grpc.MethodDescriptor<com.example.gatewayunit.GateWayUnitRpcProto.DeleteUnitRequest, com.example.gatewayunit.GateWayUnitRpcProto.DeleteUnitResponse> getDeleteUnitMethod;
    if ((getDeleteUnitMethod = UnitServiceGrpc.getDeleteUnitMethod) == null) {
      synchronized (UnitServiceGrpc.class) {
        if ((getDeleteUnitMethod = UnitServiceGrpc.getDeleteUnitMethod) == null) {
          UnitServiceGrpc.getDeleteUnitMethod = getDeleteUnitMethod = 
              io.grpc.MethodDescriptor.<com.example.gatewayunit.GateWayUnitRpcProto.DeleteUnitRequest, com.example.gatewayunit.GateWayUnitRpcProto.DeleteUnitResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "unit.UnitService", "DeleteUnit"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewayunit.GateWayUnitRpcProto.DeleteUnitRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewayunit.GateWayUnitRpcProto.DeleteUnitResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new UnitServiceMethodDescriptorSupplier("DeleteUnit"))
                  .build();
          }
        }
     }
     return getDeleteUnitMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UnitServiceStub newStub(io.grpc.Channel channel) {
    return new UnitServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UnitServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new UnitServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static UnitServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new UnitServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class UnitServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void createUnit(com.example.gatewayunit.GateWayUnitRpcProto.CreateUnitRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewayunit.GateWayUnitRpcProto.CreateUnitResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateUnitMethod(), responseObserver);
    }

    /**
     */
    public void getUnitsByCourse(com.example.gatewayunit.GateWayUnitRpcProto.GetUnitsByCourseRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewayunit.GateWayUnitRpcProto.GetUnitsByCourseResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetUnitsByCourseMethod(), responseObserver);
    }

    /**
     */
    public void updateUnit(com.example.gatewayunit.GateWayUnitRpcProto.UpdateUnitRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewayunit.GateWayUnitRpcProto.UpdateUnitResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateUnitMethod(), responseObserver);
    }

    /**
     */
    public void deleteUnit(com.example.gatewayunit.GateWayUnitRpcProto.DeleteUnitRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewayunit.GateWayUnitRpcProto.DeleteUnitResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteUnitMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateUnitMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.gatewayunit.GateWayUnitRpcProto.CreateUnitRequest,
                com.example.gatewayunit.GateWayUnitRpcProto.CreateUnitResponse>(
                  this, METHODID_CREATE_UNIT)))
          .addMethod(
            getGetUnitsByCourseMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.gatewayunit.GateWayUnitRpcProto.GetUnitsByCourseRequest,
                com.example.gatewayunit.GateWayUnitRpcProto.GetUnitsByCourseResponse>(
                  this, METHODID_GET_UNITS_BY_COURSE)))
          .addMethod(
            getUpdateUnitMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.gatewayunit.GateWayUnitRpcProto.UpdateUnitRequest,
                com.example.gatewayunit.GateWayUnitRpcProto.UpdateUnitResponse>(
                  this, METHODID_UPDATE_UNIT)))
          .addMethod(
            getDeleteUnitMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.gatewayunit.GateWayUnitRpcProto.DeleteUnitRequest,
                com.example.gatewayunit.GateWayUnitRpcProto.DeleteUnitResponse>(
                  this, METHODID_DELETE_UNIT)))
          .build();
    }
  }

  /**
   */
  public static final class UnitServiceStub extends io.grpc.stub.AbstractStub<UnitServiceStub> {
    private UnitServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UnitServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UnitServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UnitServiceStub(channel, callOptions);
    }

    /**
     */
    public void createUnit(com.example.gatewayunit.GateWayUnitRpcProto.CreateUnitRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewayunit.GateWayUnitRpcProto.CreateUnitResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateUnitMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getUnitsByCourse(com.example.gatewayunit.GateWayUnitRpcProto.GetUnitsByCourseRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewayunit.GateWayUnitRpcProto.GetUnitsByCourseResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetUnitsByCourseMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateUnit(com.example.gatewayunit.GateWayUnitRpcProto.UpdateUnitRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewayunit.GateWayUnitRpcProto.UpdateUnitResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateUnitMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteUnit(com.example.gatewayunit.GateWayUnitRpcProto.DeleteUnitRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewayunit.GateWayUnitRpcProto.DeleteUnitResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteUnitMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class UnitServiceBlockingStub extends io.grpc.stub.AbstractStub<UnitServiceBlockingStub> {
    private UnitServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UnitServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UnitServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UnitServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.gatewayunit.GateWayUnitRpcProto.CreateUnitResponse createUnit(com.example.gatewayunit.GateWayUnitRpcProto.CreateUnitRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateUnitMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.gatewayunit.GateWayUnitRpcProto.GetUnitsByCourseResponse getUnitsByCourse(com.example.gatewayunit.GateWayUnitRpcProto.GetUnitsByCourseRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetUnitsByCourseMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.gatewayunit.GateWayUnitRpcProto.UpdateUnitResponse updateUnit(com.example.gatewayunit.GateWayUnitRpcProto.UpdateUnitRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateUnitMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.gatewayunit.GateWayUnitRpcProto.DeleteUnitResponse deleteUnit(com.example.gatewayunit.GateWayUnitRpcProto.DeleteUnitRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteUnitMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class UnitServiceFutureStub extends io.grpc.stub.AbstractStub<UnitServiceFutureStub> {
    private UnitServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UnitServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UnitServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UnitServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.gatewayunit.GateWayUnitRpcProto.CreateUnitResponse> createUnit(
        com.example.gatewayunit.GateWayUnitRpcProto.CreateUnitRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateUnitMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.gatewayunit.GateWayUnitRpcProto.GetUnitsByCourseResponse> getUnitsByCourse(
        com.example.gatewayunit.GateWayUnitRpcProto.GetUnitsByCourseRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetUnitsByCourseMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.gatewayunit.GateWayUnitRpcProto.UpdateUnitResponse> updateUnit(
        com.example.gatewayunit.GateWayUnitRpcProto.UpdateUnitRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateUnitMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.gatewayunit.GateWayUnitRpcProto.DeleteUnitResponse> deleteUnit(
        com.example.gatewayunit.GateWayUnitRpcProto.DeleteUnitRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteUnitMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_UNIT = 0;
  private static final int METHODID_GET_UNITS_BY_COURSE = 1;
  private static final int METHODID_UPDATE_UNIT = 2;
  private static final int METHODID_DELETE_UNIT = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final UnitServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(UnitServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_UNIT:
          serviceImpl.createUnit((com.example.gatewayunit.GateWayUnitRpcProto.CreateUnitRequest) request,
              (io.grpc.stub.StreamObserver<com.example.gatewayunit.GateWayUnitRpcProto.CreateUnitResponse>) responseObserver);
          break;
        case METHODID_GET_UNITS_BY_COURSE:
          serviceImpl.getUnitsByCourse((com.example.gatewayunit.GateWayUnitRpcProto.GetUnitsByCourseRequest) request,
              (io.grpc.stub.StreamObserver<com.example.gatewayunit.GateWayUnitRpcProto.GetUnitsByCourseResponse>) responseObserver);
          break;
        case METHODID_UPDATE_UNIT:
          serviceImpl.updateUnit((com.example.gatewayunit.GateWayUnitRpcProto.UpdateUnitRequest) request,
              (io.grpc.stub.StreamObserver<com.example.gatewayunit.GateWayUnitRpcProto.UpdateUnitResponse>) responseObserver);
          break;
        case METHODID_DELETE_UNIT:
          serviceImpl.deleteUnit((com.example.gatewayunit.GateWayUnitRpcProto.DeleteUnitRequest) request,
              (io.grpc.stub.StreamObserver<com.example.gatewayunit.GateWayUnitRpcProto.DeleteUnitResponse>) responseObserver);
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

  private static abstract class UnitServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    UnitServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.gatewayunit.GateWayUnitRpcProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("UnitService");
    }
  }

  private static final class UnitServiceFileDescriptorSupplier
      extends UnitServiceBaseDescriptorSupplier {
    UnitServiceFileDescriptorSupplier() {}
  }

  private static final class UnitServiceMethodDescriptorSupplier
      extends UnitServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    UnitServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (UnitServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new UnitServiceFileDescriptorSupplier())
              .addMethod(getCreateUnitMethod())
              .addMethod(getGetUnitsByCourseMethod())
              .addMethod(getUpdateUnitMethod())
              .addMethod(getDeleteUnitMethod())
              .build();
        }
      }
    }
    return result;
  }
}
