package com.highman.handlers;

import com.google.gson.JsonObject;
import grpc.GameManagementInfoRequest;
import grpc.GameManagementResponse;
import grpc.GameManagementServiceGrpc;
import grpc.GameManagementStatusRequest;

public class UpdateStatusRequestHandler implements RequestHandlerBase{
    private final String ERROR_MSG = "Response returns null or has invalid structure";

    @Override
    public JsonObject handle(JsonObject requestJson, GameManagementServiceGrpc.GameManagementServiceBlockingStub grpcStub) {
        JsonObject responsePayload = new JsonObject();

        if (requestJson.has("id") && requestJson.has("status")) {
            GameManagementStatusRequest request = GameManagementStatusRequest.newBuilder()
                    .setId(requestJson.get("id").getAsString())
                    .setStatus(requestJson.get("status").getAsString())
                    .build();

            GameManagementResponse response = grpcStub.updateStatus(request);
            responsePayload.addProperty("finished", response.getFinished());
            responsePayload.addProperty("message", response.getMessage());
        } else {
            responsePayload.addProperty("finished", false);
            responsePayload.addProperty("message", ERROR_MSG);
        }

        return responsePayload;
    }

    @Override
    public String getEndpointName() {
        return "updateStatus";
    }
}
