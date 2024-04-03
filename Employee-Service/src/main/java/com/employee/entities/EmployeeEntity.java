package com.employee.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee_master")
public class EmployeeEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EMP_ID")
	private int empId;
	@Column(name = "EMP_NAME")
	private String empName;
	@Column(name = "EMP_EMAIL")
	private String empEmail;
	@Column(name = "EMP_BLOOD_GROUP")
	private String empBgroup;
	
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	public String getEmpBgroup() {
		return empBgroup;
	}
	public void setEmpBgroup(String empBgroup) {
		this.empBgroup = empBgroup;
	}
	
	

}
