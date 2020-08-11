package com.ragulr.ischool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ragulr.ischool.entity.User;
import com.ragulr.ischool.service.SecurityServiceImpl;
import com.ragulr.ischool.service.UserServiceImpl;
import com.ragulr.ischool.validator.UserValidator;

@RestController
public class UserController {

	@Autowired
	private UserServiceImpl userService;

	@Autowired
	private SecurityServiceImpl securityService;

	@Autowired
	private UserValidator userValidator;

	/**
	 * Add new user
	 * @param user
	 * @param bindingResult
	 * @return
	 */
	@PostMapping("/addUser")
	public String addUser(@RequestBody User user, BindingResult bindingResult) {

		userValidator.validate(user, bindingResult); // validate credentials

		if (bindingResult.hasErrors()) {
			return "User Registration Failed! Input Valid Details";
		}

		userService.saveUser(user); // add user

		securityService.autoLogin(user.getUsername(), user.getPassword()); // perform auto login on registration

		return "User Added Successfully!";
	}

	/**
	 * Get all user details
	 * @return
	 */
	@GetMapping("/users")
	public List<User> findAllUsers() {
		return userService.getUsers();
	}

	/**
	 * Login user
	 * @param username
	 * @param password
	 * @return
	 */
	@PostMapping("/login")
	public String login(@RequestParam String username, @RequestParam String password) {

		return securityService.login(username, password); // perform normal login

	}

	@GetMapping("/login")
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("error", "Your username and password is invalid.");

		if (logout != null)
			model.addAttribute("message", "You have been logged out successfully.");

		return "logged out";
	}
}
