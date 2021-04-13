package com.ytrsoft.response;

public enum ResponseStatus {

    SUCCEED(200, "succeed"),
    FAILED(500, "failed"),
    NOT_FOUND(404, "not found");

    private final int code;
    private final String message;

    ResponseStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

}
