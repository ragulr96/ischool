package com.ragulr.ischool.service;

public interface SecurityService {

	String findLoggedInUsername(); // get logged in user

	void autoLogin(String username, String password); // perform auto login on registration

	String login(String username, String password); // perform normal login
}
