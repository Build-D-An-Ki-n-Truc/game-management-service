package com.highman;

import grpc.GameManagementServiceGrpc;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.ServerInterceptors;
import io.prometheus.client.exporter.HTTPServer;
import me.dinowernli.grpc.prometheus.Configuration;
import me.dinowernli.grpc.prometheus.MonitoringServerInterceptor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class GameManagementServiceServer {
    private static final Logger LOGGER = LogManager.getLogger(GameManagementServiceServer.class);
    public static void main(String[] args) throws IOException, InterruptedException{
        MonitoringServerInterceptor monitoringInterceptor =
                MonitoringServerInterceptor.create(Configuration.allMetrics());
        Server server = ServerBuilder.forPort(4010).addService(ServerInterceptors.intercept(
                GameManagementServiceGrpc.bindService(new GameManagementService()), monitoringInterceptor)).build();

        HTTPServer prometheusServer = new HTTPServer(4011);

        server.start();
        LOGGER.debug("Server is running");
        server.awaitTermination();
        LOGGER.debug("Server has stopped running");

        prometheusServer.close();
    }
}