package com.hcl.emp.employee.dto;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
public class Department {
	
	public String deptId;
	public String deptName;

}
