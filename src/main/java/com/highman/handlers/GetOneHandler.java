package com.highman.handlers;

import com.google.gson.*;
import grpc.*;

import java.util.ArrayList;
import java.util.HashMap;

public class GetOneHandler implements RequestHandlerBase{
    private final String ERROR_MSG = "Request has invalid structure";

    @Override
    public JsonObject handle(JsonObject requestJson, GameManagementServiceGrpc.GameManagementServiceBlockingStub grpcStub) {
        JsonObject responsePayload = new JsonObject();

        if (requestJson.has("gameId")) {
            GameManagementGetRequest request = GameManagementGetRequest.newBuilder().setGameId(requestJson.get("gameId").getAsString()).build();

            GameManagementGetResponse response = grpcStub.getOne(request);
            if (response.getId().isEmpty()) {
                responsePayload.addProperty("finished", false);
                responsePayload.addProperty("message", ERROR_MSG);
                responsePayload.add("data", JsonParser.parseString(new Gson().toJson(new HashMap<>())));
            }
            else {
                responsePayload.addProperty("finished", response.getFinished());
                responsePayload.addProperty("message", response.getMessage());
                Gson gson = new GsonBuilder().setFieldNamingStrategy(f -> {
                    String fieldName =
                            FieldNamingPolicy.IDENTITY.translateName(f);
                    if (fieldName.endsWith("_")) {
                        fieldName = fieldName.substring(0, fieldName.length() - 1);
                    }
                    return fieldName;
                }).create();

                JsonObject responseData = new JsonObject();
                responseData.addProperty("_id", response.getId());
                responseData.addProperty("name", response.getName());
                responseData.addProperty("image", response.getImage());
                responseData.addProperty("type", response.getType());
                responseData.addProperty("allowedItemTrade", response.getAllowedItemTrade());
                responseData.addProperty("tutorial", response.getTutorial());
                responseData.addProperty("status", response.getStatus());
                responseData.addProperty("startTime", response.getStartTime());
                responseData.addProperty("endTime", response.getEndTime());
                responseData.addProperty("maxPlayers", response.getMaxPlayers());
                responseData.addProperty("duration", response.getDuration());
                responseData.addProperty("eventId", response.getEventId());
                responsePayload.add("data", JsonParser.parseString(gson.toJson(responseData)));
            }
        }
        else {
            responsePayload.addProperty("finished", false);
            responsePayload.addProperty("message", ERROR_MSG);
            responsePayload.add("data", JsonParser.parseString(new Gson().toJson(new HashMap<>())));
        }

        return responsePayload;
    }

    @Override
    public String getEndpointName() {
        return "getOne";
    }
}
