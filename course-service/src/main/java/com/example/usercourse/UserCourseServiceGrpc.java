package com.example.usercourse;

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
 * Service định nghĩa các RPC
 * </pre>
 */
@jakarta.annotation.Generated(
    value = "by gRPC proto compiler (version 1.9.1)",
    comments = "Source: user_course_rpc.proto")
public final class UserCourseServiceGrpc {

  private UserCourseServiceGrpc() {}

  public static final String SERVICE_NAME = "usercourse.UserCourseService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetCourseInfoMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.example.usercourse.UserCourseRpcProto.GetCourseRequest,
      com.example.usercourse.UserCourseRpcProto.GetCourseResponse> METHOD_GET_COURSE_INFO = getGetCourseInfoMethod();

  private static volatile io.grpc.MethodDescriptor<com.example.usercourse.UserCourseRpcProto.GetCourseRequest,
      com.example.usercourse.UserCourseRpcProto.GetCourseResponse> getGetCourseInfoMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.example.usercourse.UserCourseRpcProto.GetCourseRequest,
      com.example.usercourse.UserCourseRpcProto.GetCourseResponse> getGetCourseInfoMethod() {
    io.grpc.MethodDescriptor<com.example.usercourse.UserCourseRpcProto.GetCourseRequest, com.example.usercourse.UserCourseRpcProto.GetCourseResponse> getGetCourseInfoMethod;
    if ((getGetCourseInfoMethod = UserCourseServiceGrpc.getGetCourseInfoMethod) == null) {
      synchronized (UserCourseServiceGrpc.class) {
        if ((getGetCourseInfoMethod = UserCourseServiceGrpc.getGetCourseInfoMethod) == null) {
          UserCourseServiceGrpc.getGetCourseInfoMethod = getGetCourseInfoMethod = 
              io.grpc.MethodDescriptor.<com.example.usercourse.UserCourseRpcProto.GetCourseRequest, com.example.usercourse.UserCourseRpcProto.GetCourseResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "usercourse.UserCourseService", "GetCourseInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.usercourse.UserCourseRpcProto.GetCourseRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.usercourse.UserCourseRpcProto.GetCourseResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new UserCourseServiceMethodDescriptorSupplier("GetCourseInfo"))
                  .build();
          }
        }
     }
     return getGetCourseInfoMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getRegisterCourseMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.example.usercourse.UserCourseRpcProto.RegisterCourseRequest,
      com.example.usercourse.UserCourseRpcProto.RegisterCourseResponse> METHOD_REGISTER_COURSE = getRegisterCourseMethod();

  private static volatile io.grpc.MethodDescriptor<com.example.usercourse.UserCourseRpcProto.RegisterCourseRequest,
      com.example.usercourse.UserCourseRpcProto.RegisterCourseResponse> getRegisterCourseMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.example.usercourse.UserCourseRpcProto.RegisterCourseRequest,
      com.example.usercourse.UserCourseRpcProto.RegisterCourseResponse> getRegisterCourseMethod() {
    io.grpc.MethodDescriptor<com.example.usercourse.UserCourseRpcProto.RegisterCourseRequest, com.example.usercourse.UserCourseRpcProto.RegisterCourseResponse> getRegisterCourseMethod;
    if ((getRegisterCourseMethod = UserCourseServiceGrpc.getRegisterCourseMethod) == null) {
      synchronized (UserCourseServiceGrpc.class) {
        if ((getRegisterCourseMethod = UserCourseServiceGrpc.getRegisterCourseMethod) == null) {
          UserCourseServiceGrpc.getRegisterCourseMethod = getRegisterCourseMethod = 
              io.grpc.MethodDescriptor.<com.example.usercourse.UserCourseRpcProto.RegisterCourseRequest, com.example.usercourse.UserCourseRpcProto.RegisterCourseResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "usercourse.UserCourseService", "RegisterCourse"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.usercourse.UserCourseRpcProto.RegisterCourseRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.usercourse.UserCourseRpcProto.RegisterCourseResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new UserCourseServiceMethodDescriptorSupplier("RegisterCourse"))
                  .build();
          }
        }
     }
     return getRegisterCourseMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UserCourseServiceStub newStub(io.grpc.Channel channel) {
    return new UserCourseServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UserCourseServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new UserCourseServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static UserCourseServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new UserCourseServiceFutureStub(channel);
  }

  /**
   * <pre>
   * Service định nghĩa các RPC
   * </pre>
   */
  public static abstract class UserCourseServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * User gọi để lấy thông tin khóa học từ Course Service
     * </pre>
     */
    public void getCourseInfo(com.example.usercourse.UserCourseRpcProto.GetCourseRequest request,
        io.grpc.stub.StreamObserver<com.example.usercourse.UserCourseRpcProto.GetCourseResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetCourseInfoMethod(), responseObserver);
    }

    /**
     * <pre>
     * User gọi để đăng ký khóa học
     * </pre>
     */
    public void registerCourse(com.example.usercourse.UserCourseRpcProto.RegisterCourseRequest request,
        io.grpc.stub.StreamObserver<com.example.usercourse.UserCourseRpcProto.RegisterCourseResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getRegisterCourseMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetCourseInfoMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.usercourse.UserCourseRpcProto.GetCourseRequest,
                com.example.usercourse.UserCourseRpcProto.GetCourseResponse>(
                  this, METHODID_GET_COURSE_INFO)))
          .addMethod(
            getRegisterCourseMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.usercourse.UserCourseRpcProto.RegisterCourseRequest,
                com.example.usercourse.UserCourseRpcProto.RegisterCourseResponse>(
                  this, METHODID_REGISTER_COURSE)))
          .build();
    }
  }

  /**
   * <pre>
   * Service định nghĩa các RPC
   * </pre>
   */
  public static final class UserCourseServiceStub extends io.grpc.stub.AbstractStub<UserCourseServiceStub> {
    private UserCourseServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserCourseServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserCourseServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserCourseServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * User gọi để lấy thông tin khóa học từ Course Service
     * </pre>
     */
    public void getCourseInfo(com.example.usercourse.UserCourseRpcProto.GetCourseRequest request,
        io.grpc.stub.StreamObserver<com.example.usercourse.UserCourseRpcProto.GetCourseResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetCourseInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * User gọi để đăng ký khóa học
     * </pre>
     */
    public void registerCourse(com.example.usercourse.UserCourseRpcProto.RegisterCourseRequest request,
        io.grpc.stub.StreamObserver<com.example.usercourse.UserCourseRpcProto.RegisterCourseResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRegisterCourseMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Service định nghĩa các RPC
   * </pre>
   */
  public static final class UserCourseServiceBlockingStub extends io.grpc.stub.AbstractStub<UserCourseServiceBlockingStub> {
    private UserCourseServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserCourseServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserCourseServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserCourseServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * User gọi để lấy thông tin khóa học từ Course Service
     * </pre>
     */
    public com.example.usercourse.UserCourseRpcProto.GetCourseResponse getCourseInfo(com.example.usercourse.UserCourseRpcProto.GetCourseRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetCourseInfoMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * User gọi để đăng ký khóa học
     * </pre>
     */
    public com.example.usercourse.UserCourseRpcProto.RegisterCourseResponse registerCourse(com.example.usercourse.UserCourseRpcProto.RegisterCourseRequest request) {
      return blockingUnaryCall(
          getChannel(), getRegisterCourseMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Service định nghĩa các RPC
   * </pre>
   */
  public static final class UserCourseServiceFutureStub extends io.grpc.stub.AbstractStub<UserCourseServiceFutureStub> {
    private UserCourseServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserCourseServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserCourseServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserCourseServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * User gọi để lấy thông tin khóa học từ Course Service
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.usercourse.UserCourseRpcProto.GetCourseResponse> getCourseInfo(
        com.example.usercourse.UserCourseRpcProto.GetCourseRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetCourseInfoMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * User gọi để đăng ký khóa học
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.usercourse.UserCourseRpcProto.RegisterCourseResponse> registerCourse(
        com.example.usercourse.UserCourseRpcProto.RegisterCourseRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRegisterCourseMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_COURSE_INFO = 0;
  private static final int METHODID_REGISTER_COURSE = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final UserCourseServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(UserCourseServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_COURSE_INFO:
          serviceImpl.getCourseInfo((com.example.usercourse.UserCourseRpcProto.GetCourseRequest) request,
              (io.grpc.stub.StreamObserver<com.example.usercourse.UserCourseRpcProto.GetCourseResponse>) responseObserver);
          break;
        case METHODID_REGISTER_COURSE:
          serviceImpl.registerCourse((com.example.usercourse.UserCourseRpcProto.RegisterCourseRequest) request,
              (io.grpc.stub.StreamObserver<com.example.usercourse.UserCourseRpcProto.RegisterCourseResponse>) responseObserver);
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

  private static abstract class UserCourseServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    UserCourseServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.usercourse.UserCourseRpcProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("UserCourseService");
    }
  }

  private static final class UserCourseServiceFileDescriptorSupplier
      extends UserCourseServiceBaseDescriptorSupplier {
    UserCourseServiceFileDescriptorSupplier() {}
  }

  private static final class UserCourseServiceMethodDescriptorSupplier
      extends UserCourseServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    UserCourseServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (UserCourseServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new UserCourseServiceFileDescriptorSupplier())
              .addMethod(getGetCourseInfoMethod())
              .addMethod(getRegisterCourseMethod())
              .build();
        }
      }
    }
    return result;
  }
}
