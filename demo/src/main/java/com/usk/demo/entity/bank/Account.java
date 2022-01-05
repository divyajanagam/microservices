package com.usk.demo.entity.bank;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@EntityListeners(AuditingEntityListener.class)
@Data
@NoArgsConstructor
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//@Min(500)
	private BigDecimal openBal;
	
	@NotBlank(message = "Account Type is required")
	private String accountType;
	
	@ManyToOne
    @JoinColumn(name="cust_id", nullable=false)
    private User user;
	
	@NotNull
	private Long accountNumber;
	
	@OneToMany(mappedBy = "account")
	private List<Transaction> transaction;
	
	@CreatedDate
	private Date  createdDate;

}
