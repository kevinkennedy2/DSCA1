// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: TransportPollutionService.proto

package grpc.DSCA;

public final class transportPollutionServiceImpl {
  private transportPollutionServiceImpl() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_railMessage_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_railMessage_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_railResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_railResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_carMessage_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_carMessage_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_carResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_carResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_busMessage_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_busMessage_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_busResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_busResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\037TransportPollutionService.proto\"#\n\013rai" +
      "lMessage\022\024\n\014distanceRail\030\001 \001(\001\"2\n\014railRe" +
      "sponse\022\021\n\temissions\030\001 \001(\001\022\017\n\007message\030\002 \001" +
      "(\t\"\'\n\ncarMessage\022\031\n\021distanceTravelled\030\001 " +
      "\001(\001\" \n\013carResponse\022\021\n\temissions\030\001 \001(\001\"/\n" +
      "\nbusMessage\022\020\n\010distance\030\001 \001(\001\022\017\n\007message" +
      "\030\002 \001(\t\"1\n\013busResponse\022\017\n\007message\030\001 \001(\t\022\021" +
      "\n\temissions\030\002 \001(\0012\255\001\n\031transportPollution" +
      "Service\0220\n\rrailPollution\022\014.railMessage\032\r" +
      ".railResponse\"\0000\001\022-\n\014carPollution\022\013.carM" +
      "essage\032\014.carResponse\"\000(\001\022/\n\014busPollution" +
      "\022\013.busMessage\032\014.busResponse\"\000(\0010\001B,\n\tgrp" +
      "c.DSCAB\035transportPollutionServiceImplP\001b" +
      "\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_railMessage_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_railMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_railMessage_descriptor,
        new java.lang.String[] { "DistanceRail", });
    internal_static_railResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_railResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_railResponse_descriptor,
        new java.lang.String[] { "Emissions", "Message", });
    internal_static_carMessage_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_carMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_carMessage_descriptor,
        new java.lang.String[] { "DistanceTravelled", });
    internal_static_carResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_carResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_carResponse_descriptor,
        new java.lang.String[] { "Emissions", });
    internal_static_busMessage_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_busMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_busMessage_descriptor,
        new java.lang.String[] { "Distance", "Message", });
    internal_static_busResponse_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_busResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_busResponse_descriptor,
        new java.lang.String[] { "Message", "Emissions", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}