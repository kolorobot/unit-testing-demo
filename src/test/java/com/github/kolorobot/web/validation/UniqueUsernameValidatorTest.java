package com.github.kolorobot.web.validation;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UniqueUsernameValidatorTest {
	
	private UniqueUsernameValidator validator;
	
	@Before
	public void setup() {
		validator = new UniqueUsernameValidator();
	}
	
	@Test
	public void test() {
		fail("Think of some usefull tests to be written");
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
		fail("not implemented");
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
