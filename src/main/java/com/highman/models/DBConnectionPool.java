package com.highman.models;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DBConnectionPool {
    static final int MAX_CONNECTION = 50;
    static final String dbRelativePath = "/vou_proj";
    static final String dbUser = "postgres";
    static final String dbPwd = "abc123";

    private static final BasicDataSource ds = new BasicDataSource();

    static {
        ds.setDefaultAutoCommit(false);
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setUrl("jdbc:postgresql://localhost:4011" + dbRelativePath);
        ds.setUsername(dbUser);
        ds.setPassword(dbPwd);
        ds.setMaxTotal(MAX_CONNECTION);
        ds.setMinIdle(MAX_CONNECTION);
        ds.setCacheState(false);
        ds.setPoolPreparedStatements(false);
        ds.setTestOnBorrow(true);
        ds.setDefaultTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
        ds.setMaxOpenPreparedStatements(100);
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    private DBConnectionPool(){ }
}
