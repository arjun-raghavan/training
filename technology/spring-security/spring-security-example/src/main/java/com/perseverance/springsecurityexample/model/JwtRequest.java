/**
 * 
 */
package com.perseverance.springsecurityexample.model;

import java.io.Serializable;

/**
 * @author AR350758 JwtRequest.java Aug 6, 2019 11:51:33 AM
 */
public class JwtRequest implements Serializable {

	private static final long serialVersionUID = -4154087688866087194L;
	
	private String username;
	private String password;

	// need default constructor for JSON Parsing
	public JwtRequest() {
	}

	public JwtRequest(String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
