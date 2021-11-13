package com.school.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.school.entities.Students;
import com.school.repos.StudentsRepository;
import com.school.utils.CommonConstants;
import com.school.utils.SchoolLogger;

@Service
public class StudentService {
	
	private static final String LOG_STR = "StudentService.%s";
	
	@Autowired
	private SchoolLogger logger;

	@Autowired
	private StudentsRepository repository;
	
	public ResponseEntity<JsonNode> getAllStudents() {

		String methodName = "getAllStudents";

		logger.info(String.format(LOG_STR, methodName));

		ObjectNode responseNode = JsonNodeFactory.instance.objectNode();

		List<Students> studentsList = repository.findAll(Sort.by(Sort.Direction.ASC, "id"));

		responseNode.put(CommonConstants.RESPONSE, CommonConstants.SUCCESS);

		ArrayNode dataArr = responseNode.putArray("data");

		studentsList.forEach(dataArr::addPOJO);

		logger.info(String.format(LOG_STR, methodName) + " , responseNode = " + responseNode);

		return new ResponseEntity<>(responseNode, HttpStatus.OK);
	}

}
