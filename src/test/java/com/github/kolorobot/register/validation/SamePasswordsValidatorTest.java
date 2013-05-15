package com.github.kolorobot.register.validation;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import com.github.kolorobot.register.Register;
import org.junit.Before;
import org.junit.Test;

public class SamePasswordsValidatorTest {
	
	private SamePasswordsValidator validator;
	
	@Before
	public void setup() {
		validator = new SamePasswordsValidator();
	}
	
	@Test
	public void shouldReturnTrueWhenPasswordsMatch() {
		// arrange
		Register registerObj = new Register(null, "x", "x");
		// act
		boolean result = validator.isValid(registerObj);
		// assert
		assertThat(result, is(true));
	}
	
}
