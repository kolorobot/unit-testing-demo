package com.github.kolorobot.exceptions.junit4rule;

public class ExceptionThrowingService {

    public void someMethod() {
        throw new RuntimeException("Runtime exception occurred");
    }

    public void someOtherMethod() {
        throw new RuntimeException("Runtime exception occurred",
                new IllegalStateException("Illegal state"));
    }

    public void yetAnotherMethod(int code) {
        throw new CustomException(code);
    }
}