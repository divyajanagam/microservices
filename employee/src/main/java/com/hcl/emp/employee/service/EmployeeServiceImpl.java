package com.hcl.emp.employee.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.emp.employee.dto.Department;
import com.hcl.emp.employee.dto.EmployeeDeptResponse;
import com.hcl.emp.employee.dto.EmployeeRequest;
import com.hcl.emp.employee.dto.EmployeeResponse;
import com.hcl.emp.employee.feignclient.DeptClient;

@Service
public class EmployeeServiceImpl implements EmployeService {

	@Autowired
	DeptClient deptClient;

	static Map<String, Department> deptDetails = new HashMap<String, Department>();

	static {

		Department dept1 = new Department();
		dept1.setDeptId("101");
		dept1.setDeptName("Information Technology");

		Department dept2 = new Department();
		dept2.setDeptId("201");
		dept2.setDeptName("Finance");

		deptDetails.put("101", dept1);
		deptDetails.put("201", dept2);
	}

	@Override
	public EmployeeDeptResponse getEmployeesByDeptId(String deptId) {

		Department dept = deptDetails.get(deptId);
		EmployeeDeptResponse employeeDeptResponse = new EmployeeDeptResponse();
		employeeDeptResponse.setDept(dept);
		// call deptservice
		List<EmployeeResponse> employeeDeptResponseDtos = deptClient.getEmployeesByDeptId(deptId);
		employeeDeptResponse.setEmpResponseList(employeeDeptResponseDtos);
		return employeeDeptResponse;
	}

	/*
	 * public EmployeeDeptResponse updateEmployeesByDeptId(String deptId) {
	 * 
	 * Department dept = deptDetails.get(deptId); EmployeeDeptResponse uor = new
	 * EmployeeDeptResponse(); uor.setDept(dept);
	 * 
	 * return uor; }
	 */

	@Override
	public EmployeeDeptResponse createEmployeesAndDeptId(String deptId, EmployeeRequest emp) {

		Department dept = deptDetails.get(deptId);
		EmployeeDeptResponse employeeDeptResponse = new EmployeeDeptResponse();
		if(dept== null) {
			Department d = new Department();
			d.setDeptId(deptId);
			d.setDeptName("test"+deptId);
			employeeDeptResponse.setDept(d);
		}
		
		// call deptservice
		List<EmployeeResponse> employeeDeptResponseDtos = deptClient.createDept(deptId, emp);
		employeeDeptResponse.setEmpResponseList(employeeDeptResponseDtos);
		return employeeDeptResponse;
	}

	@Override
	public String getPortNumber() {
		return deptClient.getPortNo();
	}

}
