package com.highman.handlers;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import grpc.*;

public class GetAllRequestHandler implements RequestHandlerBase{
    @Override
    public JsonObject handle(JsonObject requestJson, GameManagementServiceGrpc.GameManagementServiceBlockingStub grpcStub) {
        JsonObject responsePayload = new JsonObject();

        GameManagementGetAllRequest request = GameManagementGetAllRequest.newBuilder().build();
        GameManagementGetAllResponse response = grpcStub.getAll(request);
        responsePayload.addProperty("finished", response.getFinished());
        responsePayload.addProperty("message", response.getMessage());
        if (response.getGamesList().isEmpty())
            responsePayload.addProperty("data", "{}");
        else
            responsePayload.add("data", JsonParser.parseString(new Gson().toJson(response.getGamesList())));

        return responsePayload;
    }

    @Override
    public String getEndpointName() {
        return "getAll";
    }
}
