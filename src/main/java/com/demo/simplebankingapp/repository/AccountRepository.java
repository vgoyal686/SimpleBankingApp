package com.demo.simplebankingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.simplebankingapp.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

	public Account findByAccountNumber(String accountNumber);

}
