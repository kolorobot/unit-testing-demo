package com.github.kolorobot.assertj.exceptions;

import com.github.kolorobot.exceptions.BetterThrower;
import com.github.kolorobot.exceptions.MyRuntimeException;
import com.github.kolorobot.exceptions.Thrower;
import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class AssertJ3ExceptionsTest {

    @Test
    public void verifiesTypeAndMessage() {
        assertThatThrownBy(new Thrower()::throwsRuntime) // method reference
            // assertions
            .isInstanceOf(MyRuntimeException.class)
            .hasMessage("My custom runtime exception")
            .hasNoCause();
    }

    @Test
    public void verifiesCauseType() {
        assertThatThrownBy(() -> new Thrower().throwsRuntimeWithCause()) // lambda expression
            // assertions
            .isInstanceOf(MyRuntimeException.class)
            .hasMessage("My custom runtime exception")
            .hasCauseInstanceOf(IllegalStateException.class);
    }

    @Test
    public void verifiesCheckedExceptionThrownByDefaultConstructor() {
        assertThatThrownBy(BetterThrower::new) // constructor reference
            // assertions
            .isInstanceOf(Exception.class)
            .hasMessage("Constructor exception occurred");
    }

    @Test
    public void verifiesCheckedExceptionThrownConstructor() {
        assertThatThrownBy(() -> new BetterThrower()) // lambda expression
            // assertions
            .isInstanceOf(Exception.class)
            .hasMessage("Constructor exception occurred");
    }

    @Test
    public void failsWhenNoExceptionIsThrown() {
        // expected exception not thrown
        assertThatThrownBy(() -> System.out.println());
    }

    @Test
    public void aaaStyle() {
        // arrange
        Thrower Thrower = new Thrower();

        // act
        Throwable throwable = catchThrowable(Thrower::throwsRuntime);

        // assert
        assertThat(throwable)
            .isNotNull()
            .hasMessage("My custom runtime exception");
    }
}
