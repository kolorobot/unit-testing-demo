package com.github.kolorobot.exceptions;

public class Thrower {
    public void throwsRuntime() {
        throw new MyRuntimeException();
    }

    public void throwsRuntimeWithCause() {
        throw new MyRuntimeException(new IllegalStateException("Illegal state"));
    }

    public void throwsRuntimeWithCode(int code) {
        throw new MyRuntimeException(code);
    }

    public void throwsChecked() throws MyCheckedException {
        throw new MyCheckedException();
    }

    public void throwsRuntimeInsteadOfChecked() throws MyCheckedException {
        throw new MyRuntimeException();
    }
}
