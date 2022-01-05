package com.usk.demo.repository.employee;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.usk.demo.entity.employee.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	List<Employee> findByEmpFirstName(String fname);
	List<Employee> findByEmpFirstNameContains(String fname);
	List<Employee> findByEmpFirstNameContainsOrderByEmpFirstNameAsc(String fname);
	List<Employee> findByEmpFirstNameAndEmpLastName(String fname,String lname);
	List<Employee> findByEmpFirstNameOrEmpLastName(String fname, String lname);
	List<Employee> findByEmpFirstNameContainsOrEmpLastNameContainsOrderByEmpFirstNameAsc(String fname, String lname);
	
	@Query("from Employee where sal > :sal")
	List<Employee> getEmployeesBySal(int sal);
	
	@Query(value = "select e.* from Employee e where e.emp_first_name = :fname and e.sal > :sal", nativeQuery = true)
	List<Employee> getEmployeesBySal_Native(String fname, int sal);

}
