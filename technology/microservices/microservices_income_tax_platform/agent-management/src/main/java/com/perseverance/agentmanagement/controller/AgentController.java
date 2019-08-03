/**
 * 
 */
package com.perseverance.agentmanagement.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.perseverance.agentmanagement.entity.Agent;

/**
 * @author AR350758
 * AgentController.java Aug 2, 2019 5:05:09 PM
 */
@RestController
public class AgentController {

	@GetMapping("/")
	public ResponseEntity<List<Agent>> getAllAgentsInfo(){
		Agent agent = new Agent(0, "name", true, 0, new Date(), null, new Date());
		List<Agent> agentList = new ArrayList<>();
		agentList.add(agent);
		return new ResponseEntity<List<Agent>>(agentList, HttpStatus.OK);
		
	}
}
