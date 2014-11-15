package com.github.kolorobot.exceptions.catchexception;

import org.junit.Test;

import static com.googlecode.catchexception.CatchException.caughtException;
import static com.googlecode.catchexception.apis.CatchExceptionAssertJ.then;
import static com.googlecode.catchexception.apis.CatchExceptionAssertJ.when;

// catch-exception library is not supported anymore, so it will not work
// with with newer libraries (e.g. mockito, assertj).
// Code left for reference, but commented out as tests would fail otherwise.
public class CatchExceptionsTest {

    @Test
    public void dummy() {

    }

//    @Test
//    public void verifiesTypeAndMessage() {
//        when(new DummyService()).someMethod();
//
//        then(caughtException())
//                .isInstanceOf(RuntimeException.class)
//                .hasMessage("Runtime exception occurred")
//                .hasMessageStartingWith("Runtime")
//                .hasMessageEndingWith("occurred")
//                .hasMessageContaining("exception")
//                .hasNoCause();
//    }
//
//    @Test
//    public void verifiesCauseType() {
//        when(new DummyService()).someOtherMethod();
//        then(caughtException())
//                .isInstanceOf(RuntimeException.class)
//                .hasMessage("Runtime exception occurred")
//                .hasCauseExactlyInstanceOf(IllegalStateException.class)
//                .hasRootCauseExactlyInstanceOf(IllegalStateException.class);
//    }

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
