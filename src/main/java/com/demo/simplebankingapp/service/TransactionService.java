package com.demo.simplebankingapp.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.simplebankingapp.dto.Response;
import com.demo.simplebankingapp.dto.TransactionRequest;
import com.demo.simplebankingapp.entity.Account;
import com.demo.simplebankingapp.entity.Transaction;
import com.demo.simplebankingapp.repository.AccountRepository;
import com.demo.simplebankingapp.repository.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	TransactionRepository transactionRepository;

	@Autowired
	AccountRepository accountRepository;

	@Transactional
	public Response executeTransaction(TransactionRequest transactionRequest) {
		Response response = new Response();
		if (transactionRequest.getAccountNumber() == null || transactionRequest.getAccountNumber().isEmpty()) {
			response.setMessage("Account Number is a required field");
			response.setSuccess(false);
			return response;
		}
		if (transactionRequest.getTransactionAmount() <= 0) {
			response.setMessage("Transaction Amount should be greater than 0");
			response.setSuccess(false);
			return response;
		}
		if (transactionRequest.getTransactionType() == null || transactionRequest.getTransactionType().isEmpty()
				|| (!transactionRequest.getTransactionType().equals("credit")
				&& !transactionRequest.getTransactionType().equals("debit"))) {
			response.setMessage("Transaction Type is a required field and it should be credit or debit");
			response.setSuccess(false);
			return response;
		}
		Account account = accountRepository.findByAccountNumber(transactionRequest.getAccountNumber());
		if (account == null) {
			response.setMessage("Account is not found");
			response.setSuccess(false);
			return response;
		}
		if (transactionRequest.getTransactionType().equals("debit")) {
			if (account.getCurrentBalance() < transactionRequest.getTransactionAmount()) {
				response.setMessage("Transaction can't be initiated because account balance is not sufficient");
				response.setSuccess(false);
				return response;
			}
			account.setCurrentBalance(account.getCurrentBalance() - transactionRequest.getTransactionAmount());
		} else if (transactionRequest.getTransactionType().equals("credit")) {
			account.setCurrentBalance(account.getCurrentBalance() + transactionRequest.getTransactionAmount());
		}
		Transaction transaction = new Transaction();
		transaction.setAccount(account);
		transaction.setTransactionAmount(transactionRequest.getTransactionAmount());
		transaction.setTransactionType(transactionRequest.getTransactionType());
		transactionRepository.save(transaction);
		response.setSuccess(true);
		return response;
	}
}
