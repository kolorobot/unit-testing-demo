package com.github.kolorobot.web.form;

import org.hibernate.validator.constraints.NotBlank;

import com.github.kolorobot.web.validation.SamePasswords;
import com.github.kolorobot.web.validation.UniqueUsername;

// @UniqueUsername
// @SamePasswords
public class RegistrationForm {

	@NotBlank
	private String username;

	@NotBlank
	private String password;

	private String confirmedPassword;
	
	public RegistrationForm() {

	}
	
	public RegistrationForm(String username) {
		this.username = username;
	}
	
	public RegistrationForm(String username, String password, String confirmedPassword) {
		this(username);
		this.password = password;
		this.confirmedPassword = confirmedPassword;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmedPassword() {
		return confirmedPassword;
	}

	public void setConfirmedPassword(String confirmedPassword) {
		this.confirmedPassword = confirmedPassword;
	}

}
