package com.github.kolorobot.exceptions.java8;

import org.junit.Test;

import static com.github.kolorobot.exceptions.java8.ThrowableAssertion.assertThrown;

public class Java8ExceptionsTest {

    @Test
    public void verifiesTypeAndMessage() {
        assertThrown(new DummyService()::someMethod)
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Runtime exception occurred")
                .hasNoCause();
    }

    @Test
    public void verifiesCauseType() {
        assertThrown(new DummyService()::someOtherMethod)
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Runtime exception occurred")
                .hasCauseInstanceOf(IllegalStateException.class);
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
