package com.highman.handlers;

import com.google.gson.JsonObject;
import grpc.GameManagementServiceGrpc;
import io.nats.client.Connection;
import io.nats.client.Message;

public interface RequestHandlerBase {
    JsonObject handle(JsonObject requestJson, GameManagementServiceGrpc.GameManagementServiceBlockingStub grpcStub);

    String getEndpointName();
}
