package com.ragulr.ischool.service;

import java.util.List;

import com.ragulr.ischool.entity.User;

public interface UserService {

	User saveUser(User user); // add new user

	List<User> getUsers(); // get all user details

	User findByUsername(String username); // get user details by username

}
