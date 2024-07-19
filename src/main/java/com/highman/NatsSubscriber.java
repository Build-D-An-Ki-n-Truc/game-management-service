package com.highman;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.highman.nats.MessagePattern;
import grpc.GameManagementInfoRequest;
import grpc.GameManagementResponse;
import grpc.GameManagementServiceGrpc;
import grpc.GameManagementStatusRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.nats.client.*;
import io.nats.service.*;

import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class NatsSubscriber {
    final static String natsUrl = "nats://localhost:4222";
    final static String grpcHost = "localhost";
    final static int grpcPort = 4010;
    public static void main(String[] args) throws Exception {

        // Create connection to gRPC server
        ManagedChannel channel = ManagedChannelBuilder.forAddress(grpcHost, grpcPort).usePlaintext().build();
        GameManagementServiceGrpc.GameManagementServiceBlockingStub grpcStub = GameManagementServiceGrpc.newBlockingStub(channel);

        MessagePattern updateInfoMP = new MessagePattern("gameManage", "updateInfo", "POST");
        subscribe(updateInfoMP, grpcStub);

        MessagePattern updateStatusMP = new MessagePattern("gameManage", "updateStatus", "POST");
        subscribe(updateStatusMP, grpcStub);
    }

    private static void subscribe(MessagePattern messagePattern, GameManagementServiceGrpc.GameManagementServiceBlockingStub grpcStub) {
        String subject = messagePattern.toString();

        Thread subscriptionThread = new Thread(() -> {
            try (Connection natsConn = Nats.connect(natsUrl)) {
                Subscription sub = natsConn.subscribe(subject);
                while (true) {
                    try {
                        Message msg = sub.nextMessage(Duration.ofMillis(1000));

                        if (msg == null) continue;
                        RequestHandler.handle(natsConn, msg, grpcStub);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });

        subscriptionThread.start();
    }
}
