package com.github.kolorobot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.github.kolorobot.domain.User;
import com.github.kolorobot.domain.UserRepository;
import com.github.kolorobot.web.form.RegistrationForm;

@Controller
@RequestMapping("register")
public class RegistrationController {
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public void register(Model model) {
		model.addAttribute(new RegistrationForm());
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String register(@ModelAttribute @Validated 
			RegistrationForm registrationForm, Errors errors) {
		
		if(errors.hasErrors()) {
			return "register";
		}
		
		User user = new User(registrationForm.getUsername(), registrationForm.getPassword(), "ROLE_USER");
		user.setName(registrationForm.getName());
		userRepository.save(user);
		
		return "redirect:user";
	}
}
