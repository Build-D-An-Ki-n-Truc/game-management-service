package com.highman.handlers;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import grpc.*;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class AddRequestHandler implements RequestHandlerBase{
    private final String ERROR_MSG = "Request has invalid structure";

    @Override
    public JsonObject handle(JsonObject requestJson, GameManagementServiceGrpc.GameManagementServiceBlockingStub grpcStub) {
        JsonObject responsePayload = new JsonObject();

        if (requestJson.has("name") && requestJson.has("image") && requestJson.has("type") && requestJson.has("alloweditemtrade") && requestJson.has("tutorial") && requestJson.has("startTime") && requestJson.has("endTime") && requestJson.has("maxPlayers") && requestJson.has("duration") && requestJson.has("questions")) {

            ArrayList<GameManagementQuestion> gameManagementQuestions = new ArrayList<>();
            for (JsonElement questionJsonElement: requestJson.getAsJsonArray("questions")) {
                GameManagementQuestion.Builder gameManagementQuestion = GameManagementQuestion.newBuilder();

                JsonObject questionJsonObject = questionJsonElement.getAsJsonObject();
                String text = questionJsonObject.get("text").getAsString();
                Gson gson = new Gson();
                Type type = new TypeToken<ArrayList<String>>(){}.getType();
                ArrayList<String> options = gson.fromJson(questionJsonObject.getAsJsonArray("options"), type);
                int correctAnswer = questionJsonObject.get("correctAnswer").getAsInt();

                gameManagementQuestions.add(gameManagementQuestion.setText(text)
                        .setCorrectAnswer(correctAnswer)
                        .addAllOptions(options)
                        .build());
            }

            GameManagementAddRequest request = GameManagementAddRequest.newBuilder()
                    .setName(requestJson.get("name").getAsString())
                    .setImage(requestJson.get("image").getAsString())
                    .setType(requestJson.get("type").getAsString())
                    .setStatus("NotStarted")
                    .setAllowedItemTrade(requestJson.get("alloweditemtrade").getAsBoolean())
                    .setTutorial(requestJson.get("tutorial").getAsString())
                    .setStartTime(requestJson.get("startTime").getAsLong())
                    .setEndTime(requestJson.get("endTime").getAsLong())
                    .setMaxPlayers(requestJson.get("maxPlayers").getAsInt())
                    .setDuration(requestJson.get("duration").getAsInt())
                    .addAllQuestions(gameManagementQuestions)
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
        return "add";
    }
}
