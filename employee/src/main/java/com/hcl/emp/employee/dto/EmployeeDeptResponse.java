package com.hcl.emp.employee.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
public class EmployeeDeptResponse {
	
	Department dept;
	private List<EmployeeResponse> empResponseList;

}
