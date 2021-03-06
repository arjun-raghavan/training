/**
 * 
 */
package com.perseverance.springsecurityexample.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author AR350758 JwtUserDetailsService.java Aug 6, 2019 11:54:58 AM
 */
@Service
public class JwtUserDetailsService implements UserDetailsService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info("[JwtUserDetailsService].[loadUserByUsername]");
		if ("arjun-test".equals(username)) {
			return new User("arjun-test", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
					new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}

}
