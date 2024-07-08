@echo off

protoc -I=src/main/proto/ --java_out=src/main/java/ --grpc_java_out=src/main/java/ src/main/proto/service.proto
echo "Grpc class files generated."