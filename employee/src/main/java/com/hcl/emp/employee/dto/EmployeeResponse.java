package com.hcl.emp.employee.dto;

import org.springframework.stereotype.Component;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
public class EmployeeResponse {
	
	private int empId;
	private String name;
	private int age;
	private int sal;

}
