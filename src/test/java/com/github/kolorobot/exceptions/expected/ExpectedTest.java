package com.github.kolorobot.exceptions.expected;

import com.github.kolorobot.exceptions.MyCheckedException;
import com.github.kolorobot.exceptions.MyRuntimeException;
import com.github.kolorobot.exceptions.Thrower;
import org.junit.Test;

public class ExpectedTest {

    private Thrower thrower = new Thrower();

    @Test(expected = MyRuntimeException.class)
    public void throwsException() {
        thrower.throwsRuntime();
    }

    @Test(expected = MyCheckedException.class)
    public void throwsDifferentExceptionThanExpected() throws MyCheckedException {
        thrower.throwsRuntimeInsteadOfChecked();
    }

    @Test(expected = MyRuntimeException.class)
    public void noExceptionThrown() {

    }

    @Test(expected = RuntimeException.class)
    public void misleading() {
        thrower.throwsRuntime(); // assume this is unexpected exception
        throw new RuntimeException();
    }

    @Test(expected = RuntimeException.class)
    public void misleading2() {
        thrower.throwsRuntimeWithCause(); // MyRuntimeException extends from RuntimeException
    }
}
