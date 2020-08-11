package com.ragulr.ischool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ragulr.ischool.entity.User;
import com.ragulr.ischool.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	/**
	 * Add new user
	 */
	@Override
	public User saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}
	
	/**
	 * Get all user details
	 */
	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
	}
	
	/**
	 * Find user by username
	 */
	@Override
	public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}
