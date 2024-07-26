package com.highman.handlers;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import grpc.*;

public class GetAllRequestHandler implements RequestHandlerBase{
    @Override
    public JsonObject handle(JsonObject requestJson, GameManagementServiceGrpc.GameManagementServiceBlockingStub grpcStub) {
        JsonObject responsePayload = new JsonObject();

        GameManagementGetAllRequest request = GameManagementGetAllRequest.newBuilder().build();

        GameManagementGetAllResponse response = grpcStub.getAll(request);
        responsePayload.addProperty("finished", true);
        responsePayload.addProperty("data", new Gson().toJson(response.getGamesList()));

        return responsePayload;
    }

    @Override
    public String getEndpointName() {
        return "getAll";
    }
}
