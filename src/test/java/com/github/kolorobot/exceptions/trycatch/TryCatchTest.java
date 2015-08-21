package com.github.kolorobot.exceptions.trycatch;

import com.github.kolorobot.exceptions.MyCheckedException;
import com.github.kolorobot.exceptions.MyRuntimeException;
import com.github.kolorobot.exceptions.Thrower;
import org.junit.Assert;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TryCatchTest {

    private Thrower thrower = new Thrower();

    @Test
    public void throwsException() {
        try {
            thrower.throwsRuntime();
            Assert.fail("Expected exception to be thrown");
        } catch (MyRuntimeException e) {
            assertThat(e)
                .isInstanceOf(MyRuntimeException.class)
                .hasMessage("My custom runtime exception");
        }
    }

    @Test
    public void throwsDifferentExceptionThanExpected() {
        try {
            thrower.throwsRuntimeInsteadOfChecked();
            Assert.fail("Expected exception to be thrown");
        } catch (MyCheckedException e) {
            assertThat(e)
                .isInstanceOf(MyCheckedException.class)
                .hasMessage("My custom checked exception");
        }
    }
}
