package com.demo.simplebankingapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.simplebankingapp.dto.AccountInfoResponse;
import com.demo.simplebankingapp.dto.Response;
import com.demo.simplebankingapp.entity.Account;
import com.demo.simplebankingapp.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	AccountRepository accountRepository;

	public Response checkBalance(String accountNumber) {
		Response response = new Response();
		Account account = accountRepository.findByAccountNumber(accountNumber);
		if (account == null) {
			response.setMessage("Account is not found");
			response.setSuccess(false);
			return response;
		}
		AccountInfoResponse accountInfoResponse = accountInfoResponseMapper(account);
		response.setData(accountInfoResponse);
		response.setSuccess(true);
		return response;
	}

	public AccountInfoResponse accountInfoResponseMapper(Account account) {
		AccountInfoResponse accountInfoResponse = new AccountInfoResponse();
		accountInfoResponse.setAccountNumber(account.getAccountNumber());
		accountInfoResponse.setCurrentBalance(account.getCurrentBalance());
		return accountInfoResponse;
	}
}
