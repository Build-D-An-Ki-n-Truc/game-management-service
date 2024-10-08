// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: service.proto
// Protobuf Java Version: 4.27.2

package grpc;

/**
 * Protobuf type {@code grpc.GameManagementQuizQuestionsResponse}
 */
public final class GameManagementQuizQuestionsResponse extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:grpc.GameManagementQuizQuestionsResponse)
    GameManagementQuizQuestionsResponseOrBuilder {
private static final long serialVersionUID = 0L;
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 27,
      /* patch= */ 2,
      /* suffix= */ "",
      GameManagementQuizQuestionsResponse.class.getName());
  }
  // Use GameManagementQuizQuestionsResponse.newBuilder() to construct.
  private GameManagementQuizQuestionsResponse(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
  }
  private GameManagementQuizQuestionsResponse() {
    message_ = "";
    questions_ = java.util.Collections.emptyList();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return grpc.Service.internal_static_grpc_GameManagementQuizQuestionsResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return grpc.Service.internal_static_grpc_GameManagementQuizQuestionsResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            grpc.GameManagementQuizQuestionsResponse.class, grpc.GameManagementQuizQuestionsResponse.Builder.class);
  }

  public static final int FINISHED_FIELD_NUMBER = 1;
  private boolean finished_ = false;
  /**
   * <code>bool finished = 1;</code>
   * @return The finished.
   */
  @java.lang.Override
  public boolean getFinished() {
    return finished_;
  }

  public static final int MESSAGE_FIELD_NUMBER = 2;
  @SuppressWarnings("serial")
  private volatile java.lang.Object message_ = "";
  /**
   * <code>string message = 2;</code>
   * @return The message.
   */
  @java.lang.Override
  public java.lang.String getMessage() {
    java.lang.Object ref = message_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      message_ = s;
      return s;
    }
  }
  /**
   * <code>string message = 2;</code>
   * @return The bytes for message.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getMessageBytes() {
    java.lang.Object ref = message_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      message_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int QUESTIONS_FIELD_NUMBER = 3;
  @SuppressWarnings("serial")
  private java.util.List<grpc.GameManagementQuestion> questions_;
  /**
   * <code>repeated .grpc.GameManagementQuestion questions = 3;</code>
   */
  @java.lang.Override
  public java.util.List<grpc.GameManagementQuestion> getQuestionsList() {
    return questions_;
  }
  /**
   * <code>repeated .grpc.GameManagementQuestion questions = 3;</code>
   */
  @java.lang.Override
  public java.util.List<? extends grpc.GameManagementQuestionOrBuilder> 
      getQuestionsOrBuilderList() {
    return questions_;
  }
  /**
   * <code>repeated .grpc.GameManagementQuestion questions = 3;</code>
   */
  @java.lang.Override
  public int getQuestionsCount() {
    return questions_.size();
  }
  /**
   * <code>repeated .grpc.GameManagementQuestion questions = 3;</code>
   */
  @java.lang.Override
  public grpc.GameManagementQuestion getQuestions(int index) {
    return questions_.get(index);
  }
  /**
   * <code>repeated .grpc.GameManagementQuestion questions = 3;</code>
   */
  @java.lang.Override
  public grpc.GameManagementQuestionOrBuilder getQuestionsOrBuilder(
      int index) {
    return questions_.get(index);
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (finished_ != false) {
      output.writeBool(1, finished_);
    }
    if (!com.google.protobuf.GeneratedMessage.isStringEmpty(message_)) {
      com.google.protobuf.GeneratedMessage.writeString(output, 2, message_);
    }
    for (int i = 0; i < questions_.size(); i++) {
      output.writeMessage(3, questions_.get(i));
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (finished_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(1, finished_);
    }
    if (!com.google.protobuf.GeneratedMessage.isStringEmpty(message_)) {
      size += com.google.protobuf.GeneratedMessage.computeStringSize(2, message_);
    }
    for (int i = 0; i < questions_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(3, questions_.get(i));
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof grpc.GameManagementQuizQuestionsResponse)) {
      return super.equals(obj);
    }
    grpc.GameManagementQuizQuestionsResponse other = (grpc.GameManagementQuizQuestionsResponse) obj;

    if (getFinished()
        != other.getFinished()) return false;
    if (!getMessage()
        .equals(other.getMessage())) return false;
    if (!getQuestionsList()
        .equals(other.getQuestionsList())) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + FINISHED_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getFinished());
    hash = (37 * hash) + MESSAGE_FIELD_NUMBER;
    hash = (53 * hash) + getMessage().hashCode();
    if (getQuestionsCount() > 0) {
      hash = (37 * hash) + QUESTIONS_FIELD_NUMBER;
      hash = (53 * hash) + getQuestionsList().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static grpc.GameManagementQuizQuestionsResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.GameManagementQuizQuestionsResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.GameManagementQuizQuestionsResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.GameManagementQuizQuestionsResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.GameManagementQuizQuestionsResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.GameManagementQuizQuestionsResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.GameManagementQuizQuestionsResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static grpc.GameManagementQuizQuestionsResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static grpc.GameManagementQuizQuestionsResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static grpc.GameManagementQuizQuestionsResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static grpc.GameManagementQuizQuestionsResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static grpc.GameManagementQuizQuestionsResponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(grpc.GameManagementQuizQuestionsResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessage.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code grpc.GameManagementQuizQuestionsResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:grpc.GameManagementQuizQuestionsResponse)
      grpc.GameManagementQuizQuestionsResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return grpc.Service.internal_static_grpc_GameManagementQuizQuestionsResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return grpc.Service.internal_static_grpc_GameManagementQuizQuestionsResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              grpc.GameManagementQuizQuestionsResponse.class, grpc.GameManagementQuizQuestionsResponse.Builder.class);
    }

    // Construct using grpc.GameManagementQuizQuestionsResponse.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      finished_ = false;
      message_ = "";
      if (questionsBuilder_ == null) {
        questions_ = java.util.Collections.emptyList();
      } else {
        questions_ = null;
        questionsBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000004);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return grpc.Service.internal_static_grpc_GameManagementQuizQuestionsResponse_descriptor;
    }

    @java.lang.Override
    public grpc.GameManagementQuizQuestionsResponse getDefaultInstanceForType() {
      return grpc.GameManagementQuizQuestionsResponse.getDefaultInstance();
    }

    @java.lang.Override
    public grpc.GameManagementQuizQuestionsResponse build() {
      grpc.GameManagementQuizQuestionsResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public grpc.GameManagementQuizQuestionsResponse buildPartial() {
      grpc.GameManagementQuizQuestionsResponse result = new grpc.GameManagementQuizQuestionsResponse(this);
      buildPartialRepeatedFields(result);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartialRepeatedFields(grpc.GameManagementQuizQuestionsResponse result) {
      if (questionsBuilder_ == null) {
        if (((bitField0_ & 0x00000004) != 0)) {
          questions_ = java.util.Collections.unmodifiableList(questions_);
          bitField0_ = (bitField0_ & ~0x00000004);
        }
        result.questions_ = questions_;
      } else {
        result.questions_ = questionsBuilder_.build();
      }
    }

    private void buildPartial0(grpc.GameManagementQuizQuestionsResponse result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.finished_ = finished_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.message_ = message_;
      }
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof grpc.GameManagementQuizQuestionsResponse) {
        return mergeFrom((grpc.GameManagementQuizQuestionsResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(grpc.GameManagementQuizQuestionsResponse other) {
      if (other == grpc.GameManagementQuizQuestionsResponse.getDefaultInstance()) return this;
      if (other.getFinished() != false) {
        setFinished(other.getFinished());
      }
      if (!other.getMessage().isEmpty()) {
        message_ = other.message_;
        bitField0_ |= 0x00000002;
        onChanged();
      }
      if (questionsBuilder_ == null) {
        if (!other.questions_.isEmpty()) {
          if (questions_.isEmpty()) {
            questions_ = other.questions_;
            bitField0_ = (bitField0_ & ~0x00000004);
          } else {
            ensureQuestionsIsMutable();
            questions_.addAll(other.questions_);
          }
          onChanged();
        }
      } else {
        if (!other.questions_.isEmpty()) {
          if (questionsBuilder_.isEmpty()) {
            questionsBuilder_.dispose();
            questionsBuilder_ = null;
            questions_ = other.questions_;
            bitField0_ = (bitField0_ & ~0x00000004);
            questionsBuilder_ = 
              com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders ?
                 getQuestionsFieldBuilder() : null;
          } else {
            questionsBuilder_.addAllMessages(other.questions_);
          }
        }
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 8: {
              finished_ = input.readBool();
              bitField0_ |= 0x00000001;
              break;
            } // case 8
            case 18: {
              message_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000002;
              break;
            } // case 18
            case 26: {
              grpc.GameManagementQuestion m =
                  input.readMessage(
                      grpc.GameManagementQuestion.parser(),
                      extensionRegistry);
              if (questionsBuilder_ == null) {
                ensureQuestionsIsMutable();
                questions_.add(m);
              } else {
                questionsBuilder_.addMessage(m);
              }
              break;
            } // case 26
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private boolean finished_ ;
    /**
     * <code>bool finished = 1;</code>
     * @return The finished.
     */
    @java.lang.Override
    public boolean getFinished() {
      return finished_;
    }
    /**
     * <code>bool finished = 1;</code>
     * @param value The finished to set.
     * @return This builder for chaining.
     */
    public Builder setFinished(boolean value) {

      finished_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>bool finished = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearFinished() {
      bitField0_ = (bitField0_ & ~0x00000001);
      finished_ = false;
      onChanged();
      return this;
    }

    private java.lang.Object message_ = "";
    /**
     * <code>string message = 2;</code>
     * @return The message.
     */
    public java.lang.String getMessage() {
      java.lang.Object ref = message_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        message_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string message = 2;</code>
     * @return The bytes for message.
     */
    public com.google.protobuf.ByteString
        getMessageBytes() {
      java.lang.Object ref = message_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        message_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string message = 2;</code>
     * @param value The message to set.
     * @return This builder for chaining.
     */
    public Builder setMessage(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      message_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>string message = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearMessage() {
      message_ = getDefaultInstance().getMessage();
      bitField0_ = (bitField0_ & ~0x00000002);
      onChanged();
      return this;
    }
    /**
     * <code>string message = 2;</code>
     * @param value The bytes for message to set.
     * @return This builder for chaining.
     */
    public Builder setMessageBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      message_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }

    private java.util.List<grpc.GameManagementQuestion> questions_ =
      java.util.Collections.emptyList();
    private void ensureQuestionsIsMutable() {
      if (!((bitField0_ & 0x00000004) != 0)) {
        questions_ = new java.util.ArrayList<grpc.GameManagementQuestion>(questions_);
        bitField0_ |= 0x00000004;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilder<
        grpc.GameManagementQuestion, grpc.GameManagementQuestion.Builder, grpc.GameManagementQuestionOrBuilder> questionsBuilder_;

    /**
     * <code>repeated .grpc.GameManagementQuestion questions = 3;</code>
     */
    public java.util.List<grpc.GameManagementQuestion> getQuestionsList() {
      if (questionsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(questions_);
      } else {
        return questionsBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .grpc.GameManagementQuestion questions = 3;</code>
     */
    public int getQuestionsCount() {
      if (questionsBuilder_ == null) {
        return questions_.size();
      } else {
        return questionsBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .grpc.GameManagementQuestion questions = 3;</code>
     */
    public grpc.GameManagementQuestion getQuestions(int index) {
      if (questionsBuilder_ == null) {
        return questions_.get(index);
      } else {
        return questionsBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .grpc.GameManagementQuestion questions = 3;</code>
     */
    public Builder setQuestions(
        int index, grpc.GameManagementQuestion value) {
      if (questionsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureQuestionsIsMutable();
        questions_.set(index, value);
        onChanged();
      } else {
        questionsBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .grpc.GameManagementQuestion questions = 3;</code>
     */
    public Builder setQuestions(
        int index, grpc.GameManagementQuestion.Builder builderForValue) {
      if (questionsBuilder_ == null) {
        ensureQuestionsIsMutable();
        questions_.set(index, builderForValue.build());
        onChanged();
      } else {
        questionsBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .grpc.GameManagementQuestion questions = 3;</code>
     */
    public Builder addQuestions(grpc.GameManagementQuestion value) {
      if (questionsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureQuestionsIsMutable();
        questions_.add(value);
        onChanged();
      } else {
        questionsBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .grpc.GameManagementQuestion questions = 3;</code>
     */
    public Builder addQuestions(
        int index, grpc.GameManagementQuestion value) {
      if (questionsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureQuestionsIsMutable();
        questions_.add(index, value);
        onChanged();
      } else {
        questionsBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .grpc.GameManagementQuestion questions = 3;</code>
     */
    public Builder addQuestions(
        grpc.GameManagementQuestion.Builder builderForValue) {
      if (questionsBuilder_ == null) {
        ensureQuestionsIsMutable();
        questions_.add(builderForValue.build());
        onChanged();
      } else {
        questionsBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .grpc.GameManagementQuestion questions = 3;</code>
     */
    public Builder addQuestions(
        int index, grpc.GameManagementQuestion.Builder builderForValue) {
      if (questionsBuilder_ == null) {
        ensureQuestionsIsMutable();
        questions_.add(index, builderForValue.build());
        onChanged();
      } else {
        questionsBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .grpc.GameManagementQuestion questions = 3;</code>
     */
    public Builder addAllQuestions(
        java.lang.Iterable<? extends grpc.GameManagementQuestion> values) {
      if (questionsBuilder_ == null) {
        ensureQuestionsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, questions_);
        onChanged();
      } else {
        questionsBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .grpc.GameManagementQuestion questions = 3;</code>
     */
    public Builder clearQuestions() {
      if (questionsBuilder_ == null) {
        questions_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000004);
        onChanged();
      } else {
        questionsBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .grpc.GameManagementQuestion questions = 3;</code>
     */
    public Builder removeQuestions(int index) {
      if (questionsBuilder_ == null) {
        ensureQuestionsIsMutable();
        questions_.remove(index);
        onChanged();
      } else {
        questionsBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .grpc.GameManagementQuestion questions = 3;</code>
     */
    public grpc.GameManagementQuestion.Builder getQuestionsBuilder(
        int index) {
      return getQuestionsFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .grpc.GameManagementQuestion questions = 3;</code>
     */
    public grpc.GameManagementQuestionOrBuilder getQuestionsOrBuilder(
        int index) {
      if (questionsBuilder_ == null) {
        return questions_.get(index);  } else {
        return questionsBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .grpc.GameManagementQuestion questions = 3;</code>
     */
    public java.util.List<? extends grpc.GameManagementQuestionOrBuilder> 
         getQuestionsOrBuilderList() {
      if (questionsBuilder_ != null) {
        return questionsBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(questions_);
      }
    }
    /**
     * <code>repeated .grpc.GameManagementQuestion questions = 3;</code>
     */
    public grpc.GameManagementQuestion.Builder addQuestionsBuilder() {
      return getQuestionsFieldBuilder().addBuilder(
          grpc.GameManagementQuestion.getDefaultInstance());
    }
    /**
     * <code>repeated .grpc.GameManagementQuestion questions = 3;</code>
     */
    public grpc.GameManagementQuestion.Builder addQuestionsBuilder(
        int index) {
      return getQuestionsFieldBuilder().addBuilder(
          index, grpc.GameManagementQuestion.getDefaultInstance());
    }
    /**
     * <code>repeated .grpc.GameManagementQuestion questions = 3;</code>
     */
    public java.util.List<grpc.GameManagementQuestion.Builder> 
         getQuestionsBuilderList() {
      return getQuestionsFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilder<
        grpc.GameManagementQuestion, grpc.GameManagementQuestion.Builder, grpc.GameManagementQuestionOrBuilder> 
        getQuestionsFieldBuilder() {
      if (questionsBuilder_ == null) {
        questionsBuilder_ = new com.google.protobuf.RepeatedFieldBuilder<
            grpc.GameManagementQuestion, grpc.GameManagementQuestion.Builder, grpc.GameManagementQuestionOrBuilder>(
                questions_,
                ((bitField0_ & 0x00000004) != 0),
                getParentForChildren(),
                isClean());
        questions_ = null;
      }
      return questionsBuilder_;
    }

    // @@protoc_insertion_point(builder_scope:grpc.GameManagementQuizQuestionsResponse)
  }

  // @@protoc_insertion_point(class_scope:grpc.GameManagementQuizQuestionsResponse)
  private static final grpc.GameManagementQuizQuestionsResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new grpc.GameManagementQuizQuestionsResponse();
  }

  public static grpc.GameManagementQuizQuestionsResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GameManagementQuizQuestionsResponse>
      PARSER = new com.google.protobuf.AbstractParser<GameManagementQuizQuestionsResponse>() {
    @java.lang.Override
    public GameManagementQuizQuestionsResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<GameManagementQuizQuestionsResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<GameManagementQuizQuestionsResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public grpc.GameManagementQuizQuestionsResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

