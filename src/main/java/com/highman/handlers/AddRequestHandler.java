package com.highman.handlers;

import com.google.gson.JsonObject;
import grpc.*;

public class AddRequestHandler implements RequestHandlerBase{
    private final String ERROR_MSG = "Response returns null or request has invalid structure";

    @Override
    public JsonObject handle(JsonObject requestJson, GameManagementServiceGrpc.GameManagementServiceBlockingStub grpcStub) {
        JsonObject responsePayload = new JsonObject();

        if (requestJson.has("id") && requestJson.has("name") && requestJson.has("image") && requestJson.has("type") && requestJson.has("alloweditemtrade") && requestJson.has("tutorial") && requestJson.has("startTime") && requestJson.has("endTime") && requestJson.has("maxPlayers") && requestJson.has("duration")) {
            GameManagementAddRequest request = GameManagementAddRequest.newBuilder()
                    .setId(requestJson.get("id").getAsString())
                    .setName(requestJson.get("name").getAsString())
                    .setImage(requestJson.get("image").getAsString())
                    .setType(requestJson.get("type").getAsString())
                    .setAllowedItemTrade(requestJson.get("alloweditemtrade").getAsBoolean())
                    .setTutorial(requestJson.get("tutorial").getAsString())
                    .setStartTime(requestJson.get("startTime").getAsLong())
                    .setEndTime(requestJson.get("endTime").getAsLong())
                    .setMaxPlayers(requestJson.get("maxPlayers").getAsInt())
                    .setDuration(requestJson.get("duration").getAsInt())
                    .build();

            GameManagementResponse response = grpcStub.add(request);
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
        return "create";
    }
}
