/**
 * 
 */
package com.perseverance.agentmanagement.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perseverance.agentmanagement.entity.Agent;
import com.perseverance.agentmanagement.exceptions.ResourceNotFoundException;
import com.perseverance.agentmanagement.repositories.AgentRepository;

/**
 * @author AR350758 AgentService.java Aug 3, 2019 8:15:36 PM
 */
@Service
public class AgentService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	AgentRepository agentRepository;

	/**
	 * @param agentRepository
	 */
	@Autowired
	public AgentService(AgentRepository agentRepository) {
		super();
		this.agentRepository = agentRepository;
	}

	/**
	 * @return
	 * 
	 */
	public List<Agent> getAllAgentsInfo() {
		return agentRepository.findAll();
	}

	/**
	 * @param agent
	 */
	public Agent addAgent(Agent agent) {
		return agentRepository.save(agent);

	}

	/**
	 * @param id
	 * @return
	 */
	public Agent findAgentById(long id) {
		return agentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Agent", "id", id));
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public boolean deleteAgentById(long id) {
		Agent agent = agentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Agent", "id", id));
		if (agent != null) {
			agentRepository.deleteById(id);
			return true;
		}
		return false;
	}

	/**
	 * @param id
	 * @param agentDetails
	 */
	public Agent updateAgent(Long id, @Valid Agent agentDetails) {
		Agent agent = agentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Agent", "id", id));

		agent.setName(agentDetails.getName());
		agent.setActive(agentDetails.isActive());
		
		return agentRepository.save(agent);

	}

}
