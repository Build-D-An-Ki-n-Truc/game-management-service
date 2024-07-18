package com.highman.nats;

public class MessagePattern {
    String endpoint = "";
    String method = "GET";
    String service = "";

    public MessagePattern(String service, String endpoint, String method) {
        this.endpoint = endpoint;
        this.method = method;
        this.service = service;
    }

    @Override
    public String toString() {
        return "{\"endpoint\":\"" + endpoint + "\",\"method\":\"" + method + "\",\"service\":\"" + service + "\"}";
    }
}
