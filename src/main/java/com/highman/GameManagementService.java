package com.highman;

import com.google.gson.Gson;
import com.highman.cron.GameStatusUpdateScheduler;
import com.highman.models.DBConnectionPool;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import com.mongodb.reactivestreams.client.MongoCollection;
import com.mongodb.reactivestreams.client.MongoDatabase;
import grpc.*;
import io.grpc.stub.StreamObserver;
import org.apache.logging.log4j.LogManager;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.quartz.SchedulerException;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import static com.mongodb.client.model.Filters.all;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;

public class GameManagementService extends GameManagementServiceGrpc.GameManagementServiceImplBase {
    MongoClient mongoClient;
    MongoCollection<Document> gameColl;

    public GameManagementService() {
        try {
            mongoClient = MongoClients.create(System.getenv("MONGO_URI"));
            MongoDatabase mongoDatabase = mongoClient.getDatabase("game_service");
            gameColl = mongoDatabase.getCollection("games");

//            printOneDocument("669a8089bf71b13349b55968");
            printAllDocuments();
            setUpGameScheduler();
        } catch (Exception e) {
            String error = "An error has occured while retrieving database connection: " + e.getMessage();
            e.printStackTrace();
        }
    }

    // UPDATE
    @Override
    public void updateInfo(GameManagementInfoRequest request, StreamObserver<GameManagementResponse> responseObserver) {
        GameManagementResponse.Builder response = GameManagementResponse.newBuilder();

        try {
            // Find the game by its id and update its info
            Publisher<UpdateResult> publisher = gameColl.updateOne(
                    eq("_id", new ObjectId(request.getId())),
                    combine(
                            set("name", request.getName()),
                            set("image", request.getImage()),
                            set("type", request.getType()),
                            set("allowedItemTrade", request.getAllowedItemTrade()),
                            set("tutorial", request.getTutorial()),
                            set("startTime", new Date(request.getStartTime())),
                            set("endTime", new Date(request.getEndTime())),
                            set("config.maxPlayers", request.getMaxPlayers()),
                            set("config.duration", request.getDuration())
                    )
            );

            // Perform update
            Mono.from(publisher)
                    .publishOn(Schedulers.boundedElastic())
                    .subscribe(
                            updateResult -> {
                                String msg = "Game info update complete.";
                                System.out.println(msg);

                                response.setFinished(true);
                                response.setMessage(msg);
                                responseObserver.onNext(response.build());
                                responseObserver.onCompleted();
                            },
                            throwable -> {
                                throwable.printStackTrace();

                                response.setFinished(false);
                                response.setMessage("Failed to update document");
                                responseObserver.onNext(response.build());
                                responseObserver.onCompleted();
                            }
                    );
        } catch (Exception e) {
            // Error message
            e.printStackTrace();

            response.setFinished(false);
            response.setMessage("Error while updating game info");
            responseObserver.onNext(response.build());
            responseObserver.onCompleted();
        }
    }

    // UPDATE
    @Override
    public void updateStatus(GameManagementStatusRequest request, StreamObserver<GameManagementResponse> responseObserver) {
        GameManagementResponse.Builder response = GameManagementResponse.newBuilder();

        try {
            // Find the game by its id and update its info
            Publisher<UpdateResult> publisher = gameColl.updateOne(
                    eq("_id", new ObjectId(request.getId())),
                    combine(
                            set("status", request.getStatus())
                    )
            );

            // Perform update
            Mono.from(publisher)
                    .publishOn(Schedulers.boundedElastic())
                    .subscribe(
                            updateResult -> {
                                String msg = "Game status update complete.";
                                System.out.println(msg);

                                response.setFinished(true);
                                response.setMessage(msg);
                                responseObserver.onNext(response.build());
                                responseObserver.onCompleted();
                            },
                            throwable -> {
                                throwable.printStackTrace();

                                response.setFinished(false);
                                response.setMessage("Failed to update game status");
                                responseObserver.onNext(response.build());
                                responseObserver.onCompleted();
                            }
                    );
        } catch (Exception e) {
            // Error message
            e.printStackTrace();

            response.setFinished(false);
            response.setMessage("Error while updating game status");
            responseObserver.onNext(response.build());
            responseObserver.onCompleted();
        }
    }

    // READ
    @Override
    public void getAll(GameManagementGetAllRequest request, StreamObserver<GameManagementGetAllResponse> responseObserver) {
        // Response builder
        GameManagementGetAllResponse.Builder response = GameManagementGetAllResponse.newBuilder();
        // Query
        Flux.from(gameColl.find(new Document()))
                .publishOn(Schedulers.boundedElastic())
                .collectList()
                .subscribe(
                        documents -> {
                            // Every document holds the data of a game
                            for (Document document : documents) {
                                // Retrieve basic info of this game...
                                String id = Objects.toString(document.get("_id"), "");
                                String name = Objects.toString(document.get("name"), "");
                                String type = Objects.toString(document.get("type"), "");
                                Boolean allowedItemTrade = (Boolean) document.get("allowedItemTrade");
                                String tutorial = Objects.toString(document.get("tutorial"), "");
                                String status = Objects.toString(document.get("status"), "");
                                long startTime = ((Date) document.getOrDefault("startTime", new Date(0))).getTime();
                                long endTime = ((Date) document.getOrDefault("endTime", new Date(0))).getTime();

                                if (id.isEmpty() || name.isEmpty() || type.isEmpty() || allowedItemTrade == null || status.isEmpty() || endTime == 0) continue;

                                Document config = document.get("config", new Document());
                                Integer maxPlayers = config.getInteger("maxPlayers");
                                Integer duration = config.getInteger("duration");

                                //...and store it in the builder (single game)
                                GameManagementGetResponse.Builder getResponseBuilder = GameManagementGetResponse.newBuilder()
                                        .setId(id)
                                        .setName(name)
                                        .setType(type)
                                        .setAllowedItemTrade(allowedItemTrade)
                                        .setTutorial(tutorial)
                                        .setStatus(status)
                                        .setStartTime(startTime)
                                        .setEndTime(endTime)
                                        .setMaxPlayers(maxPlayers)
                                        .setDuration(duration);

                                // Get all data on questions of this game and store it in the single-game builder
                                List<Document> questions = document.getList("questions", Document.class);
                                for (Document question: questions) {
                                    GameManagementQuestion.Builder questionBuilder = GameManagementQuestion.newBuilder();
                                    questionBuilder.setText(question.getString("text"))
                                            .setCorrectAnswer(question.getInteger("correctAnswer"))
                                            .addAllOptions(question.getList("options", String.class))
                                            .build();

                                    getResponseBuilder.addQuestions(questionBuilder);
                                }

                                // Add the single-game builder to the main builder
                                response.addGames(getResponseBuilder.build());
                            }

                            // Return response
                            response.setFinished(true);
                            response.setMessage("Game info retrieved successfully");
                            responseObserver.onNext(response.build());
                            responseObserver.onCompleted();
                        },
                        throwable -> {
                            throwable.printStackTrace();

                            // Return empty response if err
                            response.setFinished(false);
                            response.setMessage("Internal error");
                            responseObserver.onNext(response.clearGames().build());
                            responseObserver.onCompleted();
                        }
                );
    }

    // CREATE
    @Override
    public void add(GameManagementAddRequest request, StreamObserver<GameManagementResponse> responseObserver) {
        GameManagementResponse.Builder response = GameManagementResponse.newBuilder();

        try {
            // Convert a list of gRPC objects to readable JSON array
            ArrayList<Map<String, Object>> questionsList = new ArrayList<>();
            for (GameManagementQuestion gameManagementQuestion: request.getQuestionsList()) {
                Map<String, Object> questionMap = Map.of(
                        "text", gameManagementQuestion.getText(),
                        "options", Arrays.asList(gameManagementQuestion.getOptionsList().toArray()),
                        "correctAnswer", gameManagementQuestion.getCorrectAnswer()
                );

                questionsList.add(questionMap);
            }
            // Insert new document
            Publisher<InsertOneResult> publisher = gameColl.insertOne(new Document()
                    .append("name", request.getName())
                    .append("image", request.getImage())
                    .append("type", request.getType())
                    .append("allowedItemTrade", request.getAllowedItemTrade())
                    .append("tutorial", request.getTutorial())
                    .append("status", request.getStatus())
                    .append("startTime", new Date(request.getStartTime()))
                    .append("endTime", new Date(request.getEndTime()))
                    .append("config", Map.of(
                            "maxPlayers", request.getMaxPlayers(),
                            "duration", request.getDuration()
                    ))
                    .append("questions", questionsList));

            // Perform insertion
            Mono.from(publisher)
                    .publishOn(Schedulers.boundedElastic())
                    .subscribe(
                            insertOneResult -> {
                                String msg = "Game info insert complete.";
                                System.out.println(msg);

                                response.setFinished(true);
                                response.setMessage(msg);
                                responseObserver.onNext(response.build());
                                responseObserver.onCompleted();
                            },
                            throwable -> {
                                throwable.printStackTrace();

                                response.setFinished(false);
                                response.setMessage("Failed to insert document");
                                responseObserver.onNext(response.build());
                                responseObserver.onCompleted();
                            }
                    );
        } catch (Exception e) {
            // Error message
            e.printStackTrace();

            response.setFinished(false);
            response.setMessage("Error while updating game info");
            responseObserver.onNext(response.build());
            responseObserver.onCompleted();
        }
    }

    // Shake + UPDATE
    private int shakeRandom(int max) {
        Random rand = new Random();
        return rand.nextInt(max + 1);
    }
    private int shakeRandom(int min, int max) {
        Random rand = new Random();
        return rand.nextInt(min, max + 1);
    }
    public void shake(GameManagementShakeRequest request, StreamObserver<GameManagementShakeResponse> responseObserver) {
        int shakeResult = shakeRandom(100);

        GameManagementShakeResponse.Builder response = GameManagementShakeResponse.newBuilder();

        try {
            // Find the game by its id and update its shake result
            // CHANGE LATER
            Publisher<UpdateResult> publisher = gameColl.updateOne(
                    eq("_id", new ObjectId(request.getId())),
                    combine(
                            set("shake", shakeResult)
                    )
            );;

            // Perform update
            Mono.from(publisher)
                    .publishOn(Schedulers.boundedElastic())
                    .subscribe(
                            updateResult -> {
                                String msg = "Shake result update complete.";
                                System.out.println(msg);

                                response.setFinished(true);
                                response.setMessage(msg);
                                response.setShakeResult(shakeResult);
                                responseObserver.onNext(response.build());
                                responseObserver.onCompleted();
                            },
                            throwable -> {
                                throwable.printStackTrace();

                                response.setFinished(false);
                                response.setMessage("Failed to update shake result");
                                response.setShakeResult(-1);
                                responseObserver.onNext(response.build());
                                responseObserver.onCompleted();
                            }
                    );
        } catch (Exception e) {
            // Error message
            e.printStackTrace();

            response.setFinished(false);
            response.setMessage("Error while updating shake result");
            response.setShakeResult(-1);
            responseObserver.onNext(response.build());
            responseObserver.onCompleted();
        }
    }

    // CRON JOB: GAME STATUS UPDATE SCHEDULER
    private void setUpGameScheduler() {
        try {
            GameStatusUpdateScheduler.setSchedule();
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }
    }

    // Debug
    private void deleteOneDocument(String id) {
        Publisher<DeleteResult> publisher = gameColl.deleteOne(
                eq("_id", new ObjectId(id))
        );

        // Perform insertion
        Mono.from(publisher)
                .publishOn(Schedulers.boundedElastic())
                .subscribe(
                        deleteResult -> {
                            String msg = "Game info delete complete.";
                            System.out.println(msg);
                        },
                        throwable -> {
                            String msg = "Failed to delete document: " + throwable;
                            System.err.println(msg);
                        }
                );
    }
    private void printAllDocuments() {
        Flux.from(gameColl.find(new Document()))
                .publishOn(Schedulers.boundedElastic())
                .collectList()
                .subscribe(
                        documents -> {
                            System.out.printf("| %-30s | %-30s | %-10s | %-30s | %-30s | %-10s | %-50s | %-50s | %-15s | %-15s |\n", "id", "name", "type", "allowedItemTrade", "tutorial", "status", "startTime", "endTime", "maxPlayers", "duration");
                            for (Document document : documents) {
                                String id = Objects.toString(document.get("_id"), "");
                                String name = Objects.toString(document.get("name"), "");
                                String type = Objects.toString(document.get("type"), "");
                                String allowedItemTrade = Objects.toString(document.get("allowedItemTrade"), "");
                                String tutorial = Objects.toString(document.get("tutorial"), "");
                                String status = Objects.toString(document.get("status"), "");
                                String startTime = Objects.toString(document.get("startTime"), "");
                                String endTime = Objects.toString(document.get("endTime"), "");
                                Document config = document.get("config", new Document());
                                String maxPlayers = Objects.toString(config.get("maxPlayers"), "");
                                String duration = Objects.toString(config.get("duration"), "");
                                System.out.printf("| %-30s | %-30s | %-10s | %-30s | %-30s | %-10s | %-50s | %-50s | %-15s | %-15s |\n", id, name, type, allowedItemTrade, tutorial, status, startTime, endTime, maxPlayers, duration);
                            }
                        },
                        throwable -> System.out.println("Error: " + throwable)
                );
    }
    private void printOneDocument(String documentId) {
        Flux.from(gameColl.find(new Document()))
                .publishOn(Schedulers.boundedElastic())
                .collectList()
                .subscribe(
                        documents -> {
                            System.out.printf("| %-30s | %-30s | %-10s | %-30s | %-30s | %-10s | %-50s | %-50s | %-15s | %-15s |\n", "id", "name", "type", "allowedItemTrade", "tutorial", "status", "startTime", "endTime", "maxPlayers", "duration");
                            for (Document document : documents) {
                                if (Objects.equals(document.get("_id", ""), documentId)) {
                                    String name = Objects.toString(document.get("name"), "");
                                    String type = Objects.toString(document.get("type"), "");
                                    String allowedItemTrade = Objects.toString(document.get("allowedItemTrade"), "");
                                    String tutorial = Objects.toString(document.get("tutorial"), "");
                                    String status = Objects.toString(document.get("status"), "");
                                    String startTime = Objects.toString(document.get("startTime"), "");
                                    String endTime = Objects.toString(document.get("endTime"), "");
                                    Document config = document.get("config", new Document());
                                    String maxPlayers = Objects.toString(config.get("maxPlayers"), "");
                                    String duration = Objects.toString(config.get("duration"), "");
                                    System.out.printf("| %-30s | %-30s | %-10s | %-30s | %-30s | %-10s | %-50s | %-50s | %-15s | %-15s |\n", documentId, name, type, allowedItemTrade, tutorial, status, startTime, endTime, maxPlayers, duration);

                                    break;
                                }
                            }
                        },
                        throwable -> System.out.println("Error: " + throwable)
                );
    }
}
