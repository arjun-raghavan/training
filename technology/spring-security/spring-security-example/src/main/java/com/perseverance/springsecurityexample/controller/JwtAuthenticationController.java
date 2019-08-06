/**
 * 
 */
package com.perseverance.springsecurityexample.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.perseverance.springsecurityexample.auth.JwtTokenUtil;
import com.perseverance.springsecurityexample.model.JwtRequest;
import com.perseverance.springsecurityexample.model.JwtResponse;
import com.perseverance.springsecurityexample.service.JwtUserDetailsService;

/**
 * @author AR350758 JwtAuthenticationController.java Aug 6, 2019 11:41:18 AM
 */
@RestController
@CrossOrigin
public class JwtAuthenticationController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		logger.info("[createAuthenticationToken] "+authenticationRequest.toString());
		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		logger.info("[createAuthenticationToken] Authenticated. LoadUserByName");
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		logger.info("[createAuthenticationToken] userDetails:"+userDetails.toString());
		final String token = jwtTokenUtil.generateToken(userDetails);
		logger.info("[createAuthenticationToken] token"+token);
		return ResponseEntity.ok(new JwtResponse(token));
	}

	private void authenticate(String username, String password) throws Exception {
		logger.info("[authenticate] "+username+", "+password);
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			logger.info("[authenticate] USER_DISABLED");
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			logger.info("[authenticate] INVALID_CREDENTIALS");
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}
