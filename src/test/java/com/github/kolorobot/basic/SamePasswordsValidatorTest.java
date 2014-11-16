package com.github.kolorobot.basic;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SamePasswordsValidatorTest {

    private SamePasswordsValidator validator;

    @Before
    public void setup() {
        validator = new SamePasswordsValidator();
    }

    @Test
    public void isValidWhenPasswordsMatch() {
        // arrange
        Register register = Register.builder()
                .withPassword("x")
                .withConfirmedPassword("x")
                .build();

        // act & assert
        assertThat(validator.isValid(register)).isTrue();
    }

    @Test
    public void notValidWhenPasswordsDoNotMatch() {
        // arrange
        Register register = Register.builder()
                .withPassword("x")
                .withConfirmedPassword("y")
                .build();

        // act & assert
        assertThat(validator.isValid(register)).isFalse();
    }
}
