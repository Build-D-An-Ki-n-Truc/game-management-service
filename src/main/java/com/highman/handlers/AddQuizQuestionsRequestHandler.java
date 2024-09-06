package com.highman.handlers;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import grpc.*;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class AddQuizQuestionsRequestHandler implements RequestHandlerBase{
    private final String ERROR_MSG = "Request has invalid structure";

    @Override
    public JsonObject handle(JsonObject requestJson, GameManagementServiceGrpc.GameManagementServiceBlockingStub grpcStub) {
        JsonObject responsePayload = new JsonObject();

        if (requestJson.has("gameId") && requestJson.has("questions")) {
            ArrayList<GameManagementQuestion> gameManagementQuestions = new ArrayList<>();
            for (JsonElement questionJsonElement: requestJson.getAsJsonArray("questions")) {
                GameManagementQuestion.Builder gameManagementQuestion = GameManagementQuestion.newBuilder();

                JsonObject questionJsonObject = questionJsonElement.getAsJsonObject();
                String text = questionJsonObject.get("text").getAsString();
                Gson gson = new Gson();
                Type type = new TypeToken<ArrayList<String>>(){}.getType();
                ArrayList<String> options = gson.fromJson(questionJsonObject.getAsJsonArray("options"), type);
                int correctAnswer = questionJsonObject.get("correctAnswer").getAsInt();
                int timeLimit = questionJsonObject.get("timeLimit").getAsInt();

                gameManagementQuestions.add(gameManagementQuestion.setText(text)
                        .setCorrectAnswer(correctAnswer)
                        .addAllOptions(options)
                        .setTimeLimit(timeLimit)
                        .build());
            }

            GameManagementAddQuizQuestionsRequest request = GameManagementAddQuizQuestionsRequest.newBuilder()
                    .setGameId(requestJson.get("gameId").getAsString())
                    .addAllQuestions(gameManagementQuestions)
                    .build();

            GameManagementAddQuizQuestionsResponse response = grpcStub.addQuizQuestions(request);
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
        return "addQuizQuestions";
    }
}
