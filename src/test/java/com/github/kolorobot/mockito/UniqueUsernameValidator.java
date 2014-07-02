package com.github.kolorobot.mockito;

import com.github.kolorobot.testdata.Register;

public class UniqueUsernameValidator  {

	private UserRepository userRepository;

	/**
	 * Validates given {@link com.github.kolorobot.testdata.Register} to check if username is unique
	 * 
	 * Validation algorithm is as follows:
	 * <ul>
	 * <li>it returns true when username is null</li>
	 * <li>it returns true when username exists in repository, false otherwise</li>
	 * </ul>  
	 *
	 */
	public boolean isValid(Register value) {
		
		if (value == null) {
			throw new IllegalArgumentException("value must not be null");
		}

		if (value.getUsername() == null) {
			return true;
		}

		return !userRepository.hasUser(value.getUsername());
	}
}
