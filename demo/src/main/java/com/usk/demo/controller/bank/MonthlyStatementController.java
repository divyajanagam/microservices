package com.usk.demo.controller.bank;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.usk.demo.entity.bank.AccountSummary;
import com.usk.demo.service.bank.TransactionService;

@RestController
public class MonthlyStatementController {
	
	
	  @Autowired TransactionService transactionService;	 
	
	
	  @GetMapping("/accountsummary") 
	  public List<AccountSummary> getAccountSummary(@RequestParam Long accountNumber,@RequestParam int month,@RequestParam int year) {	  
		  return transactionService.getAccountSummary(accountNumber, month, year);	  
	  }
	 

}
