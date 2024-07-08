package com.highman;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class GameManagementServiceServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(8080).addService(new GameManagementService()).build();

        server.start();
        server.awaitTermination();
    }
}