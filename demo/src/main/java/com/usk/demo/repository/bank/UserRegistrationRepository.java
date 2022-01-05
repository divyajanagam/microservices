package com.usk.demo.repository.bank;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usk.demo.entity.bank.User;

@Repository
public interface UserRegistrationRepository extends JpaRepository<User, Long>{	

}
