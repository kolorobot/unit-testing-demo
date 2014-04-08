package com.github.kolorobot.exceptions;

class ExceptionThrower {

    void someMethod() {
        throw new RuntimeException("Runtime exception occurred");
    }

    void someOtherMethod() {
        throw new RuntimeException("Runtime exception occurred",
                new IllegalStateException("Illegal state"));
    }

    void yetAnotherMethod(int code) {
        throw new CustomException(code);
    }
}