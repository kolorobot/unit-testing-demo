package com.github.kolorobot.basic;

import com.github.kolorobot.testdata.Register;
import com.github.kolorobot.testdata.RegistrationsObjectMother;
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
        Register registerObj = RegistrationsObjectMother.registration(null, "x", "x");
        // act & assert
        assertThat(validator.isValid(registerObj)).isTrue();
    }

}
