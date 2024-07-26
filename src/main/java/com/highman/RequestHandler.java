//package com.highman;
//
//import com.google.gson.*;
//import com.highman.nats.MessageResponse;
//import grpc.*;
//import io.nats.client.Connection;
//import io.nats.client.Message;
//import io.nats.client.impl.Headers;
//import io.nats.service.ServiceMessage;
//
//import javax.net.ssl.SSLSession;
//import java.net.URI;
//import java.net.http.HttpClient;
//import java.net.http.HttpHeaders;
//import java.net.http.HttpRequest;
//import java.net.http.HttpResponse;
//import java.nio.charset.StandardCharsets;
//import java.sql.Array;
//import java.util.*;
//
//public class RequestHandler {
//    public static void handle(Connection conn, Message requestMsg, GameManagementServiceGrpc.GameManagementServiceBlockingStub grpcStub) {
//        String resp = new String(requestMsg.getData(), StandardCharsets.UTF_8);
//        JsonObject jsonObject = JsonParser.parseString(resp).getAsJsonObject();
//        JsonObject pattern = jsonObject.getAsJsonObject("pattern");
//        String endpoint = pattern.get("endpoint").getAsString();
//
//        GameManagementResponse response = null;
//        switch (endpoint) {
//            case "updateInfo": {
//                response = updateInfoRequest(jsonObject.getAsJsonObject("data").getAsJsonObject("payload"), grpcStub);
//                break;
//            }
//            case "updateStatus": {
//                response = updateStatusRequest(jsonObject.getAsJsonObject("data").getAsJsonObject("payload"), grpcStub);
//                break;
//            }
//            case "getAll": {
//                response
//            }
//        }
//
//        if (response != null) {
//            JsonObject responsePayload = new JsonObject();
//            responsePayload.addProperty("finished", response.getFinished());
//            responsePayload.addProperty("message", response.getMessage());
//            MessageResponse natsResponse = new MessageResponse(responsePayload);
//            System.out.println(natsResponse);
//            conn.publish(requestMsg.getReplyTo(), natsResponse.toString().getBytes(StandardCharsets.UTF_8));
//        }
//        else {
//            JsonObject responsePayload = new JsonObject();
//            responsePayload.addProperty("finished", "false");
//            responsePayload.addProperty("message", "gRPC response returns null");
//            MessageResponse natsResponse = new MessageResponse(responsePayload);
//            System.out.println(natsResponse);
//            conn.publish(requestMsg.getReplyTo(), natsResponse.toString().getBytes(StandardCharsets.UTF_8));
//        }
//    }
//
//    private static GameManagementResponse updateInfoRequest(JsonObject payload, GameManagementServiceGrpc.GameManagementServiceBlockingStub grpcStub) {
//        if (payload.has("id") && payload.has("name") && payload.has("image") && payload.has("type") && payload.has("alloweditemtrade") && payload.has("tutorial") && payload.has("startTime") && payload.has("endTime") && payload.has("maxPlayers") && payload.has("duration")) {
//            GameManagementInfoRequest request = GameManagementInfoRequest.newBuilder()
//                    .setId(payload.get("id").getAsString())
//                    .setName(payload.get("name").getAsString())
//                    .setImage(payload.get("image").getAsString())
//                    .setType(payload.get("type").getAsString())
//                    .setAllowedItemTrade(payload.get("alloweditemtrade").getAsBoolean())
//                    .setTutorial(payload.get("tutorial").getAsString())
//                    .setStartTime(payload.get("startTime").getAsLong())
//                    .setEndTime(payload.get("endTime").getAsLong())
//                    .setMaxPlayers(payload.get("maxPlayers").getAsInt())
//                    .setDuration(payload.get("duration").getAsInt())
//                    .build();
//
//            return grpcStub.updateInfo(request);
//        }
//
//        return null;
//    }
//
//    private static GameManagementResponse updateStatusRequest(JsonObject payload, GameManagementServiceGrpc.GameManagementServiceBlockingStub grpcStub) {
//        if (payload.has("id") && payload.has("status")) {
//            GameManagementStatusRequest request = GameManagementStatusRequest.newBuilder()
//                    .setId(payload.get("id").getAsString())
//                    .setStatus(payload.get("status").getAsString())
//                    .build();
//
//            return grpcStub.updateStatus(request);
//        }
//        return null;
//    }
//
//    private static GameManagementGetAllResponse getAllRequest(GameManagementServiceGrpc.GameManagementServiceBlockingStub grpcStub) {
//        return grpcStub.getAll(GameManagementGetAllRequest.newBuilder().build());
//    }
//}
