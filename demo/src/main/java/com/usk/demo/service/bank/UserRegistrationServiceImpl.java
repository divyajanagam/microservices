package com.usk.demo.service.bank;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usk.demo.entity.bank.Account;
import com.usk.demo.entity.bank.User;
import com.usk.demo.repository.bank.UserAccountRepository;
import com.usk.demo.repository.bank.UserRegistrationRepository;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {

	@Autowired
	UserRegistrationRepository userRegistrationRepository;
	
	@Autowired
	UserAccountRepository userAccountRepository;
	
	@Override
	public User saveUser(User user) {
		
		return userRegistrationRepository.save(user);
	}

	@Override
	public Long createAccount(Long userId,String accountType,BigDecimal openBal) {
		
		User user = getById(userId);
		if(user != null) {
			Account account = new Account();			
			//String randomNumber = UUID.randomUUID().toString().replace("-", "");
			
		    Random rnd = new Random(); 
		    int randomNumber = rnd.nextInt(999999999);		    		 
			account.setAccountNumber(Long.valueOf(randomNumber));
			account.setAccountType(accountType);
			account.setUser(user);
			account.setOpenBal(openBal);
			userAccountRepository.save(account);
			return Long.valueOf(randomNumber);
		}
		
		return null;
	}

	@Override
	public User getById(Long Id) {
		 Optional<User> user =  userRegistrationRepository.findById(Id);
		 if(user.isPresent()) {
			 return user.get();
		 }
		 return null;
	}

	@Override
	public Account getByAccountId(Long acctId) {
		Optional<Account> account =  userAccountRepository.findByAccountNumber(acctId);
		 if(account.isPresent()) {
			 return account.get();
		 }
		 return null;
	}

	@Override
	public Account updateAccount(Account account) {
		return userAccountRepository.save(account);
	}

}
