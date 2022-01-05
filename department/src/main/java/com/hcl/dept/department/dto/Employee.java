package com.hcl.dept.department.dto;

import org.springframework.stereotype.Component;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
public class Employee {
	
	private int empId;
	private String name;
	private int age;
	private int sal;

}
