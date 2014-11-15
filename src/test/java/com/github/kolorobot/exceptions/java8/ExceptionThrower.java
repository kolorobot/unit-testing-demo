package com.github.kolorobot.exceptions.java8;

@FunctionalInterface
public interface ExceptionThrower {
    void throwException() throws Throwable;
}
