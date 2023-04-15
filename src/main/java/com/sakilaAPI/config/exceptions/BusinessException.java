package com.sakilaAPI.config.exceptions;

public class BusinessException extends RuntimeException {

    private final String description;
    private final int code;

    public BusinessException(String message, int code, String description) {
        super(message);
        this.description = description;
        this.code = code;
    }

    public String getDescription() {
        return description;
    }
    public int getCode() {
        return code;
    }
}
