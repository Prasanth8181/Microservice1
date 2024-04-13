package com.employee.service;

import java.net.ConnectException;

import org.hibernate.internal.build.AllowPrintStacktrace;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.employee.dao.EmployeeRepository;
import com.employee.entities.EmployeeEntity;
import com.employee.response.EmpAddressResponse;
import com.employee.response.EmployeeResponse;
@Service
public class EmployeeService 
{
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private RestTemplate restTemplate;
	
	public EmployeeResponse getEmployeeById(int empId) 
	{
			System.out.println("Inside the EmployeeService::getEmployeeById");
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
			EmpAddressResponse empAddressResponse=restTemplate.getForObject("http://localhost:8081/address/{id}", EmpAddressResponse.class, empId);
			employeeResponse.setEmpAddressResponse(empAddressResponse);//setting address data by making restApi call;	
		    return employeeResponse;
		
			
		
		
	}

}
