package com.github.kolorobot.exceptions.java8;

class DummyService {
    public void someMethod() {
        throw new RuntimeException("Runtime exception occurred");
    }

    public void someOtherMethod() {
        throw new RuntimeException("Runtime exception occurred",
                new IllegalStateException("Illegal state"));
    }
}
