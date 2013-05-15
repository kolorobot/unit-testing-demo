package com.github.kolorobot.user;

public class UserService {
	
	private UserRepository userRepository;

	protected void initialize() {
		userRepository.save(new User("user", "demo", "ROLE_USER"));
	}
	
	public User loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException("user not found");
		}
		return user;
	}

}
