package com.demo.simplebankingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.simplebankingapp.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
