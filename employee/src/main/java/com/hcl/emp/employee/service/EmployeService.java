package com.hcl.emp.employee.service;

import com.hcl.emp.employee.dto.EmployeeDeptResponse;
import com.hcl.emp.employee.dto.EmployeeRequest;

public interface EmployeService {	
	public EmployeeDeptResponse getEmployeesByDeptId(String deptId);

	public EmployeeDeptResponse createEmployeesAndDeptId(String deptId, EmployeeRequest empReq);

	public String getPortNumber();
}
