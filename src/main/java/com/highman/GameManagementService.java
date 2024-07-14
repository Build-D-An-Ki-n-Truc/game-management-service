package com.highman;

import com.highman.models.DBConnectionPool;
import grpc.GameManagementInfoRequest;
import grpc.GameManagementResponse;
import grpc.GameManagementServiceGrpc;
import grpc.GameManagementStatusRequest;
import io.grpc.stub.StreamObserver;
import org.apache.logging.log4j.LogManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Logger;

public class GameManagementService extends GameManagementServiceGrpc.GameManagementServiceImplBase {
    Connection conn;
    private static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger(GameManagementService.class);

    public GameManagementService() {
        try {
            conn = DBConnectionPool.getConnection();
        } catch (SQLException e) {
            String error = "An error has occured while retrieving database connection: " + e.getMessage();
            e.printStackTrace();
            LOGGER.debug(error);
        }
    }

    @Override
    public void updateInfo(GameManagementInfoRequest request, StreamObserver<GameManagementResponse> responseObserver) {
        GameManagementResponse.Builder response = GameManagementResponse.newBuilder();

        try {
            // Find the game by its id and update its info
            String sql = "UPDATE \"Game\" SET name=?, image=?, type=?, alloweditemtrade=?, tutorial=? WHERE id=?";
            PreparedStatement updateStatement = conn.prepareStatement(sql);
            updateStatement.setString(1, request.getName());
            updateStatement.setString(2, request.getImage());
            updateStatement.setString(3, request.getType());
            updateStatement.setBoolean(4, request.getAllowedItemTrade());
            updateStatement.setString(5, request.getTutorial());
            updateStatement.setString(6, request.getId());

            // Response message
            String msg = "Game info update complete.";
            response.setFinished(true);
            response.setMessage(msg);
            LOGGER.debug(msg);
        } catch (Exception e) {
            // Error message
            String msg = "Error while updating game info" + e.getMessage();
            e.printStackTrace();
            response.setFinished(false);
            response.setMessage(msg);
            LOGGER.debug(msg);
        }

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void updateStatus(GameManagementStatusRequest request, StreamObserver<GameManagementResponse> responseObserver) {
        GameManagementResponse.Builder response = GameManagementResponse.newBuilder();

        try {
            // Find the game by its id and update its info
            String sql = "UPDATE \"Game\" SET status=? WHERE id=?";
            PreparedStatement updateStatement = conn.prepareStatement(sql);
            updateStatement.setInt(1, request.getStatus());
            updateStatement.setString(2, request.getId());
            updateStatement.executeUpdate();
            conn.commit();

            // Response message
            String msg = "Game status update complete.";
            response.setFinished(true);
            response.setMessage(msg);
            LOGGER.debug(msg);
        } catch (Exception e) {
            // Error message
            String msg = "Error while updating game status" + e.getMessage();
            e.printStackTrace();
            response.setFinished(false);
            response.setMessage(msg);
            LOGGER.debug(msg);
        }

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }
}
