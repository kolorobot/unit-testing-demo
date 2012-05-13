package com.github.kolorobot.web.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.github.kolorobot.web.form.RegistrationForm;

public class SamePasswordsValidator implements ConstraintValidator<SamePasswords, RegistrationForm> {

	@Override
	public void initialize(SamePasswords constraintAnnotation) {
	}

	@Override
	public boolean isValid(RegistrationForm value, ConstraintValidatorContext context) {

		String password = value.getPassword();
		String confirmedPassword = value.getConfirmedPassword();

		if (bothAreNull(password, confirmedPassword)) {
			return true;
		}

		if (atLeastOneIsNull(password, confirmedPassword)) {
			return false;
		}
		
		return confirmedPassword.equals(password);
	}

	private boolean atLeastOneIsNull(String arg1, String arg2) {
		return arg1 == null || arg2 == null;
	}

	private boolean bothAreNull(String arg1, String arg2) {
		return arg1 == null && arg2 == null;
	}
}
