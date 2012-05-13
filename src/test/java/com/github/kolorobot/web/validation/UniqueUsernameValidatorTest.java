package com.github.kolorobot.web.validation;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.github.kolorobot.domain.UserRepository;
import com.github.kolorobot.web.form.RegistrationForm;

@RunWith(MockitoJUnitRunner.class)
public class UniqueUsernameValidatorTest {
	
	private static final String USERNAME_DEFAULT = "username";
	@InjectMocks
	private UniqueUsernameValidator validator = new UniqueUsernameValidator();
	@Mock
	private UserRepository repo;
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void shouldFaileWhenGivenFormIsNull() {
		thrown.expect(IllegalArgumentException.class);
		validator.isValid(null, null);
		verifyZeroInteractions(repo);
	}
	
	@Test
	public void shouldReturnTrueWhenGivenUsernameIsNull() {
		// arrange
		RegistrationForm form = new RegistrationForm(null);
		
		// act
		boolean result = validator.isValid(form, null);

		// assert
		assertThat(result, is(true));
		verifyZeroInteractions(repo);
	}
	
	@Test
	public void shouldReturnFalseWhenUserExists() {
		// arrange
		RegistrationForm form = new RegistrationForm(USERNAME_DEFAULT);
		when(repo.hasUser(anyString())).thenReturn(true);
		
		// act
		boolean result = validator.isValid(form, null);

		// assert
		verify(repo).hasUser(USERNAME_DEFAULT);
		assertThat(result, is(false));
	}
	
	@Test
	public void shouldReturnTrueWhenUserDoesNotExist() {
		// arrange
		RegistrationForm form = new RegistrationForm(USERNAME_DEFAULT);
		when(repo.hasUser(anyString())).thenReturn(false);
		
		// act
		boolean result = validator.isValid(form, null);

		// assert
		verify(repo).hasUser(USERNAME_DEFAULT);
		assertThat(result, is(true));
	}
}
