package com.employee.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.dao.EmployeeRepository;
import com.employee.entities.EmployeeEntity;
import com.employee.response.EmployeeResponse;
@Service
public class EmployeeService 
{
	@Autowired(required = true)
	private EmployeeRepository employeeRepository;
	@Autowired
	private ModelMapper modelMapper;
	
	public EmployeeResponse getEmployeeById(int empId) 
	{
		System.out.println("Inside the EmployeeService");
		// dbcall
		EmployeeEntity employeeEntity = employeeRepository.findById(empId).get();
		/*EmployeeResponse employeeResponse=new EmployeeResponse();
		employeeResponse.setEmpName(employeeEntity.getEmpName());
		employeeResponse.setEmpId(employeeEntity.getEmpId());
		employeeResponse.setEmpBgroup(employeeEntity.getEmpBgroup());
		employeeResponse.setEmpEmail(employeeEntity.getEmpEmail());*/
		//Instead of doing the above code manually we can use model mapper
		//but emoployee entitiy variable names and employeeResponse variable names must be equal
		EmployeeResponse employeeResponse=modelMapper.map(employeeEntity, EmployeeResponse.class);
		return employeeResponse;
	}

}
