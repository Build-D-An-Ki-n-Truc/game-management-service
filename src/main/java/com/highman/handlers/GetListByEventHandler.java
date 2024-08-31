package com.highman.handlers;

import com.google.gson.*;
import grpc.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class GetListByEventHandler implements RequestHandlerBase{
    private final String ERROR_MSG = "Request has invalid structure";

    @Override
    public JsonObject handle(JsonObject requestJson, GameManagementServiceGrpc.GameManagementServiceBlockingStub grpcStub) {
        JsonObject responsePayload = new JsonObject();

        if (requestJson.has("eventId")) {
            GameManagementGetListByEventRequest request = GameManagementGetListByEventRequest.newBuilder().setEventId(requestJson.get("eventId").getAsString()).build();

            GameManagementGetAllResponse response = grpcStub.getListByEvent(request);
            responsePayload.addProperty("finished", response.getFinished());
            responsePayload.addProperty("message", response.getMessage());
            if (response.getGamesList().isEmpty())
                responsePayload.add("data", JsonParser.parseString(new Gson().toJson(new ArrayList<>())));
            else {
                Gson gson = new GsonBuilder().setFieldNamingStrategy(f -> {
                    String fieldName =
                            FieldNamingPolicy.IDENTITY.translateName(f);
                    if (fieldName.endsWith("_")) {
                        fieldName = fieldName.substring(0, fieldName.length() - 1);
                    }
                    return fieldName;
                }).create();

                responsePayload.add("data", JsonParser.parseString(gson.toJson(response.getGamesList())));
            }
        }
        else {
            responsePayload.addProperty("finished", false);
            responsePayload.addProperty("message", ERROR_MSG);
            responsePayload.add("data", JsonParser.parseString(new Gson().toJson(new ArrayList<>())));
        }

        return responsePayload;
    }

    @Override
    public String getEndpointName() {
        return "getListByEvent";
    }
}
