package com.github.kolorobot.domain;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Collection;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

	@InjectMocks
	private UserService userService = new UserService();

	@Mock
	private UserRepository userRepositoryMock;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

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
		UserDetails userDetails = userService.loadUserByUsername("user");

		// assert
		assertThat(userDetails, new IsDescribedBy(demoUser));
	}
	
	private static class IsDescribedBy extends TypeSafeMatcher<UserDetails> {

		private final User user;

		private IsDescribedBy(User user) {
			this.user = user;
		}

		@Override
		public void describeTo(Description description) {}

		@Override
		protected boolean matchesSafely(UserDetails item) {
			return user.getUsername().equals(item.getUsername())
					&& user.getPassword().equals(item.getPassword())
					&& hasAuthority(item, user.getRole());
		}

		private static boolean hasAuthority(UserDetails userDetails, String role) {
			Collection<? extends GrantedAuthority> authorities = userDetails
					.getAuthorities();
			for (GrantedAuthority authority : authorities) {
				if (authority.getAuthority().equals(role)) {
					return true;
				}
			}
			return false;
		}
	}
}