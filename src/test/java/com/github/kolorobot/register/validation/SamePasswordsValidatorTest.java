package com.github.kolorobot.register.validation;

import com.github.kolorobot.register.Register;
import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class SamePasswordsValidatorTest {

    private SamePasswordsValidator validator;

    @Before
    public void setup() {
        validator = new SamePasswordsValidator();
    }

    @Test
    public void isValidWhenPasswordsMatch() {
        // arrange
        Register registerObj = new Register(null, "x", "x");
        // act & assert
        assertThat(validator.isValid(registerObj)).isTrue();
    }

}
