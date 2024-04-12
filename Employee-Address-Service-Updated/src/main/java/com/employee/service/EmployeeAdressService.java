package com.employee.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entities.EmpAddressEntity;
import com.employee.responses.EmpAddressResponse;
import com.employeee.EmployeeAddressRespository;

@Service


public class EmployeeAdressService 
{
	@Autowired
	private EmployeeAddressRespository employeeAddressRespository;
	@Autowired
	private ModelMapper modelMapper;
	
	public EmpAddressResponse getEmployeeAddressResponseById(int employeeId)
	{
		System.out.println("Inside the EmployeeAdressService:::getEmployeeAddressResponseById::"+employeeId);
		EmpAddressEntity empAddressEntity=employeeAddressRespository.findEmployeeAdressById(employeeId);
		EmpAddressResponse empAddressResponse=modelMapper.map(empAddressEntity, EmpAddressResponse.class);
		return empAddressResponse;
		
	}

}
