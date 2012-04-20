package com.github.kolorobot.web.validation;

import static org.junit.Assert.*;

import org.junit.*;

import com.github.kolorobot.web.form.RegistrationForm;

public class UniqueUsernameValidatorTest {
	
	private UniqueUsernameValidator validator;
//	private UserRepository repo;
	
	@Before
	public void setup() {
		validator = new UniqueUsernameValidator();
	}
	
	@Test
	public void isValid_RegistrationFormIsNull_ThrowsException() {
		fail("not implemented");
	}
	
	@Test
	public void isValid_UsernameIsNull_ReturnsTrue() {
		fail("not implemented");
	}
	
	@Test
	public void isValid_UserWithGivenNameExistsInRepository_ReturnsFalse() {
		// arrange
		RegistrationForm form = new RegistrationForm("username");
		// act
		boolean result = validator.isValid(form, null);
		// assert
		// What should we assert here?
	}
	
	@Test
	public void isValid_UserWithGivenNameDoesntExistInRepository_ReturnsTrue() {
		fail("not implemented");
	}
	
	@Test
	public void isValid_UserRepositoryThrowsExceptionWhenCalled_ThrowsException() {
		fail("not implemented");
	}

}
