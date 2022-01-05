package com.usk.demo.service.bank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usk.demo.entity.bank.Account;
import com.usk.demo.entity.bank.AccountSummary;
import com.usk.demo.entity.bank.Transaction;
import com.usk.demo.repository.bank.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {
	
	@Autowired
	UserRegistrationService userRegistrationService;
	
	@Autowired
	TransactionRepository transactionRepository;

	@Override
	public String transferFunds(Long fromAcct, Long toAcct, BigDecimal transferAmt,String comments) {
		Account fromAccount = userRegistrationService.getByAccountId(fromAcct);
		Account toAccount = userRegistrationService.getByAccountId(toAcct);		
		if(fromAccount == null) return "From account does not exists";
		if(toAccount == null) return "To account does not exists";			
		int value = fromAccount.getOpenBal().compareTo(transferAmt);		
		if(value == 0 ||value == 1) {
			BigDecimal fromAcctBal = fromAccount.getOpenBal().subtract(transferAmt);
			BigDecimal toAcctBal = toAccount.getOpenBal().add(transferAmt);
			fromAccount.setOpenBal(fromAcctBal);
			toAccount.setOpenBal(toAcctBal);
			Account frmAccount = userRegistrationService.updateAccount(fromAccount);
			Account toAcount = userRegistrationService.updateAccount(toAccount);		
			if(frmAccount.getOpenBal().equals(fromAcctBal)) {
				Transaction transaction = new Transaction();
				transaction.setAccount(frmAccount);
				transaction.setDebit(transferAmt);
				transaction.setComments(comments);
				transactionRepository.save(transaction);
			}
			if(toAcount.getOpenBal().equals(toAcctBal)) {
				Transaction transaction = new Transaction();
				transaction.setAccount(toAcount);
				transaction.setCredit(transferAmt);
				transaction.setComments(comments);
				transactionRepository.save(transaction);
			}
			return "Sucessfully done with funds Transfer";
		}
		if(value == -1) { // fromaccount bal is < amount to transfer			
			return "insufficient funds to transfer";
		}
		return null;
	}

	
	  @Override 
	  public List<AccountSummary> getAccountSummary(Long accountNumber,int month, int year) { 
			  List<Transaction> transaction =  transactionRepository.getAccountSummary(accountNumber, month, year); 
			  List<AccountSummary> accountSummaryLst = new ArrayList<AccountSummary>();
			  for (Transaction tx : transaction) {
				AccountSummary accountSummary = new AccountSummary();
				accountSummary.setAccountNo(tx.getAccount().getAccountNumber());
				accountSummary.setAccountType(tx.getAccount().getAccountType());
				accountSummary.setBalance(tx.getAccount().getOpenBal());
				accountSummary.setComments(tx.getComments());
				accountSummary.setCredit(tx.getCredit());
				accountSummary.setDebit(tx.getDebit());
				accountSummary.setFirstName(tx.getAccount().getUser().getFirstName());
				accountSummary.setLastName(tx.getAccount().getUser().getLastName());
				accountSummaryLst.add(accountSummary);
			  }
			  return accountSummaryLst;
	  }
	 
	
	

}
