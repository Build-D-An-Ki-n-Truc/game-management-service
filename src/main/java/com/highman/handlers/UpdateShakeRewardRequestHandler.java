package com.highman.handlers;

import com.google.gson.JsonObject;
import grpc.*;

public class UpdateShakeRewardRequestHandler implements RequestHandlerBase{
    private final String ERROR_MSG = "Request has invalid structure";

    @Override
    public JsonObject handle(JsonObject requestJson, GameManagementServiceGrpc.GameManagementServiceBlockingStub grpcStub) {
        JsonObject responsePayload = new JsonObject();

        if (requestJson.has("gameId") && requestJson.has("userId") && requestJson.has("rewardId")) {
            GameManagementShakeRewardRequest request = GameManagementShakeRewardRequest.newBuilder()
                    .setGameId(requestJson.get("gameId").getAsString())
                    .setUserId(requestJson.get("userId").getAsString())
                    .setRewardId(requestJson.get("rewardId").getAsString())
                    .build();

            GameManagementShakeRewardResponse response = grpcStub.updateShakeReward(request);
            responsePayload.addProperty("finished", response.getFinished());
            responsePayload.addProperty("message", response.getMessage());
        }
        else {
            responsePayload.addProperty("finished", false);
            responsePayload.addProperty("message", ERROR_MSG);
        }

        return responsePayload;
    }

    @Override
    public String getEndpointName() {
        return "updateShakeReward";
    }
}
