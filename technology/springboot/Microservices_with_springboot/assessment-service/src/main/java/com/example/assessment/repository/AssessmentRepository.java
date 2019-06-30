package com.example.assessment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.assessment.entity.Assessment;

public interface AssessmentRepository extends JpaRepository<Assessment, Integer> {

}