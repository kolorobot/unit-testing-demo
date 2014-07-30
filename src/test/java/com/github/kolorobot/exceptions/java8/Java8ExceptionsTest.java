package com.github.kolorobot.exceptions.java8;

import org.junit.Test;

import static com.github.kolorobot.exceptions.java8.ThrowableAssertion.assertThrown;
import static org.assertj.core.api.Assertions.assertThat;

public class Java8ExceptionsTest {

    @Test
    public void verifiesTypeAndMessage() {
        assertThrown(new DummyService()::someMethod) // method reference
                // assertions
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Runtime exception occurred")
                .hasNoCause();
    }

    @Test
    public void verifiesCauseType() {
        assertThrown(() -> new DummyService().someOtherMethod(true)) // lambda expression
                // assertions
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Runtime exception occurred")
                .hasCauseInstanceOf(IllegalStateException.class);
    }

    @Test
    public void verifiesCheckedExceptionThrownByDefaultConstructor() {
        assertThrown(DummyService2::new) // constructor reference
                // assertions
                .isInstanceOf(Exception.class)
                .hasMessage("Constructor exception occurred");
    }

    @Test
    public void verifiesCheckedExceptionThrownConstructor() {
        assertThrown(() -> new DummyService2(true)) // lambda expression
                // assertions
                .isInstanceOf(Exception.class)
                .hasMessage("Constructor exception occurred");
    }

    @Test(expected = ExceptionNotThrownAssertionError.class) // making test pass
    public void failsWhenNoExceptionIsThrown() {
        // expected exception not thrown
        assertThrown(() -> System.out.println());
    }

    @Test
    public void aaaStyle() {
        // arrange
        DummyService dummyService = new DummyService();

        // act
        Throwable throwable = ThrowableCaptor.captureThrowable(dummyService::someMethod);

        // assert
        assertThat(throwable)
                .isNotNull()
                .hasMessage("Runtime exception occurred");
    }
}
