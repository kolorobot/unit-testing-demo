package com.github.kolorobot.exceptions.catchexception;

import org.junit.Test;

import static com.googlecode.catchexception.CatchException.caughtException;
import static com.googlecode.catchexception.apis.CatchExceptionAssertJ.then;
import static com.googlecode.catchexception.apis.CatchExceptionAssertJ.when;

public class CatchExceptionsTest {

    @Test
    public void verifiesTypeAndMessage() {
        when(new DummyService()).someMethod();

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
        when(new DummyService()).someOtherMethod();
        then(caughtException())
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Runtime exception occurred")
                .hasCauseExactlyInstanceOf(IllegalStateException.class)
                .hasRootCauseExactlyInstanceOf(IllegalStateException.class);
    }

    static class DummyService {
        public void someMethod() {
            throw new RuntimeException("Runtime exception occurred");
        }

        public void someOtherMethod() {
            throw new RuntimeException("Runtime exception occurred",
                    new IllegalStateException("Illegal state"));
        }
    }
}
