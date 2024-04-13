package com.employee.configurations;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.employee.response.EmployeeResponse;

@Configuration
public class EmployeeConfig 
{
	@Bean
	public ModelMapper getModelMapper()
	{
		return new ModelMapper();
	}
	@Bean
	public RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}
	public EmployeeResponse getEmployeeResponse()
	{
		return new EmployeeResponse();
	}

}
