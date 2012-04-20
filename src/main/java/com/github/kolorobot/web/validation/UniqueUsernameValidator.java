package com.github.kolorobot.web.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.kolorobot.domain.UserRepository;
import com.github.kolorobot.web.form.RegistrationForm;

public class UniqueUsernameValidator implements
		ConstraintValidator<UniqueUsername, RegistrationForm> {

	private UserRepository userRepository;
	
	public UniqueUsernameValidator() {
		// what is wrong here?
		userRepository = new UserRepository();
	}
	
	@Override
	public void initialize(UniqueUsername constraintAnnotation) {
		// intentionally left blank
	}

	@Override
	public boolean isValid(RegistrationForm value,
			ConstraintValidatorContext context) {
		
		if (value == null) {
			throw new IllegalArgumentException("value must not be null");
		}

		if (value.getUsername() == null) {
			return true;
		}

		return !userRepository.hasUser(value.getUsername());
	}
}
