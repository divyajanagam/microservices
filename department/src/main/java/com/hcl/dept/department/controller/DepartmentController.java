package com.hcl.dept.department.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.hcl.dept.department.dto.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {
	
	@Autowired
	Environment environment;
	
	static Map<String,List<Employee>> deptMap = new HashMap<String,List<Employee>>();
	
	static {
		List<Employee> empList1 = new ArrayList<Employee>();
		Employee emp1 = new Employee();
		emp1.setEmpId(1);
		emp1.setAge(21);
		emp1.setName("Divya");
		emp1.setSal(20000);
		empList1.add(emp1);
		
		Employee emp2 = new Employee();
		emp2.setEmpId(2);
		emp2.setAge(25);
		emp2.setName("Divya Rao");
		emp2.setSal(20000);
		empList1.add(emp2);
		
		Employee emp3 = new Employee();
		emp3.setEmpId(3);
		emp3.setAge(34);
		emp3.setName("Nikhil");
		emp3.setSal(20000);
		empList1.add(emp3);
		
		Employee emp4 = new Employee();
		emp4.setEmpId(4);
		emp4.setAge(40);
		emp4.setName("Test");
		emp4.setSal(20000);
		empList1.add(emp4);
		
		deptMap.put("101", empList1);
		
		List<Employee> empList2 = new ArrayList<Employee>();
		
		Employee emp5 = new Employee();
		emp5.setEmpId(3);
		emp5.setAge(34);
		emp5.setName("Nikhil");
		emp5.setSal(20000);
		empList2.add(emp5);
		
		Employee emp6 = new Employee();
		emp6.setEmpId(4);
		emp6.setAge(40);
		emp6.setName("Test");
		emp6.setSal(20000);
		empList2.add(emp6);
		
		deptMap.put("201", empList2);
		
	}
	
	@GetMapping	("/port")
	public String getPortNo() {
		
		return environment.getProperty("local.server.port");
	}

	@GetMapping	("/dept")
	public Map<String,List<Employee>> getAllEmployees() {
		
		return deptMap;
	}
	
	@GetMapping	("/dept/{deptId}")
	public List<Employee> getAllEmployeesByDeptId(@PathVariable String deptId) {
		
		return deptMap.get(deptId);
	}
	
	@PostMapping ("/dept/updateDept")
	public List<Employee> updateDept(@RequestParam String deptId,@RequestBody Employee emp) {
		
		List<Employee> empList = (List<Employee>) deptMap.get(deptId);		 
		 empList.add(emp);		 
		 return deptMap.get(deptId);
	}
	
	@PostMapping ("/dept/createDept")
	public List<Employee> createDept(@RequestParam String deptId,@RequestBody Employee emp) {	
		List<Employee> empList = new ArrayList();
		 empList.add(emp);		 
		 deptMap.put(deptId,empList);
		 return deptMap.get(deptId);
	}
	

}
