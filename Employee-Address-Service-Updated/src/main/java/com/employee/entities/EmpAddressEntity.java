package com.employee.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee_address_master")
public class EmpAddressEntity 
{
	//ADDRESSS_ID, PINCODE, ADDRESS1, CITY, EMP_ID
	@Id
	@Column(name = "ADDRESSS_ID")
	private int addressId;
	@Column(name = "PINCODE")
	private String pincode;
	@Column(name = "CITY")
	private String city;
	@Column(name = "ADDRESS1")
	private String address1;
	
	
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	} 
	
	

}
