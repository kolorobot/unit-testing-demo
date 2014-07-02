package com.github.kolorobot.mockito;

import com.github.kolorobot.testdata.User;

public interface UserRepository {

	public void save(User user);

	public User findByUsername(String username);

	public boolean hasUser(String username);

}
