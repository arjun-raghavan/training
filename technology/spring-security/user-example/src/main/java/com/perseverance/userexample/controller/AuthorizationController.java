/**
 * 
 */
package com.perseverance.userexample.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.perseverance.userexample.payload.SignUpRequest;
import com.perseverance.userexample.service.UserService;

/**
 * @author AR350758 AuthorizationController.java Aug 8, 2019 11:52:28 AM
 */
@RestController
@RequestMapping("/api")
public class AuthorizationController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserService userService;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser() {
		return ResponseEntity.ok("ToDo");
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest, HttpServletRequest request)
			throws Exception {
		return new ResponseEntity(userService.registerUser(signUpRequest), HttpStatus.CREATED);
	}

}
