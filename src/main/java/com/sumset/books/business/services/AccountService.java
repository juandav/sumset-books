/**
 * 
 */
package com.sumset.books.business.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sumset.books.business.repository.AccountRepository;
import com.sumset.books.model.Account;

/**
 * @author juadnav
 *
 */
@Service
public class AccountService {
	private final AccountRepository accountRepository;

	public AccountService(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	public List<Account> findAll() {
		return this.accountRepository.findAll();
	}

	public Account create(Account account) {
		return this.accountRepository.save(account);
	}

	public Account update(Account account) {
		return this.accountRepository.save(account);
	}

	public void delete(Account account) {
		this.accountRepository.delete(account);
	}
}
