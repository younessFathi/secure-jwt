package com.security.service;

import java.util.ArrayList;
import java.util.Objects;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @author Youness FATHI The Class JwtUserDetailsService. is to load User
 *         Information from DB
 */
@Component
public class JwtUserDetailsService implements UserDetailsService {

	@Override
	// For fetching user details from the database using the username
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if (Objects.equals("youness", username))
			return new User("youness", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
					new ArrayList<>());
		else
			throw new UsernameNotFoundException("User not found with username: " + username);
	}

}
