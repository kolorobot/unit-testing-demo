package com.github.kolorobot.assertj.exceptions;

class DummyService {
    public void someMethod() {
        throw new RuntimeException("Runtime exception occurred");
    }

    public void someOtherMethod(boolean b) {
        throw new RuntimeException("Runtime exception occurred",
                new IllegalStateException("Illegal state"));
    }
}
