package com.highman;

import grpc.GameManagementInfoRequest;
import grpc.GameManagementResponse;
import grpc.GameManagementServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GameManagementServiceClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080).build();

        GameManagementServiceGrpc.GameManagementServiceBlockingStub stub = GameManagementServiceGrpc.newBlockingStub(channel);

        GameManagementResponse infoUpdateResponse = stub.updateInfo(GameManagementInfoRequest.newBuilder()
                .setName("fdasfds").build());
        System.out.println(infoUpdateResponse.getFinished());

        channel.shutdown();
    }
}
