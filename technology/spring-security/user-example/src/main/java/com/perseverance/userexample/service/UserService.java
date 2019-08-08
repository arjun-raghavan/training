/**
 * 
 */
package com.perseverance.userexample.service;

import java.util.Collections;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.perseverance.userexample.exceptions.InvalidRoleException;
import com.perseverance.userexample.exceptions.UnknownException;
import com.perseverance.userexample.exceptions.InvalidArgumentsException;
import com.perseverance.userexample.model.Role;
import com.perseverance.userexample.model.RoleName;
import com.perseverance.userexample.model.User;
import com.perseverance.userexample.payload.SignUpRequest;
import com.perseverance.userexample.repositories.RoleRepository;
import com.perseverance.userexample.repositories.UserRepository;

/**
 * @author AR350758 UserService.java Aug 8, 2019 11:00:48 AM
 */
@Service
public class UserService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private UserRepository userRepository;
	private RoleRepository roleRepository;

	/**
	 * @param userRepository
	 * @param roleRepository
	 */
	public UserService(UserRepository userRepository, RoleRepository roleRepository) {
		super();
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}

	/**
	 * 
	 * @param user
	 * @return
	 */
	public User addAgent(User user) {
		return userRepository.save(user);
	}

	/**
	 * @param signUpRequest
	 * @return
	 * @throws Exception
	 */
	public User registerUser(@Valid SignUpRequest signUpRequest) throws Exception {
		// Check if user exists by username
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			throw new InvalidArgumentsException("Username exists");
		}

		// check if user exists by email
		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			throw new InvalidArgumentsException("Email exists");
		}
		// JPA checks doesn't give guarantee on uniqueness - concurrent transaction - so
		// add @Column(unique = true)

		User user = new User(signUpRequest.getName(), signUpRequest.getUsername(), signUpRequest.getEmail(),
				signUpRequest.getPassword());
		// user.setPassword(passwordEncoder.encode(user.getPassword()));
		Role userRole = roleRepository.findByName(RoleName.ROLE_AGENT)
				.orElseThrow(() -> new InvalidRoleException("User Role not set."));
		user.setRoles(Collections.singleton(userRole));
		User newUser = userRepository.save(user);
		if (newUser != null) {
			return newUser;
		} else {
			throw new UnknownException("Failed to register user");
		}
	}

}
