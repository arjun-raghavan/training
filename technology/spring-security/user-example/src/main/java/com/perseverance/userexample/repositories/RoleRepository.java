/**
 * 
 */
package com.perseverance.userexample.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perseverance.userexample.model.Role;
import com.perseverance.userexample.model.RoleName;

/**
 * @author AR350758
 * RoleRepository.java Aug 7, 2019 3:26:54 PM
 */
public interface RoleRepository extends JpaRepository<Role, Long>{
	Optional<Role> findByName(RoleName roleName);

	/**
	 * @param id
	 * @return
	 */
	Optional<Role> findRoleById(Long id);
}
