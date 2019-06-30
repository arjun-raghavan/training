package com.example.assessment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.assessment.entity.Assessment;
import com.example.assessment.repository.AssessmentRepository;

@RestController
public class AssessmentController {

	@Autowired
	AssessmentRepository repository;
	
	/**
	 * API to get all assessments
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value="/assessment")
    public ResponseEntity<List<Assessment>> getAssignments() {
		return new ResponseEntity(repository.findAll(), HttpStatus.OK);
        
    }
	
	/**
	 * API to add an assignment
	 * @param assessment
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value="/assignment")
    public Assessment addAssessment(@RequestBody Assessment assessment) {
		return repository.save(assessment);
        
    }
}
