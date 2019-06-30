package com.example.admin.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.example.admin.entity.Assessment;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Controller
public class AdminController {

	List<Assessment> lstAssessments = new ArrayList<Assessment>();

	@Autowired
	private RestTemplate restTemplate;

	@PostConstruct
	public void init() throws Exception {
		lstAssessments.add(new Assessment(1, "Jack", "Java", new Date(), "Tech"));
		lstAssessments.add(new Assessment(2, "Mary", "Springboot", new Date(), "Tech"));
		lstAssessments.add(new Assessment(3, "Peter", "Public Speaking", new Date(), "Behavioral"));
		lstAssessments.add(new Assessment(4, "Craig", "Java", new Date(), "Tech"));
		lstAssessments.add(new Assessment(5, "Eric", "Java", new Date(), "Tech"));
		lstAssessments.add(new Assessment(6, "Ellen", "Java", new Date(), "Tech"));

	}

	@GetMapping
	public String index() {
		return "redirect:/assessments";
	}
	
	
	@HystrixCommand(fallbackMethod="defaultGetAssessment",
			commandProperties={
			@HystrixProperty(
			  name="circuitBreaker.errorThresholdPercentage",value="1"),
			@HystrixProperty(
			  name="circuitBreaker.sleepWindowInMilliseconds",value="7000")
	})
	@GetMapping("/assessments")
	public String getAssessment(Model model) {

		try {
			ResponseEntity<List> result = restTemplate.getForEntity("http://localhost:8080/assessment", List.class);

			model.addAttribute("assessments", result.getBody());
			if (result.getStatusCode() == HttpStatus.OK) {
				return "assessment.table.html";
			}

		} catch (Exception e) {

		}
		
		return "Sorry";

	}

	public String defaultGetAssessment(Model model) {
		return "default";
	}
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		// Do any additional configuration here
		return builder.build();
	}
}