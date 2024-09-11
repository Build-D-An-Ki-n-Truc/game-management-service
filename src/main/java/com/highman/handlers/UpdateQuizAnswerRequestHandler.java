package com.highman.handlers;

import com.google.gson.JsonObject;
import grpc.*;

public class UpdateQuizAnswerRequestHandler implements RequestHandlerBase{
    private final String ERROR_MSG = "Request has invalid structure";

    @Override
    public JsonObject handle(JsonObject requestJson, GameManagementServiceGrpc.GameManagementServiceBlockingStub grpcStub) {
        JsonObject responsePayload = new JsonObject();

        if (requestJson.has("gameId") && requestJson.has("userId") && requestJson.has("score")) {
            GameManagementQuizAnswerRequest request = GameManagementQuizAnswerRequest.newBuilder()
                    .setGameId(requestJson.get("gameId").getAsString())
                    .setUserId(requestJson.get("userId").getAsString())
                    .setScore(requestJson.get("score").getAsFloat())
                    .build();

            GameManagementQuizAnswerResponse response = grpcStub.updateQuizAnswers(request);
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
        return "updateQuizAnswer";
    }
}
