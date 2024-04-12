package com.employee.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.employee.responses.EmpAddressResponse;
import com.employee.service.EmployeeAdressService;

@RestController
public class EmployeeAddressContoller
{
	@Autowired
	private EmployeeAdressService employeeAdressService;
	@GetMapping("/address/{EmpId}")
	public ResponseEntity<EmpAddressResponse> getAdressById(@PathVariable("EmpId") int employeeId)
	{
		System.out.println("Inside the EmployeeAddressContoller::::getAdressById");
		EmpAddressResponse empAddressResponse=employeeAdressService.getEmployeeAddressResponseById(employeeId);
		return ResponseEntity.status(HttpStatus.OK).body(empAddressResponse);
	}
}
