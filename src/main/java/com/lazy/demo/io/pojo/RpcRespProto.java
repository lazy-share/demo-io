// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: RpcResp.proto

package com.lazy.demo.io.pojo;

public final class RpcRespProto {
  private RpcRespProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface RpcRespOrBuilder extends
      // @@protoc_insertion_point(interface_extends:proto.RpcResp)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>required string code = 1;</code>
     */
    boolean hasCode();
    /**
     * <code>required string code = 1;</code>
     */
    String getCode();
    /**
     * <code>required string code = 1;</code>
     */
    com.google.protobuf.ByteString
        getCodeBytes();

    /**
     * <code>required string msg = 2;</code>
     */
    boolean hasMsg();
    /**
     * <code>required string msg = 2;</code>
     */
    String getMsg();
    /**
     * <code>required string msg = 2;</code>
     */
    com.google.protobuf.ByteString
        getMsgBytes();

    /**
     * <code>required .proto.OrderMain body = 3;</code>
     */
    boolean hasBody();
    /**
     * <code>required .proto.OrderMain body = 3;</code>
     */
    OrderMainProto.OrderMain getBody();
    /**
     * <code>required .proto.OrderMain body = 3;</code>
     */
    OrderMainProto.OrderMainOrBuilder getBodyOrBuilder();
  }
  /**
   * Protobuf type {@code proto.RpcResp}
   */
  public  static final class RpcResp extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:proto.RpcResp)
      RpcRespOrBuilder {
    // Use RpcResp.newBuilder() to construct.
    private RpcResp(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private RpcResp() {
      code_ = "";
      msg_ = "";
    }

    @Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private RpcResp(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 10: {
              com.google.protobuf.ByteString bs = input.readBytes();
              bitField0_ |= 0x00000001;
              code_ = bs;
              break;
            }
            case 18: {
              com.google.protobuf.ByteString bs = input.readBytes();
              bitField0_ |= 0x00000002;
              msg_ = bs;
              break;
            }
            case 26: {
              OrderMainProto.OrderMain.Builder subBuilder = null;
              if (((bitField0_ & 0x00000004) == 0x00000004)) {
                subBuilder = body_.toBuilder();
              }
              body_ = input.readMessage(OrderMainProto.OrderMain.PARSER, extensionRegistry);
              if (subBuilder != null) {
                subBuilder.mergeFrom(body_);
                body_ = subBuilder.buildPartial();
              }
              bitField0_ |= 0x00000004;
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
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return RpcRespProto.internal_static_proto_RpcResp_descriptor;
    }

    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return RpcRespProto.internal_static_proto_RpcResp_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              RpcRespProto.RpcResp.class, RpcRespProto.RpcResp.Builder.class);
    }

    private int bitField0_;
    public static final int CODE_FIELD_NUMBER = 1;
    private volatile Object code_;
    /**
     * <code>required string code = 1;</code>
     */
    public boolean hasCode() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required string code = 1;</code>
     */
    public String getCode() {
      Object ref = code_;
      if (ref instanceof String) {
        return (String) ref;
      } else {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          code_ = s;
        }
        return s;
      }
    }
    /**
     * <code>required string code = 1;</code>
     */
    public com.google.protobuf.ByteString
        getCodeBytes() {
      Object ref = code_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        code_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int MSG_FIELD_NUMBER = 2;
    private volatile Object msg_;
    /**
     * <code>required string msg = 2;</code>
     */
    public boolean hasMsg() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>required string msg = 2;</code>
     */
    public String getMsg() {
      Object ref = msg_;
      if (ref instanceof String) {
        return (String) ref;
      } else {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          msg_ = s;
        }
        return s;
      }
    }
    /**
     * <code>required string msg = 2;</code>
     */
    public com.google.protobuf.ByteString
        getMsgBytes() {
      Object ref = msg_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        msg_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int BODY_FIELD_NUMBER = 3;
    private OrderMainProto.OrderMain body_;
    /**
     * <code>required .proto.OrderMain body = 3;</code>
     */
    public boolean hasBody() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <code>required .proto.OrderMain body = 3;</code>
     */
    public OrderMainProto.OrderMain getBody() {
      return body_ == null ? OrderMainProto.OrderMain.getDefaultInstance() : body_;
    }
    /**
     * <code>required .proto.OrderMain body = 3;</code>
     */
    public OrderMainProto.OrderMainOrBuilder getBodyOrBuilder() {
      return body_ == null ? OrderMainProto.OrderMain.getDefaultInstance() : body_;
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      if (!hasCode()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasMsg()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasBody()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!getBody().isInitialized()) {
        memoizedIsInitialized = 0;
        return false;
      }
      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, code_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, msg_);
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        output.writeMessage(3, getBody());
      }
      unknownFields.writeTo(output);
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, code_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, msg_);
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(3, getBody());
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @Override
    public boolean equals(final Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof RpcRespProto.RpcResp)) {
        return super.equals(obj);
      }
      RpcRespProto.RpcResp other = (RpcRespProto.RpcResp) obj;

      boolean result = true;
      result = result && (hasCode() == other.hasCode());
      if (hasCode()) {
        result = result && getCode()
            .equals(other.getCode());
      }
      result = result && (hasMsg() == other.hasMsg());
      if (hasMsg()) {
        result = result && getMsg()
            .equals(other.getMsg());
      }
      result = result && (hasBody() == other.hasBody());
      if (hasBody()) {
        result = result && getBody()
            .equals(other.getBody());
      }
      result = result && unknownFields.equals(other.unknownFields);
      return result;
    }

    @Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptorForType().hashCode();
      if (hasCode()) {
        hash = (37 * hash) + CODE_FIELD_NUMBER;
        hash = (53 * hash) + getCode().hashCode();
      }
      if (hasMsg()) {
        hash = (37 * hash) + MSG_FIELD_NUMBER;
        hash = (53 * hash) + getMsg().hashCode();
      }
      if (hasBody()) {
        hash = (37 * hash) + BODY_FIELD_NUMBER;
        hash = (53 * hash) + getBody().hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static RpcRespProto.RpcResp parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static RpcRespProto.RpcResp parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static RpcRespProto.RpcResp parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static RpcRespProto.RpcResp parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static RpcRespProto.RpcResp parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static RpcRespProto.RpcResp parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static RpcRespProto.RpcResp parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static RpcRespProto.RpcResp parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static RpcRespProto.RpcResp parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static RpcRespProto.RpcResp parseFrom(
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
    public static Builder newBuilder(RpcRespProto.RpcResp prototype) {
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
     * Protobuf type {@code proto.RpcResp}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:proto.RpcResp)
        RpcRespProto.RpcRespOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return RpcRespProto.internal_static_proto_RpcResp_descriptor;
      }

      protected FieldAccessorTable
          internalGetFieldAccessorTable() {
        return RpcRespProto.internal_static_proto_RpcResp_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                RpcRespProto.RpcResp.class, RpcRespProto.RpcResp.Builder.class);
      }

      // Construct using com.lazy.demo.io.pojo.RpcRespProto.RpcResp.newBuilder()
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
          getBodyFieldBuilder();
        }
      }
      public Builder clear() {
        super.clear();
        code_ = "";
        bitField0_ = (bitField0_ & ~0x00000001);
        msg_ = "";
        bitField0_ = (bitField0_ & ~0x00000002);
        if (bodyBuilder_ == null) {
          body_ = null;
        } else {
          bodyBuilder_.clear();
        }
        bitField0_ = (bitField0_ & ~0x00000004);
        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return RpcRespProto.internal_static_proto_RpcResp_descriptor;
      }

      public RpcRespProto.RpcResp getDefaultInstanceForType() {
        return RpcRespProto.RpcResp.getDefaultInstance();
      }

      public RpcRespProto.RpcResp build() {
        RpcRespProto.RpcResp result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public RpcRespProto.RpcResp buildPartial() {
        RpcRespProto.RpcResp result = new RpcRespProto.RpcResp(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.code_ = code_;
        if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
          to_bitField0_ |= 0x00000002;
        }
        result.msg_ = msg_;
        if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
          to_bitField0_ |= 0x00000004;
        }
        if (bodyBuilder_ == null) {
          result.body_ = body_;
        } else {
          result.body_ = bodyBuilder_.build();
        }
        result.bitField0_ = to_bitField0_;
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
        if (other instanceof RpcRespProto.RpcResp) {
          return mergeFrom((RpcRespProto.RpcResp)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(RpcRespProto.RpcResp other) {
        if (other == RpcRespProto.RpcResp.getDefaultInstance()) return this;
        if (other.hasCode()) {
          bitField0_ |= 0x00000001;
          code_ = other.code_;
          onChanged();
        }
        if (other.hasMsg()) {
          bitField0_ |= 0x00000002;
          msg_ = other.msg_;
          onChanged();
        }
        if (other.hasBody()) {
          mergeBody(other.getBody());
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        if (!hasCode()) {
          return false;
        }
        if (!hasMsg()) {
          return false;
        }
        if (!hasBody()) {
          return false;
        }
        if (!getBody().isInitialized()) {
          return false;
        }
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        RpcRespProto.RpcResp parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (RpcRespProto.RpcResp) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private Object code_ = "";
      /**
       * <code>required string code = 1;</code>
       */
      public boolean hasCode() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>required string code = 1;</code>
       */
      public String getCode() {
        Object ref = code_;
        if (!(ref instanceof String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          String s = bs.toStringUtf8();
          if (bs.isValidUtf8()) {
            code_ = s;
          }
          return s;
        } else {
          return (String) ref;
        }
      }
      /**
       * <code>required string code = 1;</code>
       */
      public com.google.protobuf.ByteString
          getCodeBytes() {
        Object ref = code_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8(
                  (String) ref);
          code_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>required string code = 1;</code>
       */
      public Builder setCode(
          String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        code_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required string code = 1;</code>
       */
      public Builder clearCode() {
        bitField0_ = (bitField0_ & ~0x00000001);
        code_ = getDefaultInstance().getCode();
        onChanged();
        return this;
      }
      /**
       * <code>required string code = 1;</code>
       */
      public Builder setCodeBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        code_ = value;
        onChanged();
        return this;
      }

      private Object msg_ = "";
      /**
       * <code>required string msg = 2;</code>
       */
      public boolean hasMsg() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
      }
      /**
       * <code>required string msg = 2;</code>
       */
      public String getMsg() {
        Object ref = msg_;
        if (!(ref instanceof String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          String s = bs.toStringUtf8();
          if (bs.isValidUtf8()) {
            msg_ = s;
          }
          return s;
        } else {
          return (String) ref;
        }
      }
      /**
       * <code>required string msg = 2;</code>
       */
      public com.google.protobuf.ByteString
          getMsgBytes() {
        Object ref = msg_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8(
                  (String) ref);
          msg_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>required string msg = 2;</code>
       */
      public Builder setMsg(
          String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        msg_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required string msg = 2;</code>
       */
      public Builder clearMsg() {
        bitField0_ = (bitField0_ & ~0x00000002);
        msg_ = getDefaultInstance().getMsg();
        onChanged();
        return this;
      }
      /**
       * <code>required string msg = 2;</code>
       */
      public Builder setMsgBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        msg_ = value;
        onChanged();
        return this;
      }

      private OrderMainProto.OrderMain body_ = null;
      private com.google.protobuf.SingleFieldBuilderV3<
          OrderMainProto.OrderMain, OrderMainProto.OrderMain.Builder, OrderMainProto.OrderMainOrBuilder> bodyBuilder_;
      /**
       * <code>required .proto.OrderMain body = 3;</code>
       */
      public boolean hasBody() {
        return ((bitField0_ & 0x00000004) == 0x00000004);
      }
      /**
       * <code>required .proto.OrderMain body = 3;</code>
       */
      public OrderMainProto.OrderMain getBody() {
        if (bodyBuilder_ == null) {
          return body_ == null ? OrderMainProto.OrderMain.getDefaultInstance() : body_;
        } else {
          return bodyBuilder_.getMessage();
        }
      }
      /**
       * <code>required .proto.OrderMain body = 3;</code>
       */
      public Builder setBody(OrderMainProto.OrderMain value) {
        if (bodyBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          body_ = value;
          onChanged();
        } else {
          bodyBuilder_.setMessage(value);
        }
        bitField0_ |= 0x00000004;
        return this;
      }
      /**
       * <code>required .proto.OrderMain body = 3;</code>
       */
      public Builder setBody(
          OrderMainProto.OrderMain.Builder builderForValue) {
        if (bodyBuilder_ == null) {
          body_ = builderForValue.build();
          onChanged();
        } else {
          bodyBuilder_.setMessage(builderForValue.build());
        }
        bitField0_ |= 0x00000004;
        return this;
      }
      /**
       * <code>required .proto.OrderMain body = 3;</code>
       */
      public Builder mergeBody(OrderMainProto.OrderMain value) {
        if (bodyBuilder_ == null) {
          if (((bitField0_ & 0x00000004) == 0x00000004) &&
              body_ != null &&
              body_ != OrderMainProto.OrderMain.getDefaultInstance()) {
            body_ =
              OrderMainProto.OrderMain.newBuilder(body_).mergeFrom(value).buildPartial();
          } else {
            body_ = value;
          }
          onChanged();
        } else {
          bodyBuilder_.mergeFrom(value);
        }
        bitField0_ |= 0x00000004;
        return this;
      }
      /**
       * <code>required .proto.OrderMain body = 3;</code>
       */
      public Builder clearBody() {
        if (bodyBuilder_ == null) {
          body_ = null;
          onChanged();
        } else {
          bodyBuilder_.clear();
        }
        bitField0_ = (bitField0_ & ~0x00000004);
        return this;
      }
      /**
       * <code>required .proto.OrderMain body = 3;</code>
       */
      public OrderMainProto.OrderMain.Builder getBodyBuilder() {
        bitField0_ |= 0x00000004;
        onChanged();
        return getBodyFieldBuilder().getBuilder();
      }
      /**
       * <code>required .proto.OrderMain body = 3;</code>
       */
      public OrderMainProto.OrderMainOrBuilder getBodyOrBuilder() {
        if (bodyBuilder_ != null) {
          return bodyBuilder_.getMessageOrBuilder();
        } else {
          return body_ == null ?
              OrderMainProto.OrderMain.getDefaultInstance() : body_;
        }
      }
      /**
       * <code>required .proto.OrderMain body = 3;</code>
       */
      private com.google.protobuf.SingleFieldBuilderV3<
          OrderMainProto.OrderMain, OrderMainProto.OrderMain.Builder, OrderMainProto.OrderMainOrBuilder>
          getBodyFieldBuilder() {
        if (bodyBuilder_ == null) {
          bodyBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
              OrderMainProto.OrderMain, OrderMainProto.OrderMain.Builder, OrderMainProto.OrderMainOrBuilder>(
                  getBody(),
                  getParentForChildren(),
                  isClean());
          body_ = null;
        }
        return bodyBuilder_;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:proto.RpcResp)
    }

    // @@protoc_insertion_point(class_scope:proto.RpcResp)
    private static final RpcRespProto.RpcResp DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new RpcRespProto.RpcResp();
    }

    public static RpcRespProto.RpcResp getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    @Deprecated public static final com.google.protobuf.Parser<RpcResp>
        PARSER = new com.google.protobuf.AbstractParser<RpcResp>() {
      public RpcResp parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new RpcResp(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<RpcResp> parser() {
      return PARSER;
    }

    @Override
    public com.google.protobuf.Parser<RpcResp> getParserForType() {
      return PARSER;
    }

    public RpcRespProto.RpcResp getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_proto_RpcResp_descriptor;
  private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_proto_RpcResp_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\rRpcResp.proto\022\005proto\032\017OrderMain.proto\"" +
      "D\n\007RpcResp\022\014\n\004code\030\001 \002(\t\022\013\n\003msg\030\002 \002(\t\022\036\n" +
      "\004body\030\003 \002(\0132\020.proto.OrderMainB%\n\025com.laz" +
      "y.demo.io.pojoB\014RpcRespProto"
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
          OrderMainProto.getDescriptor(),
        }, assigner);
    internal_static_proto_RpcResp_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_proto_RpcResp_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_proto_RpcResp_descriptor,
        new String[] { "Code", "Msg", "Body", });
    OrderMainProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}