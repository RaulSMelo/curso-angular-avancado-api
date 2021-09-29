package com.raulmelo.finansysapi.exceptions;

import java.io.Serializable;

public class StandardException implements Serializable{
    
    private long timestamp;
    private int status;
    private String error;

    public StandardException() {}

    public StandardException(long timestamp, int status, String error) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
