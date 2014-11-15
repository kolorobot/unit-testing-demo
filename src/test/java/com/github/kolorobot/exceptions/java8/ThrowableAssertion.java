package com.github.kolorobot.exceptions.java8;

import org.hamcrest.Matchers;
import org.junit.Assert;

public class ThrowableAssertion {

    public static ThrowableAssertion assertThrown(ExceptionThrower exceptionThrower) {
        try {
            exceptionThrower.throwException();
        } catch (Throwable caught) {
            return new ThrowableAssertion(caught);
        }
        throw new ExceptionNotThrownAssertionError();
    }

    private final Throwable caught;

    public ThrowableAssertion(Throwable caught) {
        this.caught = caught;
    }

    public ThrowableAssertion isInstanceOf(Class<? extends Throwable> exceptionClass) {
        Assert.assertThat(caught, Matchers.isA((Class<Throwable>) exceptionClass));
        return this;
    }

    public ThrowableAssertion hasMessage(String expectedMessage) {
        Assert.assertThat(caught.getMessage(), Matchers.equalTo(expectedMessage));
        return this;
    }

    public ThrowableAssertion hasNoCause() {
        Assert.assertThat(caught.getCause(), Matchers.nullValue());
        return this;
    }

    public ThrowableAssertion hasCauseInstanceOf(Class<? extends Throwable> exceptionClass) {
        Assert.assertThat(caught.getCause(), Matchers.notNullValue());
        Assert.assertThat(caught.getCause(), Matchers.isA((Class<Throwable>) exceptionClass));
        return this;
    }
}
