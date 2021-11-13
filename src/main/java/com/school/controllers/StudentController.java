package com.school.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.school.services.StudentService;
import com.school.utils.SchoolLogger;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	private static final String LOG_STR = "StudentController.%s";
	
	@Autowired
	private SchoolLogger logger;
	
	@Autowired
	private StudentService service;

	@GetMapping
	public ResponseEntity<JsonNode> getAllStudents() {

		logger.info(String.format(LOG_STR, "getAllStudents"));

		return service.getAllStudents();
	}
	

}
