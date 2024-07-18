package com.highman;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.ServerInterceptor;
import io.grpc.ServerInterceptors;
import io.nats.client.Connection;
import io.nats.client.Message;
import io.nats.client.Nats;
import io.nats.client.Options;
import io.netty.util.concurrent.Future;
import io.prometheus.client.CollectorRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.maven.plugin.logging.Log;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class GameManagementServiceServer {
    private static final Logger LOGGER = LogManager.getLogger(GameManagementServiceServer.class);
    public static void main(String[] args) throws IOException, InterruptedException{
        Server server = ServerBuilder.forPort(4010).addService(new GameManagementService()).build();

        server.start();
        LOGGER.debug("Server is running");
        server.awaitTermination();
        LOGGER.debug("Server has stopped running");
    }
}