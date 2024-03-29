// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: RPCDateService.proto

package com.yangnk.springboottestexample.grpcExample.api;

/**
 * <pre>
 * 定义请求体
 * </pre>
 *
 * Protobuf type {@code com.yangnk.springboottestexample.grpcExample.api.RPCDateRequest}
 */
public  final class RPCDateRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.yangnk.springboottestexample.grpcExample.api.RPCDateRequest)
    RPCDateRequestOrBuilder {
  // Use RPCDateRequest.newBuilder() to construct.
  private RPCDateRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private RPCDateRequest() {
    userName_ = "";
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private RPCDateRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    int mutable_bitField0_ = 0;
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!input.skipField(tag)) {
              done = true;
            }
            break;
          }
          case 10: {
            String s = input.readStringRequireUtf8();

            userName_ = s;
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return RPCDateServiceApi.internal_static_com_yangnk_springboottestexample_grpcExample_api_RPCDateRequest_descriptor;
  }

  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return RPCDateServiceApi.internal_static_com_yangnk_springboottestexample_grpcExample_api_RPCDateRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            RPCDateRequest.class, Builder.class);
  }

  public static final int USERNAME_FIELD_NUMBER = 1;
  private volatile Object userName_;
  /**
   * <code>optional string userName = 1;</code>
   */
  public String getUserName() {
    Object ref = userName_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      userName_ = s;
      return s;
    }
  }
  /**
   * <code>optional string userName = 1;</code>
   */
  public com.google.protobuf.ByteString
      getUserNameBytes() {
    Object ref = userName_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      userName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getUserNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, userName_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getUserNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, userName_);
    }
    memoizedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  @Override
  public boolean equals(final Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof RPCDateRequest)) {
      return super.equals(obj);
    }
    RPCDateRequest other = (RPCDateRequest) obj;

    boolean result = true;
    result = result && getUserName()
        .equals(other.getUserName());
    return result;
  }

  @Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptorForType().hashCode();
    hash = (37 * hash) + USERNAME_FIELD_NUMBER;
    hash = (53 * hash) + getUserName().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static RPCDateRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static RPCDateRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static RPCDateRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static RPCDateRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static RPCDateRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static RPCDateRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static RPCDateRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static RPCDateRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static RPCDateRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static RPCDateRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(RPCDateRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @Override
  protected Builder newBuilderForType(
      BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   * 定义请求体
   * </pre>
   *
   * Protobuf type {@code com.yangnk.springboottestexample.grpcExample.api.RPCDateRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.yangnk.springboottestexample.grpcExample.api.RPCDateRequest)
      RPCDateRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return RPCDateServiceApi.internal_static_com_yangnk_springboottestexample_grpcExample_api_RPCDateRequest_descriptor;
    }

    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return RPCDateServiceApi.internal_static_com_yangnk_springboottestexample_grpcExample_api_RPCDateRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              RPCDateRequest.class, Builder.class);
    }

    // Construct using com.yangnk.springboottestexample.grpcExample.api.RPCDateRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    public Builder clear() {
      super.clear();
      userName_ = "";

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return RPCDateServiceApi.internal_static_com_yangnk_springboottestexample_grpcExample_api_RPCDateRequest_descriptor;
    }

    public RPCDateRequest getDefaultInstanceForType() {
      return RPCDateRequest.getDefaultInstance();
    }

    public RPCDateRequest build() {
      RPCDateRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public RPCDateRequest buildPartial() {
      RPCDateRequest result = new RPCDateRequest(this);
      result.userName_ = userName_;
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof RPCDateRequest) {
        return mergeFrom((RPCDateRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(RPCDateRequest other) {
      if (other == RPCDateRequest.getDefaultInstance()) return this;
      if (!other.getUserName().isEmpty()) {
        userName_ = other.userName_;
        onChanged();
      }
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      RPCDateRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (RPCDateRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private Object userName_ = "";
    /**
     * <code>optional string userName = 1;</code>
     */
    public String getUserName() {
      Object ref = userName_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        userName_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>optional string userName = 1;</code>
     */
    public com.google.protobuf.ByteString
        getUserNameBytes() {
      Object ref = userName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        userName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>optional string userName = 1;</code>
     */
    public Builder setUserName(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      userName_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional string userName = 1;</code>
     */
    public Builder clearUserName() {
      
      userName_ = getDefaultInstance().getUserName();
      onChanged();
      return this;
    }
    /**
     * <code>optional string userName = 1;</code>
     */
    public Builder setUserNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      userName_ = value;
      onChanged();
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:com.yangnk.springboottestexample.grpcExample.api.RPCDateRequest)
  }

  // @@protoc_insertion_point(class_scope:com.yangnk.springboottestexample.grpcExample.api.RPCDateRequest)
  private static final RPCDateRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new RPCDateRequest();
  }

  public static RPCDateRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<RPCDateRequest>
      PARSER = new com.google.protobuf.AbstractParser<RPCDateRequest>() {
    public RPCDateRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new RPCDateRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<RPCDateRequest> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<RPCDateRequest> getParserForType() {
    return PARSER;
  }

  public RPCDateRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

