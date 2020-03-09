package com.fortune.service.impl;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fortune.repository.domain.Account;
import com.fortune.repository.persistence.AccountRepository;
import com.fortune.repository.spec.AccountSpecification;
import com.fortune.repository.spec.SearchCriteria;
import com.fortune.repository.spec.SearchOperation;
import com.fortune.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	AccountRepository accountRepository;

	@Override
	public Account crateAccount(Account account) {
		return accountRepository.save(account);
	}

	@Override
	public List<Account> getAllAccounts() {
		return accountRepository.findAll();
	}

	@Override
	public List<Account> getAccounts(String firstName, Optional<String> lastName, Optional<String> email,
			Optional<String> dateCreated) {
		
		AccountSpecification spec = new AccountSpecification();
		spec.add(new SearchCriteria("name", firstName, SearchOperation.EQUAL));

		
		dateCreated.ifPresent( d -> {

			OffsetDateTime x = OffsetDateTime.parse ( d , DateTimeFormatter.ofPattern ( "yyyy-MM-dd HH:mm:ss.SSSX" ) ) ;
			spec.add(new SearchCriteria("dateCreated", x, SearchOperation.GREATER_THAN_EQUAL));
			
		});
		
		


		return accountRepository.findAll(spec);
	}

}
