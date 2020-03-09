package com.fortune.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.fortune.repository.domain.Account;

public interface AccountService {
	
	Account crateAccount(Account account);
	List<Account> getAllAccounts();
	List<Account> getAccounts(String firstName, Optional<String> lastName, Optional<String> email,
			Optional<String> dateCreated);

}
