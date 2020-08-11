package com.ragulr.ischool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ragulr.ischool.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUsername(String username); // find user details by username

}
