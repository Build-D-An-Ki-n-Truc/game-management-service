// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: service.proto
// Protobuf Java Version: 4.27.2

package grpc;

public interface GameManagementShakeRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:grpc.GameManagementShakeRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string userId = 1;</code>
   * @return The userId.
   */
  java.lang.String getUserId();
  /**
   * <code>string userId = 1;</code>
   * @return The bytes for userId.
   */
  com.google.protobuf.ByteString
      getUserIdBytes();

  /**
   * <code>string gameId = 2;</code>
   * @return The gameId.
   */
  java.lang.String getGameId();
  /**
   * <code>string gameId = 2;</code>
   * @return The bytes for gameId.
   */
  com.google.protobuf.ByteString
      getGameIdBytes();

  /**
   * <code>int32 shakeRand = 3;</code>
   * @return The shakeRand.
   */
  int getShakeRand();

  /**
   * <code>int64 shakeAccumulate = 4;</code>
   * @return The shakeAccumulate.
   */
  long getShakeAccumulate();
}
