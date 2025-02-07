package com.itg.exam_app.response.error;

public class CommonException extends RuntimeException {
    private String errorType;

    public CommonException(String errorType, String message) {
        super(message);
        this.errorType = errorType;
    }

    public String getErrorType() {
        return errorType;
    }
}