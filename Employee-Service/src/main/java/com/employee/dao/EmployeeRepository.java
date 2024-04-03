package com.employee.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.entities.EmployeeEntity;
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> 
{

}
