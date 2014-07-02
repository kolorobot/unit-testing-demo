package com.github.kolorobot.exceptions.java8;

import org.hamcrest.Matchers;
import org.junit.Assert;

public class ThrowableAssertion {

    public static ThrowableAssertion assertThrown(ExceptionThrower exceptionThrower) {
        try {
            exceptionThrower.throwException();
        } catch (Throwable throwable) {
            return new ThrowableAssertion(throwable);
        }
        throw new ExceptionNotThrownAssertionError();
    }

    private final Throwable throwable;

    public ThrowableAssertion(Throwable throwable) {
        this.throwable = throwable;
    }

    public ThrowableAssertion isInstanceOf(Class<? extends Throwable> exceptionClass) {
        Assert.assertThat(throwable, Matchers.isA((Class<Throwable>) exceptionClass));
        return this;
    }

    public ThrowableAssertion hasMessage(String expectedMessage) {
        Assert.assertThat(throwable.getMessage(), Matchers.equalTo(expectedMessage));
        return this;
    }

    public ThrowableAssertion hasNoCause() {
        Assert.assertThat(throwable.getCause(), Matchers.nullValue());
        return this;
    }

    public ThrowableAssertion hasCauseInstanceOf(Class<? extends Throwable> exceptionClass) {
        Assert.assertThat(throwable.getCause(), Matchers.notNullValue());
        Assert.assertThat(throwable.getCause(), Matchers.isA((Class<Throwable>) exceptionClass));
        return this;
    }
}
