package com.github.kolorobot.exceptions.java8;

import com.github.kolorobot.exceptions.Thrower;
import com.github.kolorobot.exceptions.BetterThrower;
import org.junit.Test;

import static com.github.kolorobot.exceptions.java8.AssertJThrowableAssert.assertThrown;

// http://stackoverflow.com/questions/23324819/catch-exception-library-not-working-as-expected-what-is-wrong-with-this-code-be
public class AssertJJava8ExceptionsTest {

    @Test
    public void verifiesTypeAndMessage() {
        assertThrown(new Thrower()::throwsRuntime)
                .isInstanceOf(RuntimeException.class)
                .hasMessage("My custom runtime exception")
                .hasMessageStartingWith("My custom")
                .hasMessageEndingWith("occurred")
                .hasMessageContaining("exception")
                .hasNoCause();
    }

    @Test
    public void verifiesCauseType() {
        assertThrown(() -> new Thrower().throwsRuntimeWithCause())
                .isInstanceOf(RuntimeException.class)
                .hasMessage("My custom runtime exception")
                .hasCauseExactlyInstanceOf(IllegalStateException.class)
                .hasRootCauseExactlyInstanceOf(IllegalStateException.class);
    }

    @Test
    public void verifiesCheckedExceptionThrownByConstructor() {
        assertThrown(BetterThrower::new)
                .isInstanceOf(Exception.class)
                .hasMessage("Constructor exception occurred");

        assertThrown(() -> new BetterThrower())
                .isInstanceOf(Exception.class)
                .hasMessage("Constructor exception occurred");
    }

}
