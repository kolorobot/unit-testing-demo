package com.github.kolorobot.exceptions.java8;

public class ThrowableCaptor {
    public static Throwable captureThrowable(ExceptionThrower exceptionThrower) {
        try {
            exceptionThrower.throwException();
            return null;
        } catch (Throwable caught) {
            return caught;
        }
    }
}
