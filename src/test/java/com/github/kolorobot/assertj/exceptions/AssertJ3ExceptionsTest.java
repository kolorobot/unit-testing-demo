package com.github.kolorobot.assertj.exceptions;

import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class AssertJ3ExceptionsTest {

    @Test
    public void verifiesTypeAndMessage() {
        assertThatThrownBy(new DummyService()::someMethod) // method reference
                // assertions
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Runtime exception occurred")
                .hasNoCause();
    }

    @Test
    public void verifiesCauseType() {
        assertThatThrownBy(() -> new DummyService().someOtherMethod(true)) // lambda expression
                // assertions
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Runtime exception occurred")
                .hasCauseInstanceOf(IllegalStateException.class);
    }

    @Test
    public void verifiesCheckedExceptionThrownByDefaultConstructor() {
        assertThatThrownBy(DummyService2::new) // constructor reference
                // assertions
                .isInstanceOf(Exception.class)
                .hasMessage("Constructor exception occurred");
    }

    @Test
    public void verifiesCheckedExceptionThrownConstructor() {
        assertThatThrownBy(() -> new DummyService2(true)) // lambda expression
                // assertions
                .isInstanceOf(Exception.class)
                .hasMessage("Constructor exception occurred");
    }

    @Ignore // normally, it would fail
    @Test
    public void failsWhenNoExceptionIsThrown() {
        // expected exception not thrown
        assertThatThrownBy(() -> System.out.println());
    }

    @Test
    public void aaaStyle() {
        // arrange
        DummyService dummyService = new DummyService();

        // act
        Throwable throwable = catchThrowable(dummyService::someMethod);

        // assert
        assertThat(throwable)
                .isNotNull()
                .hasMessage("Runtime exception occurred");
    }
}
