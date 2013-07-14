package com.github.kolorobot.user;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

	@InjectMocks
	private UserService userService = new UserService();

	@Mock
	private UserRepository userRepositoryMock;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void initializesWithOneDemoUser() {
		// act
		userService.initialize();
		// assert
		verify(userRepositoryMock).save(any(User.class));
	}

	@Test
	public void throwsExceptionWhenUserNotFoundInRepository() {
		// arrange
		thrown.expect(UsernameNotFoundException.class);
		thrown.expectMessage("user not found");

		when(userRepositoryMock.findByUsername("user")).thenReturn(null);
		// act
		userService.loadUserByUsername("user");
        verify(userRepositoryMock).findByUsername("user");
	}

	@Test
	public void returnsUserDetailsWhenUserFoundInRepository() {
		// arrange
		User demoUser = new User("user", "demo", "ROLE_USER");
		when(userRepositoryMock.findByUsername("user")).thenReturn(demoUser);

		// act
		User userDetails = userService.loadUserByUsername("user");

		// assert
		assertThat(userDetails).isEqualTo((demoUser));
        verify(userRepositoryMock).findByUsername("user");
	}
}