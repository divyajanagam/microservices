package com.usk.demo.service.bank;

import java.math.BigDecimal;

import com.usk.demo.entity.bank.Account;
import com.usk.demo.entity.bank.User;

public interface UserRegistrationService {
	
	public User saveUser(User user);
	public User getById(Long Id);
	public Account getByAccountId(Long acctId);
	public Long createAccount(Long userId, String accountType, BigDecimal openBal);
	public Account updateAccount(Account account);

}
