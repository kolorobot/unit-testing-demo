package com.github.kolorobot.exceptions.junit4rule;

public class CustomException extends RuntimeException {
    private final int code;

    public CustomException(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
