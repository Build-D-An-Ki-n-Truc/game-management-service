package com.highman;

import grpc.GameManagementInfoRequest;
import grpc.GameManagementResponse;
import grpc.GameManagementServiceGrpc;
import grpc.GameManagementStatusRequest;
import io.grpc.stub.StreamObserver;

public class GameManagementService extends GameManagementServiceGrpc.GameManagementServiceImplBase {
    @Override
    public void updateInfo(GameManagementInfoRequest request, StreamObserver<GameManagementResponse> responseObserver) {
        super.updateInfo(request, responseObserver);

        System.out.println("Info updated");
    }

    @Override
    public void updateStatus(GameManagementStatusRequest request, StreamObserver<GameManagementResponse> responseObserver) {
        super.updateStatus(request, responseObserver);

        System.out.println("Status updated");
    }
}
