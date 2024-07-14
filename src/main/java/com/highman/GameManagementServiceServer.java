package com.highman;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.maven.plugin.logging.Log;

import java.io.IOException;

public class GameManagementServiceServer {
    private static final Logger LOGGER = LogManager.getLogger(GameManagementServiceServer.class);
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(4010).addService(new GameManagementService()).build();

        server.start();
        LOGGER.debug("Server is running");
        server.awaitTermination();
        LOGGER.debug("Server is running");
    }
}