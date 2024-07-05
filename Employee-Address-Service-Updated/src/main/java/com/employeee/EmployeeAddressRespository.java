package com.employeee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.employee.entities.EmpAddressEntity;
import java.util.List;

public interface EmployeeAddressRespository extends JpaRepository<EmpAddressEntity, Integer>
{
	@Query(nativeQuery =true, value = "SELECT ea.ADDRESSS_ID,ea.PINCODE,ea.ADDRESS1,ea.CITY,ea.EMP_ID FROM employee.employee_address_master ea join employee.employee_master e on e.EMP_ID=ea.EMP_ID where ea.EMP_ID= :empId")
	public EmpAddressEntity findEmployeeAdressById(@Param("empId") int EMPID);

}
