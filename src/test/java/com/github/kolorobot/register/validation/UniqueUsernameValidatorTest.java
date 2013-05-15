package com.github.kolorobot.register.validation;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import com.github.kolorobot.register.Register;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.github.kolorobot.user.UserRepository;

@RunWith(MockitoJUnitRunner.class)
public class UniqueUsernameValidatorTest {
	
	private static final String USERNAME = "username";
	
	@InjectMocks
	private UniqueUsernameValidator validator = new UniqueUsernameValidator();
	@Mock
	private UserRepository userRepositoryMock;
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	@Test
	public void shouldFailWhenGivenFormIsNull() {
		
	}
	
	@Test
	public void shouldReturnFalseWhenUserExists() {
		// arrange
		Register form = arrangeRegistrationForm(USERNAME);
		when(userRepositoryMock.hasUser(USERNAME)).thenReturn(true);
		// act
		boolean result = validator.isValid(form);

		// assert
		assertThat(result, is(false));
		verify(userRepositoryMock).hasUser(USERNAME);
		
	}
	
	@Test
	public void shouldReturnTrueWhenGivenUsernameIsNull() {
		// arrange
		Register form = arrangeRegistrationForm(null);
		
		// act
		boolean result = validator.isValid(form);
		
		// assert
		
	}

	@Test
	public void shouldReturnTrueWhenUserDoesNotExist() {
		// arrange
		Register form = arrangeRegistrationForm(USERNAME);
		
		// act
		boolean result = validator.isValid(form);
		
		// assert

	}
	
	@Test
	public void shouldFailWhenUserRepositoryThrowsException() {
		
	}
	
	private Register arrangeRegistrationForm(String username) {
		Register form = new Register();
		form.setUsername(username);
		return form;
	}
}
