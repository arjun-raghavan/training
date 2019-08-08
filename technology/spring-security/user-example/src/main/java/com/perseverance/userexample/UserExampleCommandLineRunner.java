/**
 * 
 */
package com.perseverance.userexample;

import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.perseverance.userexample.model.Role;
import com.perseverance.userexample.model.RoleName;
import com.perseverance.userexample.model.User;
import com.perseverance.userexample.repositories.RoleRepository;
import com.perseverance.userexample.repositories.UserRepository;

/**
 * @author AR350758 UserExampleCommandLineRunner.java Aug 3, 2019 9:00:43 PM
 */
@Component
public class UserExampleCommandLineRunner implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User user = new User("Arjun Raghavan M", "arjun-raghavan", "arjun24ster@gmail.com", "password");
		Role userRole = roleRepository.findByName(RoleName.ROLE_AGENT)
				.orElseThrow(() -> new Exception("User Role not set."));
		user.setRoles(Collections.singleton(userRole));
		
		User result = userRepository.save(user);
		
		Role resultRole = roleRepository.findRoleById(result.getId())
				.orElseThrow(() -> new Exception("User Role not set."));
		
		logger.info("Role of user : "+result.getName()+" is "+resultRole.getName());
	}

}
