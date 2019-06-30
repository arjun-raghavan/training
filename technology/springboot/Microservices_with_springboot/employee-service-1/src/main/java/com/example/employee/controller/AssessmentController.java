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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.example.employee.entity.Assessment;
import com.example.employee.entity.AssessmentDetail;

@Controller
public class AssessmentController {

	
	@RequestMapping(value = "/assessment/technical", method = RequestMethod.GET)
	public String displayTechnicalAssessment(HttpServletRequest request, HttpServletResponse response) {

		System.out.println(">>> displayTechnicalAssessment");

		if (request == null) {
			return "Sorry";
		}

		return "TechnicalAssessment";

	}

	@GetMapping
	public String index() {
		return "redirect:/assessment";
	}

	@RequestMapping(value = "/assessment", method = RequestMethod.GET)
	public String displaylAssessment(HttpServletRequest request, HttpServletResponse response) {

		System.out.println(">>> displaylAssessment >> " + request.getSession().getAttribute("userid"));

		return "Assessment";

	}

	@RequestMapping(value = "/assessment/behavioral", method = RequestMethod.GET)
	public String displayBehavioralAssessment(HttpServletRequest request, HttpServletResponse response) {

		System.out.println(">>> displayBehavioralAssessment");

		return "BehavioralAssessment";

	}

	
}
