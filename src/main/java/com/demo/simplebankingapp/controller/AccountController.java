package com.demo.simplebankingapp.controller;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.simplebankingapp.dto.Response;
import com.demo.simplebankingapp.service.AccountService;

@RestController
public class AccountController {
	
	@Autowired
	AccountService accountService;
	
	@RequestMapping(value = "/checkBalance", method = RequestMethod.GET)
	public Response checkBalance(@NotNull @RequestParam("accountNumber") String accountNumber) {
		return accountService.checkBalance(accountNumber);
	}

}
