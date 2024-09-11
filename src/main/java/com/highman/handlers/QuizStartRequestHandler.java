package com.highman.handlers;

import com.google.gson.JsonObject;
import grpc.GameManagementInfoRequest;
import grpc.GameManagementResponse;
import grpc.GameManagementServiceGrpc;
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import io.socket.engineio.client.transports.WebSocket;
import org.json.JSONObject;

import java.net.URI;
import java.util.Map;

public class QuizStartRequestHandler implements RequestHandlerBase{
    private final String ERROR_MSG = "Request has invalid structure";

    @Override
    public JsonObject handle(JsonObject requestJson, GameManagementServiceGrpc.GameManagementServiceBlockingStub grpcStub) {
        JsonObject responsePayload = new JsonObject();

        if (requestJson.has("gameId")) {
            String gameId = requestJson.get("gameId").getAsString();

            // Create a Socket
            URI uri = URI.create("http://" + System.getenv("LOCALHOST") + ":3000");
            IO.Options options = IO.Options.builder()
                    .setPath("/game")
                    .setTransports(new String[] { WebSocket.NAME })
                    .build();
            Socket socket = IO.socket(uri, options).connect();
            socket.on("connect", new Emitter.Listener() {
                @Override
                public void call(Object... args) {
                    System.out.println("Emergency start socket of game \"" + gameId + "\" has connected to the server");
                }
            });

            if (socket.connected()) {
                socket.emit("startGame", new JSONObject(Map.of("gameId", gameId)));

                responsePayload.addProperty("finished", true);
                responsePayload.addProperty("message", "Game \"" + gameId + "\" has started");
            }
            else {
                responsePayload.addProperty("finished", false);
                responsePayload.addProperty("message", "Failure to start socket");
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
        return "quizStart";
    }
}
