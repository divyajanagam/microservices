package com.usk.demo.entity.bank;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
public class AccountSummary {
	
	private Long AccountNo;
	private String accountType;
	private BigDecimal balance;
	private String comments;
	private BigDecimal credit;
	private BigDecimal debit;
	private String firstName;
	private String lastName;
}
