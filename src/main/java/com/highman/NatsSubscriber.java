package com.highman;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.highman.handlers.RequestHandlerBase;
import com.highman.handlers.RequestHandlerFactory;
import com.highman.nats.MessagePattern;
import com.highman.nats.MessageResponse;
import grpc.GameManagementInfoRequest;
import grpc.GameManagementResponse;
import grpc.GameManagementServiceGrpc;
import grpc.GameManagementStatusRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.netty.NettyChannelBuilder;
import io.nats.client.*;
import io.nats.service.*;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashSet;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class NatsSubscriber {
    final static String natsUrl = "nats://localhost:4222";
    final static String grpcHost = "localhost";
    final static int grpcPort = 4010;
    public static void main(String[] args) {
        // Create connection to gRPC server
        ManagedChannel channel = ManagedChannelBuilder.forAddress(grpcHost, grpcPort).usePlaintext().build();
        GameManagementServiceGrpc.GameManagementServiceBlockingStub grpcStub = GameManagementServiceGrpc.newBlockingStub(channel);

        MessagePattern updateInfoMP = new MessagePattern("gameManage", "updateInfo", "POST");
        subscribe(updateInfoMP, grpcStub);

        MessagePattern updateStatusMP = new MessagePattern("gameManage", "updateStatus", "POST");
        subscribe(updateStatusMP, grpcStub);

        MessagePattern getAllMP = new MessagePattern("gameManage", "getAll", "GET");
        subscribe(getAllMP, grpcStub);

        MessagePattern addMP = new MessagePattern("gameManage", "add", "POST");
        subscribe(addMP, grpcStub);

        MessagePattern shakeMP = new MessagePattern("gameManage", "shake", "GET");
        subscribe(shakeMP, grpcStub);
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
                        String resp = new String(msg.getData(), StandardCharsets.UTF_8);
                        JsonObject jsonObject = JsonParser.parseString(resp).getAsJsonObject();
                        JsonObject pattern = jsonObject.getAsJsonObject("pattern");
                        String endpoint = pattern.get("endpoint").getAsString();
                        JsonObject payload = jsonObject.getAsJsonObject("data").getAsJsonObject("payload");

                        RequestHandlerBase requestHandlerBase = RequestHandlerFactory.getHandler(endpoint);
                        JsonObject responsePayload = requestHandlerBase.handle(payload, grpcStub);
                        MessageResponse natsResponse = new MessageResponse(responsePayload);
                        natsConn.publish(msg.getReplyTo(), natsResponse.toString().getBytes(StandardCharsets.UTF_8));
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
