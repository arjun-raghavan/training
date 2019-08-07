/**
 * 
 */
package com.perseverance.springsecurityexample.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perseverance.springsecurityexample.model.Role;
import com.perseverance.springsecurityexample.model.RoleName;

/**
 * @author AR350758
 * RoleRepository.java Aug 7, 2019 3:26:54 PM
 */
public interface RoleRepository extends JpaRepository<Role, Long>{
	Optional<Role> findByName(RoleName roleName);
}
