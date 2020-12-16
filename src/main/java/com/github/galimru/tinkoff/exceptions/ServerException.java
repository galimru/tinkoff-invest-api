package com.github.galimru.tinkoff.exceptions;

public class ServerException extends ApiException {

    public static final String HTTP_ERROR = "HTTP_ERROR";
    private final int status;

    public ServerException(int status, String message) {
        super(HTTP_ERROR, message);
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
