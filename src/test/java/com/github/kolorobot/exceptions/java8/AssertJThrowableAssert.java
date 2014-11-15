package com.github.kolorobot.exceptions.java8;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert;

public class AssertJThrowableAssert {
    public static ThrowableAssert assertThrown(ExceptionThrower exceptionThrower) {
        try {
            exceptionThrower.throwException();
        } catch (Throwable throwable) {
            return (ThrowableAssert) Assertions.assertThat(throwable);
        }
        throw new ExceptionNotThrownAssertionError();
    }
}
