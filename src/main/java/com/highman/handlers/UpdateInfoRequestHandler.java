package com.highman.handlers;

import com.google.gson.JsonObject;
import grpc.GameManagementInfoRequest;
import grpc.GameManagementResponse;
import grpc.GameManagementServiceGrpc;
import io.nats.client.Connection;
import io.nats.client.Message;

public class UpdateInfoRequestHandler implements RequestHandlerBase{
    private final String ERROR_MSG = "Request has invalid structure";

    @Override
    public JsonObject handle(JsonObject requestJson, GameManagementServiceGrpc.GameManagementServiceBlockingStub grpcStub) {
        System.out.println(requestJson.has("id"));
        JsonObject responsePayload = new JsonObject();

        if (requestJson.has("id") && requestJson.has("name") && requestJson.has("image") && requestJson.has("type") && requestJson.has("alloweditemtrade") && requestJson.has("tutorial") && requestJson.has("startTime") && requestJson.has("endTime") && requestJson.has("maxPlayers") && requestJson.has("duration") && requestJson.has("eventId")) {
            GameManagementInfoRequest request = GameManagementInfoRequest.newBuilder()
                    .setId(requestJson.get("id").getAsString())
                    .setEventId(requestJson.get("eventId").getAsString())
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

            GameManagementResponse response = grpcStub.updateInfo(request);
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
        return "updateInfo";
    }
}
