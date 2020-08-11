package com.ragulr.ischool.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Qualifier("userDetailsServiceImpl")
	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/**
	 * Method for granting permission for registered users
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.POST, "/addUser").permitAll()
				.antMatchers(HttpMethod.POST, "/login").permitAll().antMatchers(HttpMethod.POST, "/addStudent")
				.hasAnyAuthority("ROLE_REGISTRAR").antMatchers(HttpMethod.POST, "/addStudents")
				.hasAnyAuthority("ROLE_REGISTRAR").antMatchers(HttpMethod.DELETE, "/deleteStudent")
				.hasAnyAuthority("ROLE_REGISTRAR").antMatchers(HttpMethod.POST, "/addSubject")
				.hasAnyAuthority("ROLE_REGISTRAR").antMatchers(HttpMethod.POST, "/addSubjects")
				.hasAnyAuthority("ROLE_REGISTRAR").antMatchers(HttpMethod.DELETE, "/deleteSubject")
				.hasAnyAuthority("ROLE_REGISTRAR").antMatchers(HttpMethod.POST, "/addStatement")
				.hasAnyAuthority("ROLE_BURSAR").anyRequest().authenticated().and().logout().permitAll();

	}

	@Bean
	public AuthenticationManager customAuthenticationManager() throws Exception {
		return authenticationManager();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	}
}
