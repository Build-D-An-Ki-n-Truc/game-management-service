package com.highman.handlers;

import com.google.gson.*;
import grpc.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class GetAllRequestHandler implements RequestHandlerBase{
    @Override
    public JsonObject handle(JsonObject requestJson, GameManagementServiceGrpc.GameManagementServiceBlockingStub grpcStub) {
        JsonObject responsePayload = new JsonObject();

        GameManagementGetAllRequest request = GameManagementGetAllRequest.newBuilder().build();
        GameManagementGetAllResponse response = grpcStub.getAll(request);
        responsePayload.addProperty("finished", response.getFinished());
        responsePayload.addProperty("message", response.getMessage());
        if (response.getGamesList().isEmpty())
            responsePayload.add("data", JsonParser.parseString(new Gson().toJson(new ArrayList<>())));
        else {
            Gson gson = new GsonBuilder().setFieldNamingStrategy(f -> {
                String fieldName =
                        FieldNamingPolicy.IDENTITY.translateName(f);
                if (fieldName.endsWith("_"))
                {
                    fieldName = fieldName.substring(0, fieldName.length() - 1);
                }
                return fieldName;
            }).create();

            responsePayload.add("data", JsonParser.parseString(gson.toJson(response.getGamesList())));
        }

        return responsePayload;
    }

    @Override
    public String getEndpointName() {
        return "getAll";
    }
}
