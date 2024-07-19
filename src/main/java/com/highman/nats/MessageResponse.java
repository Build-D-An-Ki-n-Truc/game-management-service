package com.highman.nats;

import com.google.gson.JsonObject;

public class MessageResponse {
    JsonObject data;

    public MessageResponse(JsonObject data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "{\"payload\":{\"type\":[\"info\"],\"status\":200,\"data\":" + data.toString() + "}}";
    }
}
