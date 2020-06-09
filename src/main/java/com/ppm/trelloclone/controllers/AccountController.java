package com.ppm.trelloclone.controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ppm.trelloclone.models.Account;
import com.ppm.trelloclone.repositories.AccountRepository;

@RestController
@RequestMapping(path = "/accounts")
public class AccountController {
	@Autowired
	private AccountRepository accountRepository;
	
	@PostMapping
	public Account create(@RequestBody Account account) {
		return accountRepository.saveAndFlush(account);
	}
	
	@GetMapping
	public List<Account> get() {
		return accountRepository.findAll();
	}
	
	@GetMapping(value = "{username}")
	public Account get(@PathVariable String username) {
		return accountRepository.getOne(username);
	}
	
	@RequestMapping(value = "{username}", method = RequestMethod.PUT)
	public Account update(@PathVariable String username, @RequestBody Account account) {
		Account existingAccount = accountRepository.getOne(username);
		BeanUtils.copyProperties(account, existingAccount, "username", "id");
		return accountRepository.saveAndFlush(existingAccount);
	}
	
	@RequestMapping(value = "{username}", method = RequestMethod.DELETE)
	public void delete(@PathVariable String username) {
		accountRepository.deleteById(username);
	}

}










