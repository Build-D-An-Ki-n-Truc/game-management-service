package com.highman;

import com.google.gson.*;
import grpc.GameManagementInfoRequest;
import grpc.GameManagementResponse;
import grpc.GameManagementServiceGrpc;
import grpc.GameManagementStatusRequest;
import io.nats.client.Connection;
import io.nats.client.Message;
import io.nats.client.impl.Headers;
import io.nats.service.ServiceMessage;

import javax.net.ssl.SSLSession;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.sql.Array;
import java.util.*;

public class RequestHandler {
    public static void handle(Connection conn, Message requestMsg, GameManagementServiceGrpc.GameManagementServiceBlockingStub grpcStub) {
        String resp = new String(requestMsg.getData(), StandardCharsets.UTF_8);
        JsonObject jsonObject = JsonParser.parseString(resp).getAsJsonObject();
        JsonObject pattern = jsonObject.getAsJsonObject("pattern");
        String endpoint = pattern.get("endpoint").getAsString();

        GameManagementResponse response = null;
        switch (endpoint) {
            case "updateInfo": {
                response = updateInfoRequest(jsonObject.getAsJsonObject("data").getAsJsonObject("payload"), grpcStub);
                break;
            }
            case "updateStatus": {
                response = updateStatusRequest(jsonObject.getAsJsonObject("data").getAsJsonObject("payload"), grpcStub);
                break;
            }
        }

        if (response != null) {
            Gson gson = new Gson();
            JsonObject responsePayload = new JsonObject();
            responsePayload.addProperty("type", gson.toJson(List.of("info")));
            responsePayload.addProperty("status", 200);
            responsePayload.addProperty("data", gson.toJson(Map.of("finished", response.getFinished(), "message", response.getMessage())));
//            conn.publish(requestMsg.getReplyTo(), responsePayload.toString().getBytes(StandardCharsets.UTF_8));
            HttpResponse httpResponse = new HttpResponse() {
                @Override
                public int statusCode() {
                    return 200;
                }

                @Override
                public HttpRequest request() {
                    return null;
                }

                @Override
                public Optional<HttpResponse> previousResponse() {
                    return Optional.empty();
                }

                @Override
                public HttpHeaders headers() {
                    return null;
                }

                @Override
                public Object body() {
                    return responsePayload;
                }

                @Override
                public Optional<SSLSession> sslSession() {
                    return Optional.empty();
                }

                @Override
                public URI uri() {
                    return null;
                }

                @Override
                public HttpClient.Version version() {
                    return null;
                }
            };
            conn.publish(requestMsg.getReplyTo(), httpResponse.toString().getBytes());
        }
        else {

        }
    }

    private static GameManagementResponse updateInfoRequest(JsonObject payload, GameManagementServiceGrpc.GameManagementServiceBlockingStub grpcStub) {
        if (payload.has("id") && payload.has("name") && payload.has("image") && payload.has("type") && payload.has("alloweditemtrade") && payload.has("tutorial")) {
            GameManagementInfoRequest request = GameManagementInfoRequest.newBuilder()
                    .setId(payload.get("id").getAsString())
                    .setName(payload.get("name").getAsString())
                    .setImage(payload.get("image").getAsString())
                    .setType(payload.get("type").getAsString())
                    .setAllowedItemTrade(payload.get("alloweditemtrade").getAsBoolean())
                    .setTutorial(payload.get("tutorial").getAsString())
                    .build();

            return grpcStub.updateInfo(request);
        }

        return null;
    }

    private static GameManagementResponse updateStatusRequest(JsonObject payload, GameManagementServiceGrpc.GameManagementServiceBlockingStub grpcStub) {
        if (payload.has("id") && payload.has("id")) {
            GameManagementStatusRequest request = GameManagementStatusRequest.newBuilder()
                    .setId(payload.get("id").getAsString())
                    .setStatus(payload.get("status").getAsInt())
                    .build();

            return grpcStub.updateStatus(request);
        }
        return null;
    }
}
