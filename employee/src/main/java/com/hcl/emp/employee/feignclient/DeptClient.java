package com.hcl.emp.employee.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.hcl.emp.employee.dto.EmployeeRequest;
import com.hcl.emp.employee.dto.EmployeeResponse;

//@FeignClient(value="dept-client", url = "http://localhost:8082/employees")
@FeignClient(name="http://department-service/employees")
public interface DeptClient {
	
	@GetMapping("/dept/{deptId}")
	public List<EmployeeResponse> getEmployeesByDeptId(@PathVariable String deptId);
	
	@PostMapping ("/dept/createDept")
	public List<EmployeeResponse> createDept(@RequestParam String deptId,@RequestBody EmployeeRequest emp);
	
	@GetMapping	("/port")
	public String getPortNo();

}
