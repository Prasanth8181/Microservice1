package com.employee.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entities.EmployeeEntity;
import com.employee.response.EmployeeResponse;
import com.employee.service.EmployeeService;

@RestController
public class EmployeeController
{
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<EmployeeResponse> getEmployeeDetails(@PathVariable("id")int empId)
	{
		System.out.println("Inside the controller class");
	    EmployeeResponse employeeResponse=employeeService.getEmployeeById(empId);
	    return ResponseEntity.status(HttpStatus.OK).body(employeeResponse);
	}

}
