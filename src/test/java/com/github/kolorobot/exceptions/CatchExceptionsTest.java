package com.github.kolorobot.exceptions;

import org.junit.Test;

import static com.googlecode.catchexception.CatchException.*;
import static com.googlecode.catchexception.apis.CatchExceptionAssertJ.*;
import static org.junit.Assert.*;

public class CatchExceptionsTest {

    @Test
    public void verifiesTypeAndMessage() {
        when(new ExceptionThrower()).someMethod();

        then(caughtException())
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Runtime exception occurred")
                .hasMessageStartingWith("Runtime")
                .hasMessageEndingWith("occurred")
                .hasMessageContaining("exception")
                .hasNoCause();
    }

    @Test
    public void verifiesCauseType() {
        when(new ExceptionThrower()).someOtherMethod();
        then(caughtException())
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Runtime exception occurred")
                .hasCauseExactlyInstanceOf(IllegalStateException.class)
                .hasRootCauseExactlyInstanceOf(IllegalStateException.class);
    }

    @Test
    public void verifiesCustomException() {
        catchException(new ExceptionThrower(), CustomException.class).yetAnotherMethod(500);
        assertThat((CustomException) caughtException(), new ExceptionCodeMatcher(500));
    }
}
