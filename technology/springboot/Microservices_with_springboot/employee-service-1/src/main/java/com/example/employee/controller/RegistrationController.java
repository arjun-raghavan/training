package com.example.employee.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.example.employee.entity.Assessment;
import com.example.employee.entity.AssessmentDetail;

@Controller
public class RegistrationController {

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(value = "/register/technical", method = RequestMethod.POST)
	public String registerTechnical(HttpServletRequest request, HttpServletResponse response) {

		System.out.println(">>> /register/technical");

		if (request == null) {
			return "Sorry";
		}

		String userid = request.getParameter("userid");
		String assessment = request.getParameter("assessment");
		String date = request.getParameter("date");

		System.out.println(">>>>" + userid + " | " + assessment + " | " + date);

		if ((userid == null) || (assessment == null) || (date == null) || (userid == "") || (assessment == "")
				|| (date == "")) {
			return "Sorry";
		}
		Date assessmentDate = null;
		try {
			assessmentDate = new SimpleDateFormat("yyyy-mm-dd").parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		if (assessmentDate == null) {
			return "Sorry";
		}
		AssessmentDetail assessmentDetail = new AssessmentDetail(userid, assessment, assessmentDate, "Technical");
		try {
			Assessment result = restTemplate.postForObject("http://localhost:8080/assignment", assessmentDetail,
					Assessment.class);
		} catch (Exception e) {
			return "Sorry";
		}
		return "Success";

	}

	@RequestMapping(value = "/register/behavioral", method = RequestMethod.POST)
	public String registerBehavioral(HttpServletRequest request, HttpServletResponse response) {

		System.out.println(">>> /register/behavioral");

		if (request == null) {
			return "Sorry";
		}

		String userid = request.getParameter("userid");
		String assessment = request.getParameter("assessment");
		String date = request.getParameter("date");

		System.out.println(">>>>" + userid + " | " + assessment + " | " + date);

		if ((userid == null) || (assessment == null) || (date == null) || (userid == "") || (assessment == "")
				|| (date == "")) {
			return "Sorry";
		}
		Date assessmentDate = null;
		try {
			assessmentDate = new SimpleDateFormat("yyyy-mm-dd").parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		if (assessmentDate == null) {
			return "Sorry";
		}
		AssessmentDetail assessmentDetail = new AssessmentDetail(userid, assessment, assessmentDate, "Behavioral");
		try {
			Assessment result = restTemplate.postForObject("http://localhost:8080/assignment", assessmentDetail,
					Assessment.class);
		} catch (Exception e) {
			return "Sorry";
		}
		return "Success";

	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		// Do any additional configuration here
		return builder.build();
	}

}
