package com.github.kolorobot.exceptions;

class CustomException extends RuntimeException {
    private final int code;

    public CustomException(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
