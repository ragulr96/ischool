package com.ragulr.ischool.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class SecurityServiceImpl implements SecurityService {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;

	private static final Logger logger = LoggerFactory.getLogger(SecurityServiceImpl.class);

	/**
	 * Get logged username
	 */
	@Override
	public String findLoggedInUsername() {
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		if (principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		} else {
			return null;
		}
	}

	/**
	 * Auto login user
	 */
	@Override
	public void autoLogin(String username, String password) {

		UserDetails userDetails = userDetailsService.loadUserByUsername(username);

		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
				userDetails, password, userDetails.getAuthorities());

		if (usernamePasswordAuthenticationToken.isAuthenticated()) {
			SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			logger.debug(String.format("Auto login %s successfull!", username));
		}
	}

	/**
	 * Login user
	 */
	@Override
	public String login(String username, String password) {

		UserDetails userDetails = userDetailsServiceImpl.validateUserCredentials(username, password);

		if (userDetails == null) {
			return "Login Unsuccessfull! Input valid credentials";
		}

		else {
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
					userDetails, password, userDetails.getAuthorities());

			if (usernamePasswordAuthenticationToken.isAuthenticated()) {
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
				logger.debug(String.format("Login %s successfull!", username));
				return "Login Successfull";
			}
		}
		return null;
	}
}
