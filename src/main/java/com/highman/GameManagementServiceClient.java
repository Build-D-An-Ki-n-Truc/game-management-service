package com.highman;

import grpc.GameManagementInfoRequest;
import grpc.GameManagementResponse;
import grpc.GameManagementServiceGrpc;
import grpc.GameManagementStatusRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GameManagementServiceClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 4010).usePlaintext().build();

        GameManagementServiceGrpc.GameManagementServiceBlockingStub stub = GameManagementServiceGrpc.newBlockingStub(channel);

        GameManagementResponse infoUpdateResponse = stub.updateStatus(GameManagementStatusRequest.newBuilder()
                .setId("GME140724153638").setStatus(5).build());
        System.out.println(infoUpdateResponse.getFinished());

        channel.shutdown();
    }
}
