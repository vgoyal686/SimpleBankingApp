package com.demo.simplebankingapp.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "transactions")
public class Transaction implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Date createdAt;

	private Date updatedAt;

	private String createdBy;

	private String updatedBy;

	@Column(scale = 2)
	private double transactionAmount;

	/* Transaction Type "credit" or "debit" */
	private String transactionType;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "account_number", referencedColumnName = "account_number", nullable = false)
	private Account account;

	public Long getId() {
		return id;
	}
	
	@PrePersist
	public void prePersist() {
		createdAt = new Date();
		createdBy = "System";
	}

	@PreUpdate
	public void preUpdate() {
		updatedAt = new Date();
		updatedBy = "System";
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
