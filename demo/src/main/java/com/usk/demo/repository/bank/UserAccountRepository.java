package com.usk.demo.repository.bank;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usk.demo.entity.bank.Account;

public interface UserAccountRepository extends JpaRepository<Account, Long>{

	Optional<Account> findByAccountNumber(Long acctId);

}
