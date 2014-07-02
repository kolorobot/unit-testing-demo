package com.github.kolorobot.mockito;

import static com.github.kolorobot.testdata.RegistrationsObjectMother.registrationWithNoPassword;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import com.github.kolorobot.testdata.Register;
import com.github.kolorobot.testdata.RegistrationsObjectMother;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UniqueUsernameValidatorTest {

    private static final String USERNAME = "username";

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @InjectMocks
    private UniqueUsernameValidator validator = new UniqueUsernameValidator();

    @Mock
    private UserRepository userRepositoryMock;

    @Test
    public void throwsExceptionWhenGivenArgumentIsNull() {
        // arrange
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("value must not be null");
        // act
        assertThat(validator.isValid(null)).isFalse();
    }

    @Test
    public void isNotValidWhenUserFoundInRepository() {
        // arrange
        Register form = registrationWithNoPassword(USERNAME);
        when(userRepositoryMock.hasUser(USERNAME)).thenReturn(true);

        // act
        boolean result = validator.isValid(form);

        // assert
        assertThat(result).isFalse();
        verify(userRepositoryMock).hasUser(USERNAME);
        verifyNoMoreInteractions(userRepositoryMock);
    }

    @Test
    public void isValidWhenGivenUsernameIsNull() {
        // arrange
        Register form = registrationWithNoPassword(null);

        // act
        boolean result = validator.isValid(form);

        // assert
        assertThat(result).isTrue();
    }

    @Test
    public void isValidWhenUserDoesNotExist() {
        // arrange
        Register form = registrationWithNoPassword(USERNAME);
        when(userRepositoryMock.hasUser(USERNAME)).thenReturn(false);

        // act
        boolean result = validator.isValid(form);

        // assert
        assertThat(result).isTrue();
        verify(userRepositoryMock).hasUser(USERNAME);
        verifyNoMoreInteractions(userRepositoryMock);
    }

    @Test
    public void failsWhenUserRepositoryThrowsException() {
        // arrange
        thrown.expect(RuntimeException.class);
        Register form = registrationWithNoPassword(USERNAME);
        when(userRepositoryMock.hasUser(USERNAME)).thenThrow(RuntimeException.class);

        // act
        boolean result = validator.isValid(form);

        // assert
        assertThat(result).isTrue();
        verify(userRepositoryMock).hasUser(USERNAME);
        verifyNoMoreInteractions(userRepositoryMock);
    }


}
