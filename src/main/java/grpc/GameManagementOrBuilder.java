// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: service.proto
// Protobuf Java Version: 4.27.2

package grpc;

public interface GameManagementOrBuilder extends
    // @@protoc_insertion_point(interface_extends:grpc.GameManagement)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string id = 1;</code>
   * @return The id.
   */
  java.lang.String getId();
  /**
   * <code>string id = 1;</code>
   * @return The bytes for id.
   */
  com.google.protobuf.ByteString
      getIdBytes();

  /**
   * <code>string name = 2;</code>
   * @return The name.
   */
  java.lang.String getName();
  /**
   * <code>string name = 2;</code>
   * @return The bytes for name.
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <code>string image = 3;</code>
   * @return The image.
   */
  java.lang.String getImage();
  /**
   * <code>string image = 3;</code>
   * @return The bytes for image.
   */
  com.google.protobuf.ByteString
      getImageBytes();

  /**
   * <code>string type = 4;</code>
   * @return The type.
   */
  java.lang.String getType();
  /**
   * <code>string type = 4;</code>
   * @return The bytes for type.
   */
  com.google.protobuf.ByteString
      getTypeBytes();

  /**
   * <code>bool allowedItemTrade = 5;</code>
   * @return The allowedItemTrade.
   */
  boolean getAllowedItemTrade();

  /**
   * <code>string tutorial = 6;</code>
   * @return The tutorial.
   */
  java.lang.String getTutorial();
  /**
   * <code>string tutorial = 6;</code>
   * @return The bytes for tutorial.
   */
  com.google.protobuf.ByteString
      getTutorialBytes();

  /**
   * <code>int32 status = 7;</code>
   * @return The status.
   */
  int getStatus();
}
