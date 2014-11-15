package com.github.kolorobot.basic;

import com.github.kolorobot.testdata.Register;
import org.junit.Before;
import org.junit.Test;

import static com.github.kolorobot.testdata.RegistrationsObjectMother.registrationWithNoUsername;
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
        Register registerObj = registrationWithNoUsername("x", "x");
        // act & assert
        assertThat(validator.isValid(registerObj)).isTrue();
    }

    @Test
    public void notValidWhenPasswordsDoNotMatch() {
        // arrange
        Register registerObj = registrationWithNoUsername("x", "y");
        // act & assert
        assertThat(validator.isValid(registerObj)).isFalse();
    }
}
