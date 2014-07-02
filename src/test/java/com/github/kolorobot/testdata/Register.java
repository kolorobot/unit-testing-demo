package com.github.kolorobot.testdata;

public class Register {

	private String username;

	private String password;

	private String confirmedPassword;

	public Register(String username) {
		this.username = username;
	}

	public Register(String username, String password, String confirmedPassword) {
		this(username);
		this.password = password;
		this.confirmedPassword = confirmedPassword;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getConfirmedPassword() {
		return confirmedPassword;
	}

}
