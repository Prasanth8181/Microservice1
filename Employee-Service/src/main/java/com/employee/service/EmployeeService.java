package com.employee.service;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.employee.AddressFeignClient;
import com.employee.dao.EmployeeRepository;
import com.employee.entities.EmployeeEntity;
import com.employee.response.EmpAddressResponse;
import com.employee.response.EmployeeResponse;
@Service
public class EmployeeService 
{
	public static final Logger logger=LoggerFactory.getLogger(EmployeeService.class);
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private AddressFeignClient addressFeignClient;
	@Value("${EmployeeAdressService.base.url}")
	private String baseAddressUrl;
	
	
	public EmployeeResponse getEmployeeById(int empId) 
	{
	      	logger.info("Inside the EmployeeService::getEmployeeById");
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
			//Normal rest call using restTemplate
			//EmpAddressResponse empAddressResponse=restTemplate.getForObject(baseAddressUrl+"/address/{id}", EmpAddressResponse.class, empId);
			//Feign call using open feign client (microservices)
			EmpAddressResponse empAddressResponse=addressFeignClient.getAddressByEmployeeId(empId);
			employeeResponse.setEmpAddressResponse(empAddressResponse);//setting address data by making restApi call;	
		    return employeeResponse;
	}

}
