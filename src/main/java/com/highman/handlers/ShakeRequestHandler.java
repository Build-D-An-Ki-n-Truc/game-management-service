package com.highman.handlers;

import com.google.gson.JsonObject;
import grpc.GameManagementServiceGrpc;
import grpc.GameManagementShakeRequest;
import grpc.GameManagementShakeResponse;

public class ShakeRequestHandler implements RequestHandlerBase{
    private final String ERROR_MSG = "Request has invalid structure";

    @Override
    public JsonObject handle(JsonObject requestJson, GameManagementServiceGrpc.GameManagementServiceBlockingStub grpcStub) {
        JsonObject responsePayload = new JsonObject();

        if (requestJson.has("id")) {
            GameManagementShakeRequest request = GameManagementShakeRequest.newBuilder()
                    .setId(requestJson.get("id").getAsString())
                    .build();

            GameManagementShakeResponse response = grpcStub.shake(request);
            responsePayload.addProperty("finished", response.getFinished());
            responsePayload.addProperty("message", response.getMessage());
            responsePayload.addProperty("shakeResult", response.getShakeResult());
        }
        else {
            responsePayload.addProperty("finished", false);
            responsePayload.addProperty("message", ERROR_MSG);
            responsePayload.addProperty("shakeResult", -1);
        }

        return responsePayload;
    }

    @Override
    public String getEndpointName() {
        return "shake";
    }
}
