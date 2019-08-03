/**
 * 
 */
package com.perseverance.agentmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perseverance.agentmanagement.entity.Agent;

/**
 * @author AR350758
 * AgentRepository.java Aug 3, 2019 8:18:43 PM
 */
public interface AgentRepository extends JpaRepository<Agent, Long>{

}
