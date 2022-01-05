package com.usk.demo.service.employee;

import java.util.List;

import com.usk.demo.entity.employee.Employee;


public interface EmployeeService {
	
	public Employee saveEmployee(Employee employee);
	public List<Employee> getEmployees();
	public Employee getEmployeeById(Long empId);
	public void deleteEmployee(Long empId);
	public Employee updateEmployeeById(Employee employee , Long empId);
	public List<Employee> getAllEmployees(int pageNumber, int pageSize);
	public List<Employee> getEmployeesByFirstName(String fname);
	public List<Employee> getEmployeesByFirstNameLike(String fname);
	public List<Employee> getEmployeesByFirstNameOrderByFname(String fname);
	public List<Employee> findByEmpFirstNameAndEmpLastName(String fname,String lname);
	public List<Employee> findByEmpFirstNameOrEmpLastName(String fname, String lname);
	public List<Employee> findByEmpFirstNameOrEmpLastNameContainsOrdeByFNameAsc(String fname, String lname);
	public List<Employee> getAllEmployeesBySal(int sal);
	public List<Employee> getAllEmployeesBySal_Native(String fname, int sal);

}
