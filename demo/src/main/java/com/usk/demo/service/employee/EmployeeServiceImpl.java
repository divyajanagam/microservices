package com.usk.demo.service.employee;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.usk.demo.entity.employee.Employee;
import com.usk.demo.repository.employee.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
 
	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getEmployees() {
		return employeeRepository.findAll();		
	}

	@Override
	public void deleteEmployee(Long empId) {
		employeeRepository.deleteById(empId);
	}

	@Override
	public Employee getEmployeeById(Long empId) {
		Optional<Employee> employee =  employeeRepository.findById(empId);
		if(employee.isPresent()) {
			return employee.get();
		}
		return null;
	}

	@Override
	public Employee updateEmployeeById(Employee employee, Long empId) {
		Employee dbEmploye = getEmployeeById(empId);
		if(dbEmploye != null) {
			dbEmploye.setEmpLastName(employee.getEmpLastName());
			dbEmploye.setDeptId(employee.getDeptId());
			dbEmploye.setEmpAge(employee.getEmpAge());
			dbEmploye.setEmpFirstName(employee.getEmpFirstName());
			dbEmploye.setSal(employee.getSal());
			
		}
		return employeeRepository.save(dbEmploye);		
	}

	@Override
	public List<Employee> getAllEmployees(int pageNumber, int pageSize) {
		
		Pageable pageable = PageRequest.of(pageNumber, pageSize,Sort.by(Direction.ASC, "empFirstName"));
		return employeeRepository.findAll(pageable).getContent();
	}

	@Override
	public List<Employee> getEmployeesByFirstName(String fname) {
		return employeeRepository.findByEmpFirstName(fname);
	}
	
	@Override
	public List<Employee> getEmployeesByFirstNameLike(String fname) {
		return employeeRepository.findByEmpFirstNameContains(fname);
	}

	@Override
	public List<Employee> getEmployeesByFirstNameOrderByFname(String fname) {
		return employeeRepository.findByEmpFirstNameContainsOrderByEmpFirstNameAsc(fname);
	}

	@Override
	public List<Employee> findByEmpFirstNameAndEmpLastName(String fname, String lname) {
		return employeeRepository.findByEmpFirstNameAndEmpLastName(fname, lname);
	}

	@Override
	public List<Employee> findByEmpFirstNameOrEmpLastName(String fname, String lname) {
		return employeeRepository.findByEmpFirstNameOrEmpLastName(fname, lname);
	}

	@Override
	public List<Employee> findByEmpFirstNameOrEmpLastNameContainsOrdeByFNameAsc(String fname, String lname) {
		return employeeRepository.findByEmpFirstNameContainsOrEmpLastNameContainsOrderByEmpFirstNameAsc(fname, lname);
	}

	@Override
	public List<Employee> getAllEmployeesBySal(int sal) {
		return employeeRepository.getEmployeesBySal(sal);
	}
	
	@Override
	public List<Employee> getAllEmployeesBySal_Native(String fname, int sal) {
		return employeeRepository.getEmployeesBySal_Native(fname,sal);
	}

}
