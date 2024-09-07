package com.highman.cron;

import com.mongodb.client.result.UpdateResult;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import com.mongodb.reactivestreams.client.MongoCollection;
import com.mongodb.reactivestreams.client.MongoDatabase;
import io.socket.client.Socket;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.json.JSONObject;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.Map;

import static com.mongodb.client.model.Aggregates.set;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;

public class GameStatusStartJob implements Job {
    private static final MongoCollection<Document> gameColl;
    static {
        MongoClient mongoClient = MongoClients.create(System.getenv("MONGO_URI"));
        MongoDatabase mongoDatabase = mongoClient.getDatabase("game_service");
        gameColl = mongoDatabase.getCollection("games");
    }
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDataMap jobDataMap = jobExecutionContext.getMergedJobDataMap();
        String id = jobDataMap.getString("id");
        Socket socket = (Socket) jobDataMap.get("socket");
        String type = jobDataMap.getString("type");

        // Send socket message to game_service
        if (socket.connected() && type.equals("Quiz")) {
            socket.emit("startGame", new JSONObject(Map.of("gameId", id)));
        }


        if (type.equals("Shake")) {
            // Find the game by its id and update its status
            Publisher<UpdateResult> publisher = gameColl.updateOne(
                    eq("_id", new ObjectId(id)),
                    set("status", "InProgress")
            );

            // Perform update
            Mono.from(publisher)
                    .publishOn(Schedulers.boundedElastic())
                    .subscribe(
                            updateResult -> {
                                String msg = "Game status update complete.";
                                System.out.println(msg);
                            },
                            throwable -> {
                                throwable.printStackTrace();
                            }
                    );

        }
    }
}
