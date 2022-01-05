package com.usk.demo.entity.bank;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "First name is required")
	private String firstName;
	@NotBlank(message = "Last name is required")
	private String lastName;
	@Min(value = 18 , message = "Age should be greater than 18")	
	private int age;	
	private Long aadharNumber;
	@Size(min=10,max=10,message="Please enter valid phone number")
	private String phoneNo;
	@NotBlank(message = "EmailId is required")
	@Email(message = "Invalid Email Id")
	private String emailId;	
	
	@NotBlank(message = "Gender is required")
	private String gender;
	
	@OneToMany(mappedBy = "user")
	private List<Account> accounts;
}
