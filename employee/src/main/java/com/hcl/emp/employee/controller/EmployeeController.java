package com.hcl.emp.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.emp.employee.dto.EmployeeDeptResponse;
import com.hcl.emp.employee.dto.EmployeeRequest;
import com.hcl.emp.employee.service.EmployeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeService employeeService;

	@GetMapping("/{deptId}/employees")
	public EmployeeDeptResponse getEmployeesAndDeptByDeptId(@PathVariable String deptId){
		return employeeService.getEmployeesByDeptId(deptId);
	}
	
	@PostMapping("/createDeptEmp/{deptId}")
	public EmployeeDeptResponse getEmployeesAndDeptByDeptId(@PathVariable String deptId,@RequestBody EmployeeRequest empReq){
		return employeeService.createEmployeesAndDeptId(deptId,empReq);
	}
	
	@GetMapping("/port")
	public String getDeptPortNo() {
		return employeeService.getPortNumber();
	}
}
