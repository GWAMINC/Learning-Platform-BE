package com.example.gatewayuser;

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
 * Service cho User
 * </pre>
 */
@jakarta.annotation.Generated(
    value = "by gRPC proto compiler (version 1.9.1)",
    comments = "Source: GateWay_User_Rpc.proto")
public final class UserServiceGrpc {

  private UserServiceGrpc() {}

  public static final String SERVICE_NAME = "user.UserService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetUserMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.example.gatewayuser.GateWayUserRpcProto.GetUserRequest,
      com.example.gatewayuser.GateWayUserRpcProto.GetUserResponse> METHOD_GET_USER = getGetUserMethod();

  private static volatile io.grpc.MethodDescriptor<com.example.gatewayuser.GateWayUserRpcProto.GetUserRequest,
      com.example.gatewayuser.GateWayUserRpcProto.GetUserResponse> getGetUserMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.example.gatewayuser.GateWayUserRpcProto.GetUserRequest,
      com.example.gatewayuser.GateWayUserRpcProto.GetUserResponse> getGetUserMethod() {
    io.grpc.MethodDescriptor<com.example.gatewayuser.GateWayUserRpcProto.GetUserRequest, com.example.gatewayuser.GateWayUserRpcProto.GetUserResponse> getGetUserMethod;
    if ((getGetUserMethod = UserServiceGrpc.getGetUserMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getGetUserMethod = UserServiceGrpc.getGetUserMethod) == null) {
          UserServiceGrpc.getGetUserMethod = getGetUserMethod = 
              io.grpc.MethodDescriptor.<com.example.gatewayuser.GateWayUserRpcProto.GetUserRequest, com.example.gatewayuser.GateWayUserRpcProto.GetUserResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "user.UserService", "GetUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewayuser.GateWayUserRpcProto.GetUserRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewayuser.GateWayUserRpcProto.GetUserResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("GetUser"))
                  .build();
          }
        }
     }
     return getGetUserMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetAllUsersMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.example.gatewayuser.GateWayUserRpcProto.GetAllUsersRequest,
      com.example.gatewayuser.GateWayUserRpcProto.GetAllUsersResponse> METHOD_GET_ALL_USERS = getGetAllUsersMethod();

  private static volatile io.grpc.MethodDescriptor<com.example.gatewayuser.GateWayUserRpcProto.GetAllUsersRequest,
      com.example.gatewayuser.GateWayUserRpcProto.GetAllUsersResponse> getGetAllUsersMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.example.gatewayuser.GateWayUserRpcProto.GetAllUsersRequest,
      com.example.gatewayuser.GateWayUserRpcProto.GetAllUsersResponse> getGetAllUsersMethod() {
    io.grpc.MethodDescriptor<com.example.gatewayuser.GateWayUserRpcProto.GetAllUsersRequest, com.example.gatewayuser.GateWayUserRpcProto.GetAllUsersResponse> getGetAllUsersMethod;
    if ((getGetAllUsersMethod = UserServiceGrpc.getGetAllUsersMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getGetAllUsersMethod = UserServiceGrpc.getGetAllUsersMethod) == null) {
          UserServiceGrpc.getGetAllUsersMethod = getGetAllUsersMethod = 
              io.grpc.MethodDescriptor.<com.example.gatewayuser.GateWayUserRpcProto.GetAllUsersRequest, com.example.gatewayuser.GateWayUserRpcProto.GetAllUsersResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "user.UserService", "GetAllUsers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewayuser.GateWayUserRpcProto.GetAllUsersRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewayuser.GateWayUserRpcProto.GetAllUsersResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("GetAllUsers"))
                  .build();
          }
        }
     }
     return getGetAllUsersMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getLoginMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.example.gatewayuser.GateWayUserRpcProto.LoginRequest,
      com.example.gatewayuser.GateWayUserRpcProto.LoginResponse> METHOD_LOGIN = getLoginMethod();

  private static volatile io.grpc.MethodDescriptor<com.example.gatewayuser.GateWayUserRpcProto.LoginRequest,
      com.example.gatewayuser.GateWayUserRpcProto.LoginResponse> getLoginMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.example.gatewayuser.GateWayUserRpcProto.LoginRequest,
      com.example.gatewayuser.GateWayUserRpcProto.LoginResponse> getLoginMethod() {
    io.grpc.MethodDescriptor<com.example.gatewayuser.GateWayUserRpcProto.LoginRequest, com.example.gatewayuser.GateWayUserRpcProto.LoginResponse> getLoginMethod;
    if ((getLoginMethod = UserServiceGrpc.getLoginMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getLoginMethod = UserServiceGrpc.getLoginMethod) == null) {
          UserServiceGrpc.getLoginMethod = getLoginMethod = 
              io.grpc.MethodDescriptor.<com.example.gatewayuser.GateWayUserRpcProto.LoginRequest, com.example.gatewayuser.GateWayUserRpcProto.LoginResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "user.UserService", "Login"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewayuser.GateWayUserRpcProto.LoginRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewayuser.GateWayUserRpcProto.LoginResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("Login"))
                  .build();
          }
        }
     }
     return getLoginMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getRegisterMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.example.gatewayuser.GateWayUserRpcProto.RegisterRequest,
      com.example.gatewayuser.GateWayUserRpcProto.RegisterResponse> METHOD_REGISTER = getRegisterMethod();

  private static volatile io.grpc.MethodDescriptor<com.example.gatewayuser.GateWayUserRpcProto.RegisterRequest,
      com.example.gatewayuser.GateWayUserRpcProto.RegisterResponse> getRegisterMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.example.gatewayuser.GateWayUserRpcProto.RegisterRequest,
      com.example.gatewayuser.GateWayUserRpcProto.RegisterResponse> getRegisterMethod() {
    io.grpc.MethodDescriptor<com.example.gatewayuser.GateWayUserRpcProto.RegisterRequest, com.example.gatewayuser.GateWayUserRpcProto.RegisterResponse> getRegisterMethod;
    if ((getRegisterMethod = UserServiceGrpc.getRegisterMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getRegisterMethod = UserServiceGrpc.getRegisterMethod) == null) {
          UserServiceGrpc.getRegisterMethod = getRegisterMethod = 
              io.grpc.MethodDescriptor.<com.example.gatewayuser.GateWayUserRpcProto.RegisterRequest, com.example.gatewayuser.GateWayUserRpcProto.RegisterResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "user.UserService", "Register"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewayuser.GateWayUserRpcProto.RegisterRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewayuser.GateWayUserRpcProto.RegisterResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("Register"))
                  .build();
          }
        }
     }
     return getRegisterMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getForgotPasswordMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.example.gatewayuser.GateWayUserRpcProto.ForgotPasswordRequest,
      com.example.gatewayuser.GateWayUserRpcProto.ForgotPasswordResponse> METHOD_FORGOT_PASSWORD = getForgotPasswordMethod();

  private static volatile io.grpc.MethodDescriptor<com.example.gatewayuser.GateWayUserRpcProto.ForgotPasswordRequest,
      com.example.gatewayuser.GateWayUserRpcProto.ForgotPasswordResponse> getForgotPasswordMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.example.gatewayuser.GateWayUserRpcProto.ForgotPasswordRequest,
      com.example.gatewayuser.GateWayUserRpcProto.ForgotPasswordResponse> getForgotPasswordMethod() {
    io.grpc.MethodDescriptor<com.example.gatewayuser.GateWayUserRpcProto.ForgotPasswordRequest, com.example.gatewayuser.GateWayUserRpcProto.ForgotPasswordResponse> getForgotPasswordMethod;
    if ((getForgotPasswordMethod = UserServiceGrpc.getForgotPasswordMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getForgotPasswordMethod = UserServiceGrpc.getForgotPasswordMethod) == null) {
          UserServiceGrpc.getForgotPasswordMethod = getForgotPasswordMethod = 
              io.grpc.MethodDescriptor.<com.example.gatewayuser.GateWayUserRpcProto.ForgotPasswordRequest, com.example.gatewayuser.GateWayUserRpcProto.ForgotPasswordResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "user.UserService", "ForgotPassword"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewayuser.GateWayUserRpcProto.ForgotPasswordRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewayuser.GateWayUserRpcProto.ForgotPasswordResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("ForgotPassword"))
                  .build();
          }
        }
     }
     return getForgotPasswordMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UserServiceStub newStub(io.grpc.Channel channel) {
    return new UserServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UserServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new UserServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static UserServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new UserServiceFutureStub(channel);
  }

  /**
   * <pre>
   * Service cho User
   * </pre>
   */
  public static abstract class UserServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getUser(com.example.gatewayuser.GateWayUserRpcProto.GetUserRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewayuser.GateWayUserRpcProto.GetUserResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetUserMethod(), responseObserver);
    }

    /**
     */
    public void getAllUsers(com.example.gatewayuser.GateWayUserRpcProto.GetAllUsersRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewayuser.GateWayUserRpcProto.GetAllUsersResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAllUsersMethod(), responseObserver);
    }

    /**
     */
    public void login(com.example.gatewayuser.GateWayUserRpcProto.LoginRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewayuser.GateWayUserRpcProto.LoginResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getLoginMethod(), responseObserver);
    }

    /**
     */
    public void register(com.example.gatewayuser.GateWayUserRpcProto.RegisterRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewayuser.GateWayUserRpcProto.RegisterResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getRegisterMethod(), responseObserver);
    }

    /**
     */
    public void forgotPassword(com.example.gatewayuser.GateWayUserRpcProto.ForgotPasswordRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewayuser.GateWayUserRpcProto.ForgotPasswordResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getForgotPasswordMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetUserMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.gatewayuser.GateWayUserRpcProto.GetUserRequest,
                com.example.gatewayuser.GateWayUserRpcProto.GetUserResponse>(
                  this, METHODID_GET_USER)))
          .addMethod(
            getGetAllUsersMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.gatewayuser.GateWayUserRpcProto.GetAllUsersRequest,
                com.example.gatewayuser.GateWayUserRpcProto.GetAllUsersResponse>(
                  this, METHODID_GET_ALL_USERS)))
          .addMethod(
            getLoginMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.gatewayuser.GateWayUserRpcProto.LoginRequest,
                com.example.gatewayuser.GateWayUserRpcProto.LoginResponse>(
                  this, METHODID_LOGIN)))
          .addMethod(
            getRegisterMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.gatewayuser.GateWayUserRpcProto.RegisterRequest,
                com.example.gatewayuser.GateWayUserRpcProto.RegisterResponse>(
                  this, METHODID_REGISTER)))
          .addMethod(
            getForgotPasswordMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.gatewayuser.GateWayUserRpcProto.ForgotPasswordRequest,
                com.example.gatewayuser.GateWayUserRpcProto.ForgotPasswordResponse>(
                  this, METHODID_FORGOT_PASSWORD)))
          .build();
    }
  }

  /**
   * <pre>
   * Service cho User
   * </pre>
   */
  public static final class UserServiceStub extends io.grpc.stub.AbstractStub<UserServiceStub> {
    private UserServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserServiceStub(channel, callOptions);
    }

    /**
     */
    public void getUser(com.example.gatewayuser.GateWayUserRpcProto.GetUserRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewayuser.GateWayUserRpcProto.GetUserResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllUsers(com.example.gatewayuser.GateWayUserRpcProto.GetAllUsersRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewayuser.GateWayUserRpcProto.GetAllUsersResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAllUsersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void login(com.example.gatewayuser.GateWayUserRpcProto.LoginRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewayuser.GateWayUserRpcProto.LoginResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void register(com.example.gatewayuser.GateWayUserRpcProto.RegisterRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewayuser.GateWayUserRpcProto.RegisterResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRegisterMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void forgotPassword(com.example.gatewayuser.GateWayUserRpcProto.ForgotPasswordRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewayuser.GateWayUserRpcProto.ForgotPasswordResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getForgotPasswordMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Service cho User
   * </pre>
   */
  public static final class UserServiceBlockingStub extends io.grpc.stub.AbstractStub<UserServiceBlockingStub> {
    private UserServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.gatewayuser.GateWayUserRpcProto.GetUserResponse getUser(com.example.gatewayuser.GateWayUserRpcProto.GetUserRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetUserMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.gatewayuser.GateWayUserRpcProto.GetAllUsersResponse getAllUsers(com.example.gatewayuser.GateWayUserRpcProto.GetAllUsersRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetAllUsersMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.gatewayuser.GateWayUserRpcProto.LoginResponse login(com.example.gatewayuser.GateWayUserRpcProto.LoginRequest request) {
      return blockingUnaryCall(
          getChannel(), getLoginMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.gatewayuser.GateWayUserRpcProto.RegisterResponse register(com.example.gatewayuser.GateWayUserRpcProto.RegisterRequest request) {
      return blockingUnaryCall(
          getChannel(), getRegisterMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.gatewayuser.GateWayUserRpcProto.ForgotPasswordResponse forgotPassword(com.example.gatewayuser.GateWayUserRpcProto.ForgotPasswordRequest request) {
      return blockingUnaryCall(
          getChannel(), getForgotPasswordMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Service cho User
   * </pre>
   */
  public static final class UserServiceFutureStub extends io.grpc.stub.AbstractStub<UserServiceFutureStub> {
    private UserServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.gatewayuser.GateWayUserRpcProto.GetUserResponse> getUser(
        com.example.gatewayuser.GateWayUserRpcProto.GetUserRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetUserMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.gatewayuser.GateWayUserRpcProto.GetAllUsersResponse> getAllUsers(
        com.example.gatewayuser.GateWayUserRpcProto.GetAllUsersRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAllUsersMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.gatewayuser.GateWayUserRpcProto.LoginResponse> login(
        com.example.gatewayuser.GateWayUserRpcProto.LoginRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.gatewayuser.GateWayUserRpcProto.RegisterResponse> register(
        com.example.gatewayuser.GateWayUserRpcProto.RegisterRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRegisterMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.gatewayuser.GateWayUserRpcProto.ForgotPasswordResponse> forgotPassword(
        com.example.gatewayuser.GateWayUserRpcProto.ForgotPasswordRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getForgotPasswordMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_USER = 0;
  private static final int METHODID_GET_ALL_USERS = 1;
  private static final int METHODID_LOGIN = 2;
  private static final int METHODID_REGISTER = 3;
  private static final int METHODID_FORGOT_PASSWORD = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final UserServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(UserServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_USER:
          serviceImpl.getUser((com.example.gatewayuser.GateWayUserRpcProto.GetUserRequest) request,
              (io.grpc.stub.StreamObserver<com.example.gatewayuser.GateWayUserRpcProto.GetUserResponse>) responseObserver);
          break;
        case METHODID_GET_ALL_USERS:
          serviceImpl.getAllUsers((com.example.gatewayuser.GateWayUserRpcProto.GetAllUsersRequest) request,
              (io.grpc.stub.StreamObserver<com.example.gatewayuser.GateWayUserRpcProto.GetAllUsersResponse>) responseObserver);
          break;
        case METHODID_LOGIN:
          serviceImpl.login((com.example.gatewayuser.GateWayUserRpcProto.LoginRequest) request,
              (io.grpc.stub.StreamObserver<com.example.gatewayuser.GateWayUserRpcProto.LoginResponse>) responseObserver);
          break;
        case METHODID_REGISTER:
          serviceImpl.register((com.example.gatewayuser.GateWayUserRpcProto.RegisterRequest) request,
              (io.grpc.stub.StreamObserver<com.example.gatewayuser.GateWayUserRpcProto.RegisterResponse>) responseObserver);
          break;
        case METHODID_FORGOT_PASSWORD:
          serviceImpl.forgotPassword((com.example.gatewayuser.GateWayUserRpcProto.ForgotPasswordRequest) request,
              (io.grpc.stub.StreamObserver<com.example.gatewayuser.GateWayUserRpcProto.ForgotPasswordResponse>) responseObserver);
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

  private static abstract class UserServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    UserServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.gatewayuser.GateWayUserRpcProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("UserService");
    }
  }

  private static final class UserServiceFileDescriptorSupplier
      extends UserServiceBaseDescriptorSupplier {
    UserServiceFileDescriptorSupplier() {}
  }

  private static final class UserServiceMethodDescriptorSupplier
      extends UserServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    UserServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (UserServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new UserServiceFileDescriptorSupplier())
              .addMethod(getGetUserMethod())
              .addMethod(getGetAllUsersMethod())
              .addMethod(getLoginMethod())
              .addMethod(getRegisterMethod())
              .addMethod(getForgotPasswordMethod())
              .build();
        }
      }
    }
    return result;
  }
}
