package com.usk.demo.controller.bank;

import java.math.BigDecimal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.usk.demo.entity.bank.User;
import com.usk.demo.service.bank.UserRegistrationService;

@RestController
public class UserRegistrationController {
	
	@Autowired
	UserRegistrationService userRegistrationService;
	
	@PostMapping("/register")
	public User saveUser(@Valid @RequestBody User user) {
		return userRegistrationService.saveUser(user);
	}
	
	@PostMapping("/account/userId/{userId}")
	public Long createAccountByUserId(@PathVariable Long userId, @RequestParam String accountType, @RequestParam BigDecimal openingBal) {
		return userRegistrationService.createAccount(userId,accountType,openingBal);
	}
	
	

}
