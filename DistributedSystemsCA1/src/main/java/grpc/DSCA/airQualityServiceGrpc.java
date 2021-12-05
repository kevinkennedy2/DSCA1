package grpc.DSCA;

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
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: AirQualityService.proto")
public final class airQualityServiceGrpc {

  private airQualityServiceGrpc() {}

  public static final String SERVICE_NAME = "airQualityService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.DSCA.IndexRankNumber,
      grpc.DSCA.IndexRankRating> getGetAirQualityIndexMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAirQualityIndex",
      requestType = grpc.DSCA.IndexRankNumber.class,
      responseType = grpc.DSCA.IndexRankRating.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.DSCA.IndexRankNumber,
      grpc.DSCA.IndexRankRating> getGetAirQualityIndexMethod() {
    io.grpc.MethodDescriptor<grpc.DSCA.IndexRankNumber, grpc.DSCA.IndexRankRating> getGetAirQualityIndexMethod;
    if ((getGetAirQualityIndexMethod = airQualityServiceGrpc.getGetAirQualityIndexMethod) == null) {
      synchronized (airQualityServiceGrpc.class) {
        if ((getGetAirQualityIndexMethod = airQualityServiceGrpc.getGetAirQualityIndexMethod) == null) {
          airQualityServiceGrpc.getGetAirQualityIndexMethod = getGetAirQualityIndexMethod = 
              io.grpc.MethodDescriptor.<grpc.DSCA.IndexRankNumber, grpc.DSCA.IndexRankRating>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "airQualityService", "getAirQualityIndex"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.DSCA.IndexRankNumber.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.DSCA.IndexRankRating.getDefaultInstance()))
                  .setSchemaDescriptor(new airQualityServiceMethodDescriptorSupplier("getAirQualityIndex"))
                  .build();
          }
        }
     }
     return getGetAirQualityIndexMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.DSCA.GasType,
      grpc.DSCA.PollutionResult> getPollutantCalculationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "pollutantCalculation",
      requestType = grpc.DSCA.GasType.class,
      responseType = grpc.DSCA.PollutionResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.DSCA.GasType,
      grpc.DSCA.PollutionResult> getPollutantCalculationMethod() {
    io.grpc.MethodDescriptor<grpc.DSCA.GasType, grpc.DSCA.PollutionResult> getPollutantCalculationMethod;
    if ((getPollutantCalculationMethod = airQualityServiceGrpc.getPollutantCalculationMethod) == null) {
      synchronized (airQualityServiceGrpc.class) {
        if ((getPollutantCalculationMethod = airQualityServiceGrpc.getPollutantCalculationMethod) == null) {
          airQualityServiceGrpc.getPollutantCalculationMethod = getPollutantCalculationMethod = 
              io.grpc.MethodDescriptor.<grpc.DSCA.GasType, grpc.DSCA.PollutionResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "airQualityService", "pollutantCalculation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.DSCA.GasType.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.DSCA.PollutionResult.getDefaultInstance()))
                  .setSchemaDescriptor(new airQualityServiceMethodDescriptorSupplier("pollutantCalculation"))
                  .build();
          }
        }
     }
     return getPollutantCalculationMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static airQualityServiceStub newStub(io.grpc.Channel channel) {
    return new airQualityServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static airQualityServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new airQualityServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static airQualityServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new airQualityServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class airQualityServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *Unary RPC - send Integer for Index and receive warning level string back
     * </pre>
     */
    public void getAirQualityIndex(grpc.DSCA.IndexRankNumber request,
        io.grpc.stub.StreamObserver<grpc.DSCA.IndexRankRating> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAirQualityIndexMethod(), responseObserver);
    }

    /**
     * <pre>
     *BioDirectional Streaming RPC
     * </pre>
     */
    public io.grpc.stub.StreamObserver<grpc.DSCA.GasType> pollutantCalculation(
        io.grpc.stub.StreamObserver<grpc.DSCA.PollutionResult> responseObserver) {
      return asyncUnimplementedStreamingCall(getPollutantCalculationMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetAirQualityIndexMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.DSCA.IndexRankNumber,
                grpc.DSCA.IndexRankRating>(
                  this, METHODID_GET_AIR_QUALITY_INDEX)))
          .addMethod(
            getPollutantCalculationMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                grpc.DSCA.GasType,
                grpc.DSCA.PollutionResult>(
                  this, METHODID_POLLUTANT_CALCULATION)))
          .build();
    }
  }

  /**
   */
  public static final class airQualityServiceStub extends io.grpc.stub.AbstractStub<airQualityServiceStub> {
    private airQualityServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private airQualityServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected airQualityServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new airQualityServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     *Unary RPC - send Integer for Index and receive warning level string back
     * </pre>
     */
    public void getAirQualityIndex(grpc.DSCA.IndexRankNumber request,
        io.grpc.stub.StreamObserver<grpc.DSCA.IndexRankRating> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAirQualityIndexMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *BioDirectional Streaming RPC
     * </pre>
     */
    public io.grpc.stub.StreamObserver<grpc.DSCA.GasType> pollutantCalculation(
        io.grpc.stub.StreamObserver<grpc.DSCA.PollutionResult> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getPollutantCalculationMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class airQualityServiceBlockingStub extends io.grpc.stub.AbstractStub<airQualityServiceBlockingStub> {
    private airQualityServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private airQualityServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected airQualityServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new airQualityServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *Unary RPC - send Integer for Index and receive warning level string back
     * </pre>
     */
    public grpc.DSCA.IndexRankRating getAirQualityIndex(grpc.DSCA.IndexRankNumber request) {
      return blockingUnaryCall(
          getChannel(), getGetAirQualityIndexMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class airQualityServiceFutureStub extends io.grpc.stub.AbstractStub<airQualityServiceFutureStub> {
    private airQualityServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private airQualityServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected airQualityServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new airQualityServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *Unary RPC - send Integer for Index and receive warning level string back
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.DSCA.IndexRankRating> getAirQualityIndex(
        grpc.DSCA.IndexRankNumber request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAirQualityIndexMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_AIR_QUALITY_INDEX = 0;
  private static final int METHODID_POLLUTANT_CALCULATION = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final airQualityServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(airQualityServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_AIR_QUALITY_INDEX:
          serviceImpl.getAirQualityIndex((grpc.DSCA.IndexRankNumber) request,
              (io.grpc.stub.StreamObserver<grpc.DSCA.IndexRankRating>) responseObserver);
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
        case METHODID_POLLUTANT_CALCULATION:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.pollutantCalculation(
              (io.grpc.stub.StreamObserver<grpc.DSCA.PollutionResult>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class airQualityServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    airQualityServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.DSCA.AirQualityServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("airQualityService");
    }
  }

  private static final class airQualityServiceFileDescriptorSupplier
      extends airQualityServiceBaseDescriptorSupplier {
    airQualityServiceFileDescriptorSupplier() {}
  }

  private static final class airQualityServiceMethodDescriptorSupplier
      extends airQualityServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    airQualityServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (airQualityServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new airQualityServiceFileDescriptorSupplier())
              .addMethod(getGetAirQualityIndexMethod())
              .addMethod(getPollutantCalculationMethod())
              .build();
        }
      }
    }
    return result;
  }
}
