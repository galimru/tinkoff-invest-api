package com.github.galimru.tinkoff.exceptions;

public class ApiException extends Exception {

    private final String code;
    private final String message;

    public ApiException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return String.format("[%s] %s", code, message);
    }
}
