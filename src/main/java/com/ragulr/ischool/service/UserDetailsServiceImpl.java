package com.ragulr.ischool.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ragulr.ischool.entity.Role;
import com.ragulr.ischool.entity.User;
import com.ragulr.ischool.repository.RoleRepository;
import com.ragulr.ischool.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.findByUsername(username); // find user by userName

		if (user == null)
			throw new UsernameNotFoundException(username);

		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

		for (Role role : user.getRoles()) {

			Role rl = roleRepository.findById(role.getRoleId()).orElse(null); // find roles assigned
			String roleName = rl.getRoleName();

			grantedAuthorities.add(new SimpleGrantedAuthority(roleName)); // grant permissions for users
		}

		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				grantedAuthorities);
	}

	public UserDetails validateUserCredentials(String username, String password) {

		bCryptPasswordEncoder = new BCryptPasswordEncoder();

		User user = userRepository.findByUsername(username); // find user by userName

		if (user == null) {
			return null;
		} else if (bCryptPasswordEncoder.matches(password, user.getPassword())) { // validate matching passwords

			Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

			for (Role role : user.getRoles()) {

				Role rl = roleRepository.findById(role.getRoleId()).orElse(null); // find roles assigned
				String roleName = rl.getRoleName();

				grantedAuthorities.add(new SimpleGrantedAuthority(roleName)); // grant permissions for users
			}

			return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
					grantedAuthorities);
		} else {
			return null;
		}
	}

}
