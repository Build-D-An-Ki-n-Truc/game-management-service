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

        if (requestJson.has("gameId") && requestJson.has("userId") && requestJson.has("shakeRand") && requestJson.has("shakeAccumulate")) {
            GameManagementShakeRequest request = GameManagementShakeRequest.newBuilder()
                    .setGameId(requestJson.get("gameId").getAsString())
                    .setUserId(requestJson.get("userId").getAsString())
                    .setShakeRand(requestJson.get("shakeRand").getAsInt())
                    .setShakeAccumulate(requestJson.get("shakeAccumulate").getAsInt())
                    .build();

            GameManagementShakeResponse response = grpcStub.shake(request);
            responsePayload.addProperty("finished", response.getFinished());
            responsePayload.addProperty("message", response.getMessage());
            responsePayload.addProperty("finalResult", response.getFinalResult());
        }
        else {
            responsePayload.addProperty("finished", false);
            responsePayload.addProperty("message", ERROR_MSG);
            responsePayload.addProperty("finalResult", -1);
        }

        return responsePayload;
    }

    @Override
    public String getEndpointName() {
        return "shake";
    }
}
