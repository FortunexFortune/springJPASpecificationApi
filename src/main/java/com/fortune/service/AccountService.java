package com.fortune.service;

import java.util.List;

import com.fortune.repository.domain.Account;

public interface AccountService {
	
	Account crateAccount(Account account);
	List<Account> getAllAccounts();


}
