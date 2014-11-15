package com.github.kolorobot.exceptions.java8;

import org.junit.Test;

import static com.github.kolorobot.exceptions.java8.AssertJThrowableAssert.assertThrown;

// http://stackoverflow.com/questions/23324819/catch-exception-library-not-working-as-expected-what-is-wrong-with-this-code-be
public class AssertJJava8ExceptionsTest {

    @Test
    public void verifiesTypeAndMessage() {
        assertThrown(new DummyService()::someMethod)
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Runtime exception occurred")
                .hasMessageStartingWith("Runtime")
                .hasMessageEndingWith("occurred")
                .hasMessageContaining("exception")
                .hasNoCause();
    }

    @Test
    public void verifiesCauseType() {
        assertThrown(() -> new DummyService().someOtherMethod(true))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Runtime exception occurred")
                .hasCauseExactlyInstanceOf(IllegalStateException.class)
                .hasRootCauseExactlyInstanceOf(IllegalStateException.class);
    }

    @Test
    public void verifiesCheckedExceptionThrownByConstructor() {
        assertThrown(DummyService2::new)
                .isInstanceOf(Exception.class)
                .hasMessage("Constructor exception occurred");

        assertThrown(() -> new DummyService2(true))
                .isInstanceOf(Exception.class)
                .hasMessage("Constructor exception occurred");
    }

}
