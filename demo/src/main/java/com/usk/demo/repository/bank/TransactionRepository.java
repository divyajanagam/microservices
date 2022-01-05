package com.usk.demo.repository.bank;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.usk.demo.entity.bank.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>{
	
	@Query("from Transaction t join t.account where t.account.accountNumber = :accountNumber "
			+ "and MONTH(t.createdDate) = :month AND YEAR(t.createdDate) = :year")
	List<Transaction> getAccountSummary(Long accountNumber, int month, int year);
}
