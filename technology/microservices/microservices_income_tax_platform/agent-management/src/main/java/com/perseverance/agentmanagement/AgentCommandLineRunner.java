/**
 * 
 */
package com.perseverance.agentmanagement;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.perseverance.agentmanagement.entity.Agent;
import com.perseverance.agentmanagement.service.AgentService;

/**
 * @author AR350758
 * AgentCommandLineRunner.java Aug 3, 2019 9:00:43 PM
 */
@Component
public class AgentCommandLineRunner implements CommandLineRunner{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private AgentService agentService;
	
	@Override
	public void run(String... args) throws Exception {
		Agent agent = new Agent("John", true, 0, new Date(), null, new Date());
		agentService.addAgent(agent);
	}

}
