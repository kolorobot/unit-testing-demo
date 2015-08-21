package com.github.kolorobot.exceptions;

public class MyRuntimeException extends RuntimeException {

    private int code = 0;

    public MyRuntimeException() {
        super("My custom runtime exception");
    }

    public MyRuntimeException(int code) {
        this.code = code;
    }

    public MyRuntimeException(Throwable cause) {
        super("My custom runtime exception", cause);
    }

    public int getCode() {
        return code;
    }
}
