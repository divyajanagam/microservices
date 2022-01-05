package com.usk.demo.service.bank;

import java.math.BigDecimal;
import java.util.List;

import com.usk.demo.entity.bank.AccountSummary;

public interface TransactionService {
	
	public String transferFunds(Long fromAcct, Long toAcct,BigDecimal transferAmt,String comments);

	public List<AccountSummary> getAccountSummary(Long accountNumber, int month,int year);
}
