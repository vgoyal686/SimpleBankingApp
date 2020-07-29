package com.demo.simplebankingapp.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "accounts")
public class Account implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Date createdAt;

	private Date updatedAt;

	private String createdBy;

	private String updatedBy;

	@NotNull
	@Column(name = "account_number", unique = true, nullable = false)
	private String accountNumber;

	@Column(scale = 2)
	private double currentBalance;

	@OneToMany(mappedBy = "account")
	private Set<Transaction> transactions;
	
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

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}

	public Set<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	}

}
