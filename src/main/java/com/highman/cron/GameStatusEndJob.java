package com.highman.cron;

import com.mongodb.client.result.UpdateResult;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import com.mongodb.reactivestreams.client.MongoCollection;
import com.mongodb.reactivestreams.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;

public class GameStatusEndJob implements Job {
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

        // Find the game by its id and update its status
        Publisher<UpdateResult> publisher = gameColl.updateOne(
                eq("_id", new ObjectId(id)),
                set("status", "Finished")
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
