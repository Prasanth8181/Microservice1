package com.employee;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.employee.response.EmpAddressResponse;

//http://localhost:8081/address/2-->This is the endpoint we need to call
@org.springframework.cloud.openfeign.FeignClient(name = "EmpAddressService",url = "http://localhost:8081",path ="/address")
public interface AddressFeignClient //proxy class
{
	//http://localhost:8081/address/2
	@GetMapping("/{id}")
	public EmpAddressResponse getAddressByEmployeeId(@PathVariable("id") int id);
	

}
