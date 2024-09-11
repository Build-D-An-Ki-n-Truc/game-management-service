package com.highman.handlers;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import grpc.*;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class UpdateQuizQuestionsRequestHandler implements RequestHandlerBase{
    private final String ERROR_MSG = "Request has invalid structure";
    private final String ERROR_MSG2 = "questionIndex and newQuestionInfo need to have same length";

    @Override
    public JsonObject handle(JsonObject requestJson, GameManagementServiceGrpc.GameManagementServiceBlockingStub grpcStub) {
        JsonObject responsePayload = new JsonObject();

        if (requestJson.has("gameId") && requestJson.has("questionIndex") && requestJson.has("newQuestionInfo")) {
            JsonArray newQuestionsInfo = requestJson.getAsJsonArray("newQuestionInfo");
            int index = 0;
            ArrayList<Integer> gameManagementQuestionsIndex = new ArrayList<>();
            ArrayList<GameManagementQuestion> gameManagementQuestions = new ArrayList<>();
            JsonArray questionsIndex = requestJson.getAsJsonArray("questionIndex");
            if (questionsIndex.size() == newQuestionsInfo.size()) {
                for (JsonElement questionJsonElement: newQuestionsInfo) {
                    gameManagementQuestionsIndex.add(questionsIndex.get(index).getAsInt());

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

                    index++;
                }

                GameManagementUpdateQuizQuestionsRequest request = GameManagementUpdateQuizQuestionsRequest.newBuilder()
                        .setGameId(requestJson.get("gameId").getAsString())
                        .addAllQuestionIndex(gameManagementQuestionsIndex)
                        .addAllNewQuestionInfo(gameManagementQuestions)
                        .build();

                GameManagementUpdateQuizQuestionsResponse response = grpcStub.updateQuizQuestions(request);
                responsePayload.addProperty("finished", response.getFinished());
                responsePayload.addProperty("message", response.getMessage());
            }
            else {
                responsePayload.addProperty("finished", false);
                responsePayload.addProperty("message", ERROR_MSG2);
            }
        }
        else {
            responsePayload.addProperty("finished", false);
            responsePayload.addProperty("message", ERROR_MSG);
        }

        return responsePayload;
    }

    @Override
    public String getEndpointName() {
        return "updateQuizQuestions";
    }
}
