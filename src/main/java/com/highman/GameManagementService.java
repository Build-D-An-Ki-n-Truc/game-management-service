package com.highman;

import com.highman.models.DBConnectionPool;
import com.highman.prometheus.MetricsRegisters;
import com.mongodb.client.result.UpdateResult;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import com.mongodb.reactivestreams.client.MongoCollection;
import com.mongodb.reactivestreams.client.MongoDatabase;
import grpc.GameManagementInfoRequest;
import grpc.GameManagementResponse;
import grpc.GameManagementServiceGrpc;
import grpc.GameManagementStatusRequest;
import io.grpc.stub.StreamObserver;
import org.apache.logging.log4j.LogManager;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;
import java.util.logging.Logger;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;

public class GameManagementService extends GameManagementServiceGrpc.GameManagementServiceImplBase {
    MongoClient mongoClient;
    MongoCollection<Document> gameColl;
    private static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger(GameManagementService.class);

    public GameManagementService() {
        try {
            mongoClient = MongoClients.create(System.getenv("MONGO_URI"));
            MongoDatabase mongoDatabase = mongoClient.getDatabase("game_service");
            gameColl = mongoDatabase.getCollection("games");

            printAllDocuments();
            MetricsRegisters.requests.inc();
        } catch (Exception e) {
            String error = "An error has occured while retrieving database connection: " + e.getMessage();
            e.printStackTrace();
            LOGGER.debug(error);
        }
    }

    // Run at server termination
    public void shutdown() {
        if (mongoClient != null) mongoClient.close();
    }

    @Override
    public void updateInfo(GameManagementInfoRequest request, StreamObserver<GameManagementResponse> responseObserver) {
        GameManagementResponse.Builder response = GameManagementResponse.newBuilder();

        try {
            // Find the game by its id and update its info
            Publisher<UpdateResult> publisher = gameColl.updateOne(
                    eq("_id", new ObjectId(request.getId())),
                    combine(
                            set("type", request.getType()),
                            set("startTime", new Date(request.getStartTime())),
                            set("endTime", new Date(request.getEndTime())),
                            set("config", combine(
                                    set("maxPlayers", request.getMaxPlayers()),
                                    set("duration", request.getDuration())
                            ))
                    )
            );

            // Actions after update is complete
            Runnable postUpdate = () -> {
                String msg = "Game info update complete.";
                response.setFinished(true);
                response.setMessage(msg);
                LOGGER.debug(msg);
            };

            // Perform update
            Mono.from(publisher)
                    .publishOn(Schedulers.boundedElastic())
                    .subscribe(
                            updateResult -> System.out.println("Update successful, modified count: " + updateResult.getModifiedCount()),
                            throwable -> System.err.println("Failed to update document: " + throwable),
                            postUpdate
                    );
        } catch (Exception e) {
            // Error message
            String msg = "Error while updating game info" + e.getMessage();
            e.printStackTrace();
            response.setFinished(false);
            response.setMessage(msg);
            LOGGER.debug(msg);
        }

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void updateStatus(GameManagementStatusRequest request, StreamObserver<GameManagementResponse> responseObserver) {
        GameManagementResponse.Builder response = GameManagementResponse.newBuilder();

        try {
//            // Find the game by its id and update its info
//            String sql = "UPDATE game SET status=? WHERE id=?";
//            PreparedStatement updateStatement = conn.prepareStatement(sql);
//            updateStatement.setInt(1, request.getStatus());
//            updateStatement.setString(2, request.getId());
//            updateStatement.executeUpdate();
//            conn.commit();
//
//            // Response message
//            String msg = "Game status update complete.";
//            response.setFinished(true);
//            response.setMessage(msg);
//            LOGGER.debug(msg);
        } catch (Exception e) {
            // Error message
            String msg = "Error while updating game status" + e.getMessage();
            e.printStackTrace();
            response.setFinished(false);
            response.setMessage(msg);
            LOGGER.debug(msg);
        }

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    // Debug
    private void printAllDocuments() {
        Flux.from(gameColl.find(new Document()))
                .publishOn(Schedulers.boundedElastic())
                .collectList()
                .subscribe(
                        documents -> {
                            System.out.printf("| %-30s | %-10s | %-10s | %-50s | %-50s |\n", "id", "type", "status", "startTime", "endTime");
                            for (Document document : documents) {
                                String id = Objects.toString(document.get("_id"), "");
                                String type = Objects.toString(document.get("type"), "");
                                String status = Objects.toString(document.get("status"), "");
                                String startTime = Objects.toString(document.get("startTime"), "");
                                String endTime = Objects.toString(document.get("endTime"), "");
                                System.out.printf("| %-30s | %-10s | %-10s | %-50s | %-50s |\n", id, type, status, startTime, endTime);
                            }
                        },
                        throwable -> System.out.println("Error: " + throwable)
                );
    }
}
