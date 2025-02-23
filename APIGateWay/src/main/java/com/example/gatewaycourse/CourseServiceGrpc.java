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
 * Service cho Course
 * </pre>
 */
@jakarta.annotation.Generated(
    value = "by gRPC proto compiler (version 1.9.1)",
    comments = "Source: GateWay_Course_Rpc.proto")
public final class CourseServiceGrpc {

  private CourseServiceGrpc() {}

  public static final String SERVICE_NAME = "course.CourseService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetCourseMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.example.gatewaycourse.GateWayCourseRpcProto.GetCourseRequest,
      com.example.gatewaycourse.GateWayCourseRpcProto.GetCourseResponse> METHOD_GET_COURSE = getGetCourseMethod();

  private static volatile io.grpc.MethodDescriptor<com.example.gatewaycourse.GateWayCourseRpcProto.GetCourseRequest,
      com.example.gatewaycourse.GateWayCourseRpcProto.GetCourseResponse> getGetCourseMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.example.gatewaycourse.GateWayCourseRpcProto.GetCourseRequest,
      com.example.gatewaycourse.GateWayCourseRpcProto.GetCourseResponse> getGetCourseMethod() {
    io.grpc.MethodDescriptor<com.example.gatewaycourse.GateWayCourseRpcProto.GetCourseRequest, com.example.gatewaycourse.GateWayCourseRpcProto.GetCourseResponse> getGetCourseMethod;
    if ((getGetCourseMethod = CourseServiceGrpc.getGetCourseMethod) == null) {
      synchronized (CourseServiceGrpc.class) {
        if ((getGetCourseMethod = CourseServiceGrpc.getGetCourseMethod) == null) {
          CourseServiceGrpc.getGetCourseMethod = getGetCourseMethod = 
              io.grpc.MethodDescriptor.<com.example.gatewaycourse.GateWayCourseRpcProto.GetCourseRequest, com.example.gatewaycourse.GateWayCourseRpcProto.GetCourseResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "course.CourseService", "GetCourse"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewaycourse.GateWayCourseRpcProto.GetCourseRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewaycourse.GateWayCourseRpcProto.GetCourseResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CourseServiceMethodDescriptorSupplier("GetCourse"))
                  .build();
          }
        }
     }
     return getGetCourseMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetAllCoursesMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.example.gatewaycourse.GateWayCourseRpcProto.GetAllCoursesRequest,
      com.example.gatewaycourse.GateWayCourseRpcProto.GetAllCoursesResponse> METHOD_GET_ALL_COURSES = getGetAllCoursesMethod();

  private static volatile io.grpc.MethodDescriptor<com.example.gatewaycourse.GateWayCourseRpcProto.GetAllCoursesRequest,
      com.example.gatewaycourse.GateWayCourseRpcProto.GetAllCoursesResponse> getGetAllCoursesMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.example.gatewaycourse.GateWayCourseRpcProto.GetAllCoursesRequest,
      com.example.gatewaycourse.GateWayCourseRpcProto.GetAllCoursesResponse> getGetAllCoursesMethod() {
    io.grpc.MethodDescriptor<com.example.gatewaycourse.GateWayCourseRpcProto.GetAllCoursesRequest, com.example.gatewaycourse.GateWayCourseRpcProto.GetAllCoursesResponse> getGetAllCoursesMethod;
    if ((getGetAllCoursesMethod = CourseServiceGrpc.getGetAllCoursesMethod) == null) {
      synchronized (CourseServiceGrpc.class) {
        if ((getGetAllCoursesMethod = CourseServiceGrpc.getGetAllCoursesMethod) == null) {
          CourseServiceGrpc.getGetAllCoursesMethod = getGetAllCoursesMethod = 
              io.grpc.MethodDescriptor.<com.example.gatewaycourse.GateWayCourseRpcProto.GetAllCoursesRequest, com.example.gatewaycourse.GateWayCourseRpcProto.GetAllCoursesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "course.CourseService", "GetAllCourses"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewaycourse.GateWayCourseRpcProto.GetAllCoursesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewaycourse.GateWayCourseRpcProto.GetAllCoursesResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CourseServiceMethodDescriptorSupplier("GetAllCourses"))
                  .build();
          }
        }
     }
     return getGetAllCoursesMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getEnrollCourseMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.example.gatewaycourse.GateWayCourseRpcProto.EnrollRequest,
      com.example.gatewaycourse.GateWayCourseRpcProto.EnrollResponse> METHOD_ENROLL_COURSE = getEnrollCourseMethod();

  private static volatile io.grpc.MethodDescriptor<com.example.gatewaycourse.GateWayCourseRpcProto.EnrollRequest,
      com.example.gatewaycourse.GateWayCourseRpcProto.EnrollResponse> getEnrollCourseMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.example.gatewaycourse.GateWayCourseRpcProto.EnrollRequest,
      com.example.gatewaycourse.GateWayCourseRpcProto.EnrollResponse> getEnrollCourseMethod() {
    io.grpc.MethodDescriptor<com.example.gatewaycourse.GateWayCourseRpcProto.EnrollRequest, com.example.gatewaycourse.GateWayCourseRpcProto.EnrollResponse> getEnrollCourseMethod;
    if ((getEnrollCourseMethod = CourseServiceGrpc.getEnrollCourseMethod) == null) {
      synchronized (CourseServiceGrpc.class) {
        if ((getEnrollCourseMethod = CourseServiceGrpc.getEnrollCourseMethod) == null) {
          CourseServiceGrpc.getEnrollCourseMethod = getEnrollCourseMethod = 
              io.grpc.MethodDescriptor.<com.example.gatewaycourse.GateWayCourseRpcProto.EnrollRequest, com.example.gatewaycourse.GateWayCourseRpcProto.EnrollResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "course.CourseService", "EnrollCourse"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewaycourse.GateWayCourseRpcProto.EnrollRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewaycourse.GateWayCourseRpcProto.EnrollResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CourseServiceMethodDescriptorSupplier("EnrollCourse"))
                  .build();
          }
        }
     }
     return getEnrollCourseMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUnEnrollCourseMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.example.gatewaycourse.GateWayCourseRpcProto.UnEnrollRequest,
      com.example.gatewaycourse.GateWayCourseRpcProto.UnEnrollResponse> METHOD_UN_ENROLL_COURSE = getUnEnrollCourseMethod();

  private static volatile io.grpc.MethodDescriptor<com.example.gatewaycourse.GateWayCourseRpcProto.UnEnrollRequest,
      com.example.gatewaycourse.GateWayCourseRpcProto.UnEnrollResponse> getUnEnrollCourseMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.example.gatewaycourse.GateWayCourseRpcProto.UnEnrollRequest,
      com.example.gatewaycourse.GateWayCourseRpcProto.UnEnrollResponse> getUnEnrollCourseMethod() {
    io.grpc.MethodDescriptor<com.example.gatewaycourse.GateWayCourseRpcProto.UnEnrollRequest, com.example.gatewaycourse.GateWayCourseRpcProto.UnEnrollResponse> getUnEnrollCourseMethod;
    if ((getUnEnrollCourseMethod = CourseServiceGrpc.getUnEnrollCourseMethod) == null) {
      synchronized (CourseServiceGrpc.class) {
        if ((getUnEnrollCourseMethod = CourseServiceGrpc.getUnEnrollCourseMethod) == null) {
          CourseServiceGrpc.getUnEnrollCourseMethod = getUnEnrollCourseMethod = 
              io.grpc.MethodDescriptor.<com.example.gatewaycourse.GateWayCourseRpcProto.UnEnrollRequest, com.example.gatewaycourse.GateWayCourseRpcProto.UnEnrollResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "course.CourseService", "UnEnrollCourse"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewaycourse.GateWayCourseRpcProto.UnEnrollRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gatewaycourse.GateWayCourseRpcProto.UnEnrollResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CourseServiceMethodDescriptorSupplier("UnEnrollCourse"))
                  .build();
          }
        }
     }
     return getUnEnrollCourseMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CourseServiceStub newStub(io.grpc.Channel channel) {
    return new CourseServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CourseServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CourseServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CourseServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CourseServiceFutureStub(channel);
  }

  /**
   * <pre>
   * Service cho Course
   * </pre>
   */
  public static abstract class CourseServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getCourse(com.example.gatewaycourse.GateWayCourseRpcProto.GetCourseRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewaycourse.GateWayCourseRpcProto.GetCourseResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetCourseMethod(), responseObserver);
    }

    /**
     */
    public void getAllCourses(com.example.gatewaycourse.GateWayCourseRpcProto.GetAllCoursesRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewaycourse.GateWayCourseRpcProto.GetAllCoursesResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAllCoursesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Đăng ký khóa học
     * </pre>
     */
    public void enrollCourse(com.example.gatewaycourse.GateWayCourseRpcProto.EnrollRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewaycourse.GateWayCourseRpcProto.EnrollResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getEnrollCourseMethod(), responseObserver);
    }

    /**
     */
    public void unEnrollCourse(com.example.gatewaycourse.GateWayCourseRpcProto.UnEnrollRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewaycourse.GateWayCourseRpcProto.UnEnrollResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUnEnrollCourseMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetCourseMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.gatewaycourse.GateWayCourseRpcProto.GetCourseRequest,
                com.example.gatewaycourse.GateWayCourseRpcProto.GetCourseResponse>(
                  this, METHODID_GET_COURSE)))
          .addMethod(
            getGetAllCoursesMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.gatewaycourse.GateWayCourseRpcProto.GetAllCoursesRequest,
                com.example.gatewaycourse.GateWayCourseRpcProto.GetAllCoursesResponse>(
                  this, METHODID_GET_ALL_COURSES)))
          .addMethod(
            getEnrollCourseMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.gatewaycourse.GateWayCourseRpcProto.EnrollRequest,
                com.example.gatewaycourse.GateWayCourseRpcProto.EnrollResponse>(
                  this, METHODID_ENROLL_COURSE)))
          .addMethod(
            getUnEnrollCourseMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.gatewaycourse.GateWayCourseRpcProto.UnEnrollRequest,
                com.example.gatewaycourse.GateWayCourseRpcProto.UnEnrollResponse>(
                  this, METHODID_UN_ENROLL_COURSE)))
          .build();
    }
  }

  /**
   * <pre>
   * Service cho Course
   * </pre>
   */
  public static final class CourseServiceStub extends io.grpc.stub.AbstractStub<CourseServiceStub> {
    private CourseServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CourseServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CourseServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CourseServiceStub(channel, callOptions);
    }

    /**
     */
    public void getCourse(com.example.gatewaycourse.GateWayCourseRpcProto.GetCourseRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewaycourse.GateWayCourseRpcProto.GetCourseResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetCourseMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllCourses(com.example.gatewaycourse.GateWayCourseRpcProto.GetAllCoursesRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewaycourse.GateWayCourseRpcProto.GetAllCoursesResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAllCoursesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Đăng ký khóa học
     * </pre>
     */
    public void enrollCourse(com.example.gatewaycourse.GateWayCourseRpcProto.EnrollRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewaycourse.GateWayCourseRpcProto.EnrollResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getEnrollCourseMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void unEnrollCourse(com.example.gatewaycourse.GateWayCourseRpcProto.UnEnrollRequest request,
        io.grpc.stub.StreamObserver<com.example.gatewaycourse.GateWayCourseRpcProto.UnEnrollResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUnEnrollCourseMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Service cho Course
   * </pre>
   */
  public static final class CourseServiceBlockingStub extends io.grpc.stub.AbstractStub<CourseServiceBlockingStub> {
    private CourseServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CourseServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CourseServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CourseServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.gatewaycourse.GateWayCourseRpcProto.GetCourseResponse getCourse(com.example.gatewaycourse.GateWayCourseRpcProto.GetCourseRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetCourseMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.gatewaycourse.GateWayCourseRpcProto.GetAllCoursesResponse getAllCourses(com.example.gatewaycourse.GateWayCourseRpcProto.GetAllCoursesRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetAllCoursesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Đăng ký khóa học
     * </pre>
     */
    public com.example.gatewaycourse.GateWayCourseRpcProto.EnrollResponse enrollCourse(com.example.gatewaycourse.GateWayCourseRpcProto.EnrollRequest request) {
      return blockingUnaryCall(
          getChannel(), getEnrollCourseMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.gatewaycourse.GateWayCourseRpcProto.UnEnrollResponse unEnrollCourse(com.example.gatewaycourse.GateWayCourseRpcProto.UnEnrollRequest request) {
      return blockingUnaryCall(
          getChannel(), getUnEnrollCourseMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Service cho Course
   * </pre>
   */
  public static final class CourseServiceFutureStub extends io.grpc.stub.AbstractStub<CourseServiceFutureStub> {
    private CourseServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CourseServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CourseServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CourseServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.gatewaycourse.GateWayCourseRpcProto.GetCourseResponse> getCourse(
        com.example.gatewaycourse.GateWayCourseRpcProto.GetCourseRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetCourseMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.gatewaycourse.GateWayCourseRpcProto.GetAllCoursesResponse> getAllCourses(
        com.example.gatewaycourse.GateWayCourseRpcProto.GetAllCoursesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAllCoursesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Đăng ký khóa học
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.gatewaycourse.GateWayCourseRpcProto.EnrollResponse> enrollCourse(
        com.example.gatewaycourse.GateWayCourseRpcProto.EnrollRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getEnrollCourseMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.gatewaycourse.GateWayCourseRpcProto.UnEnrollResponse> unEnrollCourse(
        com.example.gatewaycourse.GateWayCourseRpcProto.UnEnrollRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUnEnrollCourseMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_COURSE = 0;
  private static final int METHODID_GET_ALL_COURSES = 1;
  private static final int METHODID_ENROLL_COURSE = 2;
  private static final int METHODID_UN_ENROLL_COURSE = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CourseServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CourseServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_COURSE:
          serviceImpl.getCourse((com.example.gatewaycourse.GateWayCourseRpcProto.GetCourseRequest) request,
              (io.grpc.stub.StreamObserver<com.example.gatewaycourse.GateWayCourseRpcProto.GetCourseResponse>) responseObserver);
          break;
        case METHODID_GET_ALL_COURSES:
          serviceImpl.getAllCourses((com.example.gatewaycourse.GateWayCourseRpcProto.GetAllCoursesRequest) request,
              (io.grpc.stub.StreamObserver<com.example.gatewaycourse.GateWayCourseRpcProto.GetAllCoursesResponse>) responseObserver);
          break;
        case METHODID_ENROLL_COURSE:
          serviceImpl.enrollCourse((com.example.gatewaycourse.GateWayCourseRpcProto.EnrollRequest) request,
              (io.grpc.stub.StreamObserver<com.example.gatewaycourse.GateWayCourseRpcProto.EnrollResponse>) responseObserver);
          break;
        case METHODID_UN_ENROLL_COURSE:
          serviceImpl.unEnrollCourse((com.example.gatewaycourse.GateWayCourseRpcProto.UnEnrollRequest) request,
              (io.grpc.stub.StreamObserver<com.example.gatewaycourse.GateWayCourseRpcProto.UnEnrollResponse>) responseObserver);
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

  private static abstract class CourseServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CourseServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.gatewaycourse.GateWayCourseRpcProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CourseService");
    }
  }

  private static final class CourseServiceFileDescriptorSupplier
      extends CourseServiceBaseDescriptorSupplier {
    CourseServiceFileDescriptorSupplier() {}
  }

  private static final class CourseServiceMethodDescriptorSupplier
      extends CourseServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CourseServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (CourseServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CourseServiceFileDescriptorSupplier())
              .addMethod(getGetCourseMethod())
              .addMethod(getGetAllCoursesMethod())
              .addMethod(getEnrollCourseMethod())
              .addMethod(getUnEnrollCourseMethod())
              .build();
        }
      }
    }
    return result;
  }
}
