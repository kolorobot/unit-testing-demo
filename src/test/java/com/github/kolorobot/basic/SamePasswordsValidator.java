package com.github.kolorobot.basic;

class SamePasswordsValidator {

	/**
	 * Validates given {@link Register} to check if password and confirmedPassword
	 * are equal.
	 * 
	 * Validation algorithm is as follows:
	 * <ul>
	 * <li>it should return true when passwords match, false otherwise</li>
	 * <li>it should return false when confirmed password is null</li>
	 * <li>it should return false when password is null</li>
	 * <li>it should return true when confirmed password and password is null</li>
	 * </ul>
	 */
	boolean isValid(Register value) {

		if (value == null) {
			throw new IllegalArgumentException("argument cannot be null");
		}

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
