package com.github.kolorobot.user;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

	@InjectMocks
	private UserService userService = new UserService();

	@Mock
	private UserRepository userRepositoryMock;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Before
	public void before() {

	}

	@Test
	public void shouldInitializeWithOneDemoUser() {
		// act
		userService.initialize();
		// assert
		verify(userRepositoryMock).save(any(User.class));
	}

	@Test
	public void shouldThrowExceptionWhenUserNotFound() {
		// arrange
		thrown.expect(UsernameNotFoundException.class);
		thrown.expectMessage("user not found");

		when(userRepositoryMock.findByUsername("user")).thenReturn(null);
		// act
		userService.loadUserByUsername("user");
	}

	@Test
	public void shouldReturnUserDetails() {
		// arrange
		User demoUser = new User("user", "demo", "ROLE_USER");
		when(userRepositoryMock.findByUsername("user")).thenReturn(demoUser);

		// act
		User userDetails = userService.loadUserByUsername("user");

		// assert
		assertThat(userDetails, equalTo((demoUser)));
	}
}