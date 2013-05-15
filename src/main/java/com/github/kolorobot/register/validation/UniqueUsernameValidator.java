package com.github.kolorobot.register.validation;

import com.github.kolorobot.user.UserRepository;
import com.github.kolorobot.register.Register;

public class UniqueUsernameValidator  {

	private UserRepository userRepository;

	/**
	 * Validates given {@link com.github.kolorobot.register.Register} to check if username is unique
	 * 
	 * Validation algorithm is as follows:
	 * <ul>
	 * <li>it should return true when username is null</li>
	 * <li>it should return true when username exists in repository, false otherwise</li> 
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
