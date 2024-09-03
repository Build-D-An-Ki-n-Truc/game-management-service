package com.highman.handlers;

import com.google.gson.*;
import grpc.*;

import java.util.ArrayList;

public class GetQuizQuestionsHandler implements RequestHandlerBase{
    private final String ERROR_MSG = "Request has invalid structure";

    @Override
    public JsonObject handle(JsonObject requestJson, GameManagementServiceGrpc.GameManagementServiceBlockingStub grpcStub) {
        JsonObject responsePayload = new JsonObject();

        if (requestJson.has("gameId")) {
            GameManagementQuizQuestionsRequest request = GameManagementQuizQuestionsRequest.newBuilder().setGameId(requestJson.get("gameId").getAsString()).build();

            GameManagementQuizQuestionsResponse response = grpcStub.getQuizQuestions(request);
            responsePayload.addProperty("finished", response.getFinished());
            responsePayload.addProperty("message", response.getMessage());
            if (response.getQuestionsList().isEmpty())
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

                responsePayload.add("data", JsonParser.parseString(gson.toJson(response.getQuestionsList())));
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
        return "getQuizQuestions";
    }
}
