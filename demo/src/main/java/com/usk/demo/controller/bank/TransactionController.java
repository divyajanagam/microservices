package com.usk.demo.controller.bank;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.usk.demo.service.bank.TransactionService;

@RestController
public class TransactionController {
	
	@Autowired
	TransactionService transactionService;
	
	@PostMapping("/transfer")
	public String transferFunds(@RequestParam Long fromAccount, @RequestParam Long toAccount,
			@RequestParam BigDecimal transferAmt,@RequestParam String comments) {
		return transactionService.transferFunds(fromAccount, toAccount, transferAmt, comments);
	}

}
