package com.fortune.Controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fortune.repository.domain.Account;
import com.fortune.service.AccountService;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	AccountService accountService;
	
	@GetMapping(path = "/{firstName}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public List<Account> getAccounts(@PathVariable String firstName, @RequestParam Optional<String> lastName,
									@RequestParam Optional<String> email, 
									@RequestParam Optional<String> dateCreated) {
	
		return accountService.getAccounts(firstName, lastName, email, dateCreated);
	}

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public List<Account> getAll() {
		return accountService.getAllAccounts();
	}

	@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public Account createAccount(@RequestBody Account account) {
		return accountService.crateAccount(account);
	}

}
