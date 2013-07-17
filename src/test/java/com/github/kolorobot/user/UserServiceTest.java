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

    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @InjectMocks
    private UserService userService = new UserService();
    @Mock
    private UserRepository userRepositoryMock;

    @Test
    public void initializesWithOneDemoUser() {
        // act
        userService.initialize();
        // assert
        verify(userRepositoryMock).save(any(User.class));
        verifyNoMoreInteractions(userRepositoryMock);
    }

    @Test
    public void throwsExceptionWhenUserNotFoundInRepository() {
        // arrange
        thrown.expect(UsernameNotFoundException.class);
        thrown.expectMessage("user not found");

        when(userRepositoryMock.findByUsername("user")).thenReturn(null);
        // act
        userService.loadUserByUsername("user");
        // assert
        verify(userRepositoryMock).findByUsername("user");
        verifyNoMoreInteractions(userRepositoryMock);
    }

    @Test
    public void returnsUserDetailsWhenUserFoundInRepository() {
        // arrange
        User user = TestUsers.aUser().build();
        when(userRepositoryMock.findByUsername(user.getUsername())).thenReturn(user);

        // act
        User userDetails = userService.loadUserByUsername(user.getUsername());

        // assert
        assertThat(userDetails).isEqualTo((user));
        verify(userRepositoryMock).findByUsername(user.getUsername());
        verifyNoMoreInteractions(userRepositoryMock);
    }
}