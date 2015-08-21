package com.github.kolorobot.exceptions;

public class MyCheckedException extends Exception {
    public MyCheckedException() {
        super("My custom checked exception");
    }
}
