package com.usk.demo.controller.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.usk.demo.entity.employee.Employee;
import com.usk.demo.service.employee.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService  employeeService;
	
	@GetMapping("/test")
	public String test() {
		return "sucess";
	}

	//-------------------22/12--STARTS-----------------------------------
	@PostMapping("/saveEmployee")
	public Employee saveEmployee(@RequestBody Employee emp) {
		return employeeService.saveEmployee(emp);
	}
	
	@GetMapping("/getEmployees")
	public List<Employee> getEmployees() {
		return employeeService.getEmployees();
	}
	
	@PostMapping("/updateEmployee/{empId}")
	public Employee updateEmployeeById(@RequestBody Employee employee, @PathVariable Long empId) {
		return employeeService.updateEmployeeById(employee,empId);
	}
	
	@PostMapping("/{empId}")
	public Employee getEmployeeById(@PathVariable Long empId) {
		return employeeService.getEmployeeById(empId);
	}
	
	@DeleteMapping("/deleteEmployee/{empId}")
	public String getEmployees(@PathVariable Long empId) {
		employeeService.deleteEmployee(empId);
		return "delete success";
	}
	
	//-------------------22/12--Ends-----------------------------------
	
	//-------------------23/12--STARTS-----------------------------------
	
	@GetMapping("/getAllEmployees")
	public List<Employee> getAllEmployees(@RequestParam int pageNumber, @RequestParam int pageSize) {
		return employeeService.getAllEmployees(pageNumber,pageSize);
	}
	
	@GetMapping("/getByFirstName")
	public List<Employee> getAllEmployees(@RequestParam String fname) {
		return employeeService.getEmployeesByFirstName(fname);
	}
	
	@GetMapping("/getByFirstNameLike")
	public List<Employee> getAllEmployeesFnameLike(@RequestParam String fname) {
		return employeeService.getEmployeesByFirstNameLike(fname);
	}
	
	@GetMapping("/getByFirstNameOrderByFname")
	public List<Employee> getAllEmployeesOrderByFname(@RequestParam String fname) {
		return employeeService.getEmployeesByFirstNameOrderByFname(fname);
	}
	
	@GetMapping("/getByEmpFirstNameAndEmpLastName")
	public List<Employee> findByEmpFirstNameAndEmpLastName(@RequestParam String fname,@RequestParam String lname) {
		return employeeService.findByEmpFirstNameAndEmpLastName(fname,lname);
	}
	
	@GetMapping("/getByEmpFirstNameOrEmpLastName")
	public List<Employee> findByEmpFirstNameOrEmpLastName(@RequestParam String fname,@RequestParam String lname) {
		return employeeService.findByEmpFirstNameOrEmpLastName(fname,lname);
	}
	
	@GetMapping("/getByEmpFirstNameOrEmpLastNameContains")
	public List<Employee> findByEmpFirstNameOrEmpLastNameContains(@RequestParam String fname,@RequestParam String lname) {
		return employeeService.findByEmpFirstNameOrEmpLastNameContainsOrdeByFNameAsc(fname,lname);
	}
	
	@GetMapping("/getBySal")
	public List<Employee> getAllEmployeesBySal(@RequestParam int sal) {
		return employeeService.getAllEmployeesBySal(sal);
	}
	
	@GetMapping("/getBySalNative")
	public List<Employee> getAllEmployeesBySal(@RequestParam String fname, @RequestParam int sal) {
		return employeeService.getAllEmployeesBySal_Native(fname,sal);
	}
	
	//-------------------23/12--ENDS-----------------------------------
}
