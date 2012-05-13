package com.github.kolorobot.web.validation;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.github.kolorobot.web.form.RegistrationForm;

public class SamePasswordsValidatorTest {
	
	private SamePasswordsValidator validator;
	
	@Before
	public void setup() {
		validator = new SamePasswordsValidator();
	}
	
	@Test
	public void shouldReturnFalseWhenConfirmedPasswordIsNull() {
		RegistrationForm value = new RegistrationForm(null, "password", null);
		assertThat(validator.isValid(value, null), is(false));
	}
	
	@Test
	public void shouldReturnFalseWhenPasswordIsNull() {
		RegistrationForm value = new RegistrationForm(null, null, "password");
		assertThat(validator.isValid(value, null), is(false));
	}
	
	@Test
	public void shouldReturnTrueWhenPasswordAndConfirmedPasswordIsNull() {
		RegistrationForm value = new RegistrationForm(null, null, null);
		assertThat(validator.isValid(value, null), is(true));
	}
	
	@Test
	public void shouldReturnTrueWhenPasswordsMatch() {
		RegistrationForm value = new RegistrationForm(null, "password", "password");
		assertThat(validator.isValid(value, null), is(true));
	}

}
