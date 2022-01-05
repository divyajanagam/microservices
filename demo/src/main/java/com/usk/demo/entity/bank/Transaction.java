package com.usk.demo.entity.bank;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@EntityListeners(AuditingEntityListener.class)
@Data
@NoArgsConstructor
/*
 * @NamedQuery(name = "Transaction.getAccountSummary", query =
 * "select a.account_number, a.account_type, a.open_bal, t.comments, t.debit, t.credit, a.user.first_name, a.user.last_name "
 * + "from transaction t join account a on " + "t.account_id = a.id" +
 * "where a.account_number = :accountNumber and MONTH(t.created_date) = :month AND YEAR(t.created_date) = :year;"
 * )
 */
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
    @JoinColumn(name="account_id", nullable=false)
	private Account account;
	
	private BigDecimal credit;
	
	private BigDecimal debit;
	
	private String comments;
	
	@CreatedDate
	private Date  createdDate;

	
}
