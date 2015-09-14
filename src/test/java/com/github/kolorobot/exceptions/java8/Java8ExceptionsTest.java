package com.github.kolorobot.exceptions.java8;

import com.github.kolorobot.exceptions.Thrower;
import com.github.kolorobot.exceptions.BetterThrower;
import org.junit.Test;

import static com.github.kolorobot.exceptions.java8.ThrowableAssertion.assertThrown;
import static org.assertj.core.api.Assertions.assertThat;

public class Java8ExceptionsTest {

    @Test
    public void verifiesTypeAndMessage() {
        assertThrown(new Thrower()::throwsRuntime) // method reference
                // assertions
                .isInstanceOf(RuntimeException.class)
                .hasMessage("My custom runtime exception")
                .hasNoCause();
    }

    @Test
    public void verifiesCauseType() {
        assertThrown(() -> new Thrower().throwsRuntimeWithCause()) // lambda expression
                // assertions
                .isInstanceOf(RuntimeException.class)
                .hasMessage("My custom runtime exception")
                .hasCauseInstanceOf(IllegalStateException.class);
    }

    @Test
    public void verifiesCheckedExceptionThrownByDefaultConstructor() {
        assertThrown(BetterThrower::new) // constructor reference
                // assertions
                .isInstanceOf(Exception.class)
                .hasMessage("Constructor exception occurred");
    }

    @Test
    public void verifiesCheckedExceptionThrownConstructor() {
        assertThrown(() -> new BetterThrower()) // lambda expression
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
        Thrower thrower = new Thrower();

        // act
        Throwable throwable = ThrowableCaptor.captureThrowable(thrower::throwsRuntime);

        // assert
        assertThat(throwable)
                .isNotNull()
                .hasMessage("My custom runtime exception");
    }
}
