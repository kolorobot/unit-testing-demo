package com.github.kolorobot.exceptions.junit5;

import com.github.kolorobot.exceptions.MyCheckedException;
import com.github.kolorobot.exceptions.MyRuntimeException;
import com.github.kolorobot.exceptions.Thrower;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class Junit5ExceptionTestingTest { // non public, new to JUnit5

    @Test
    @DisplayName("Junit5 built-in Assertions.assertThrows and Assertions.assertAll")
    @Tag("exception-testing")
    void verifiesTypeAndMessage() {
        Throwable throwable = assertThrows(MyRuntimeException.class, new Thrower()::throwsRuntime);

        assertAll(
            () -> assertEquals("My custom runtime exception", throwable.getMessage()),
            () -> assertNull(throwable.getCause())
        );
    }

    @Test
    @Disabled
    void assertsAll(TestInfo testInfo, TestReporter testReporter) {
        Thrower thrower = new Thrower();

        System.out.println(testInfo.getTestClass().get() + ": " + testInfo.getTestMethod().get());

        assertAll("Exception testing in JUnit5",
            () -> assertThrows(MyRuntimeException.class, thrower::throwsChecked),
            () -> assertThrows(MyCheckedException.class, thrower::throwsRuntimeWithCause),
            () -> assertThrows(MyRuntimeException.class, thrower::throwsRuntimeInsteadOfChecked)
        );
    }
}
