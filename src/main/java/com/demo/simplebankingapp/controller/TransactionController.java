package com.demo.simplebankingapp.controller;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.simplebankingapp.dto.Response;
import com.demo.simplebankingapp.dto.TransactionRequest;
import com.demo.simplebankingapp.service.TransactionService;

@RestController
public class TransactionController {
	
	@Autowired
	TransactionService transactionService;
	
	@RequestMapping(value = "/transaction", method = RequestMethod.POST)
	public Response executeTransaction(@NotNull @RequestBody TransactionRequest transactionRequest) {
		return transactionService.executeTransaction(transactionRequest);
	}

}
