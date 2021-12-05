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
    comments = "Source: TransportPollutionService.proto")
public final class transportPollutionServiceGrpc {

  private transportPollutionServiceGrpc() {}

  public static final String SERVICE_NAME = "transportPollutionService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.DSCA.railMessage,
      grpc.DSCA.railResponse> getRailPollutionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "railPollution",
      requestType = grpc.DSCA.railMessage.class,
      responseType = grpc.DSCA.railResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.DSCA.railMessage,
      grpc.DSCA.railResponse> getRailPollutionMethod() {
    io.grpc.MethodDescriptor<grpc.DSCA.railMessage, grpc.DSCA.railResponse> getRailPollutionMethod;
    if ((getRailPollutionMethod = transportPollutionServiceGrpc.getRailPollutionMethod) == null) {
      synchronized (transportPollutionServiceGrpc.class) {
        if ((getRailPollutionMethod = transportPollutionServiceGrpc.getRailPollutionMethod) == null) {
          transportPollutionServiceGrpc.getRailPollutionMethod = getRailPollutionMethod = 
              io.grpc.MethodDescriptor.<grpc.DSCA.railMessage, grpc.DSCA.railResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "transportPollutionService", "railPollution"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.DSCA.railMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.DSCA.railResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new transportPollutionServiceMethodDescriptorSupplier("railPollution"))
                  .build();
          }
        }
     }
     return getRailPollutionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.DSCA.carMessage,
      grpc.DSCA.carResponse> getCarPollutionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "carPollution",
      requestType = grpc.DSCA.carMessage.class,
      responseType = grpc.DSCA.carResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.DSCA.carMessage,
      grpc.DSCA.carResponse> getCarPollutionMethod() {
    io.grpc.MethodDescriptor<grpc.DSCA.carMessage, grpc.DSCA.carResponse> getCarPollutionMethod;
    if ((getCarPollutionMethod = transportPollutionServiceGrpc.getCarPollutionMethod) == null) {
      synchronized (transportPollutionServiceGrpc.class) {
        if ((getCarPollutionMethod = transportPollutionServiceGrpc.getCarPollutionMethod) == null) {
          transportPollutionServiceGrpc.getCarPollutionMethod = getCarPollutionMethod = 
              io.grpc.MethodDescriptor.<grpc.DSCA.carMessage, grpc.DSCA.carResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "transportPollutionService", "carPollution"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.DSCA.carMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.DSCA.carResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new transportPollutionServiceMethodDescriptorSupplier("carPollution"))
                  .build();
          }
        }
     }
     return getCarPollutionMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static transportPollutionServiceStub newStub(io.grpc.Channel channel) {
    return new transportPollutionServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static transportPollutionServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new transportPollutionServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static transportPollutionServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new transportPollutionServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class transportPollutionServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *Server Streaming
     * </pre>
     */
    public void railPollution(grpc.DSCA.railMessage request,
        io.grpc.stub.StreamObserver<grpc.DSCA.railResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getRailPollutionMethod(), responseObserver);
    }

    /**
     * <pre>
     *Client Streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<grpc.DSCA.carMessage> carPollution(
        io.grpc.stub.StreamObserver<grpc.DSCA.carResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getCarPollutionMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRailPollutionMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                grpc.DSCA.railMessage,
                grpc.DSCA.railResponse>(
                  this, METHODID_RAIL_POLLUTION)))
          .addMethod(
            getCarPollutionMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                grpc.DSCA.carMessage,
                grpc.DSCA.carResponse>(
                  this, METHODID_CAR_POLLUTION)))
          .build();
    }
  }

  /**
   */
  public static final class transportPollutionServiceStub extends io.grpc.stub.AbstractStub<transportPollutionServiceStub> {
    private transportPollutionServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private transportPollutionServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected transportPollutionServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new transportPollutionServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     *Server Streaming
     * </pre>
     */
    public void railPollution(grpc.DSCA.railMessage request,
        io.grpc.stub.StreamObserver<grpc.DSCA.railResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getRailPollutionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *Client Streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<grpc.DSCA.carMessage> carPollution(
        io.grpc.stub.StreamObserver<grpc.DSCA.carResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getCarPollutionMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class transportPollutionServiceBlockingStub extends io.grpc.stub.AbstractStub<transportPollutionServiceBlockingStub> {
    private transportPollutionServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private transportPollutionServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected transportPollutionServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new transportPollutionServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *Server Streaming
     * </pre>
     */
    public java.util.Iterator<grpc.DSCA.railResponse> railPollution(
        grpc.DSCA.railMessage request) {
      return blockingServerStreamingCall(
          getChannel(), getRailPollutionMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class transportPollutionServiceFutureStub extends io.grpc.stub.AbstractStub<transportPollutionServiceFutureStub> {
    private transportPollutionServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private transportPollutionServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected transportPollutionServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new transportPollutionServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_RAIL_POLLUTION = 0;
  private static final int METHODID_CAR_POLLUTION = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final transportPollutionServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(transportPollutionServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_RAIL_POLLUTION:
          serviceImpl.railPollution((grpc.DSCA.railMessage) request,
              (io.grpc.stub.StreamObserver<grpc.DSCA.railResponse>) responseObserver);
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
        case METHODID_CAR_POLLUTION:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.carPollution(
              (io.grpc.stub.StreamObserver<grpc.DSCA.carResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class transportPollutionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    transportPollutionServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.DSCA.transportPollutionServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("transportPollutionService");
    }
  }

  private static final class transportPollutionServiceFileDescriptorSupplier
      extends transportPollutionServiceBaseDescriptorSupplier {
    transportPollutionServiceFileDescriptorSupplier() {}
  }

  private static final class transportPollutionServiceMethodDescriptorSupplier
      extends transportPollutionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    transportPollutionServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (transportPollutionServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new transportPollutionServiceFileDescriptorSupplier())
              .addMethod(getRailPollutionMethod())
              .addMethod(getCarPollutionMethod())
              .build();
        }
      }
    }
    return result;
  }
}
