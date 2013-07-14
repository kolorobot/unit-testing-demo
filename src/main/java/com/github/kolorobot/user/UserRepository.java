package com.github.kolorobot.user;

public interface UserRepository {

	public void save(User user);

	public User findByUsername(String username);

	public boolean hasUser(String username);

}
