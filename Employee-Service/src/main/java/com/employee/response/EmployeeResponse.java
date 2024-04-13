package com.employee.response;

public class EmployeeResponse 
{
	private int empId;
	private String empName;
	private String empEmail;
	private String empBgroup;
	private EmpAddressResponse empAddressResponse;
	
	public EmpAddressResponse getEmpAddressResponse() {
		return empAddressResponse;
	}
	public void setEmpAddressResponse(EmpAddressResponse empAddressResponse) {
		this.empAddressResponse = empAddressResponse;
	}
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
