/**
 * 
 */
package com.perseverance.agentmanagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.perseverance.agentmanagement.entity.Agent;
import com.perseverance.agentmanagement.service.AgentService;

/**
 * @author AR350758 AgentController.java Aug 2, 2019 5:05:09 PM
 */
@RestController
public class AgentController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private AgentService agentService;

	/**
	 * @param agentService
	 */
	@Autowired
	public AgentController(AgentService agentService) {
		super();
		this.agentService = agentService;
	}

	/**
	 * 
	 * @return
	 */
	@GetMapping("/agents")
	public ResponseEntity<List<Agent>> getAllAgentsInfo() {
		List<Agent> agentsList = agentService.getAllAgentsInfo();
		if (agentsList.isEmpty()) {
			return new ResponseEntity<List<Agent>>(agentsList, HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Agent>>(agentsList, HttpStatus.OK);
		}
	}

	@GetMapping("/agents/{id}")
	public ResponseEntity<Agent> getAgentById(@PathVariable(required = true) long id) {
		Agent agent = agentService.findAgentById(id);
		if (agent != null) {
			return new ResponseEntity<Agent>(agent, HttpStatus.OK);
		} else {
			return new ResponseEntity<Agent>(agent, HttpStatus.NO_CONTENT);
		}
	}

	@PostMapping("/agents")
	public ResponseEntity<Agent> createAgent(@Valid @RequestBody Agent agent ){
		return new ResponseEntity<Agent>(agentService.addAgent(agent), HttpStatus.CREATED);
	}
	
	@PutMapping("/agents/{id}")
	public ResponseEntity<Agent> updateAgent(@PathVariable(value = "id") Long id,
			@Valid @RequestBody Agent agentDetails) {
		return new ResponseEntity<Agent>(agentService.updateAgent(id, agentDetails), HttpStatus.OK);
	}

	@DeleteMapping("/agents/{id}")
	public ResponseEntity<?> deleteAgentById(@PathVariable(required = true) long id) {
		if (agentService.deleteAgentById(id)) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.badRequest().build();
		}
	}
}
