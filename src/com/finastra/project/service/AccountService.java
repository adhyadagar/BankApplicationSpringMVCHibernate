package com.finastra.project.service;

import java.util.List;

import com.finastra.project.entity.Account;

public interface AccountService {
		
		Account getAccount(long accountNumber);
		boolean saveAccount(Account a);
		public List<Account> getAccountsByUserName(String userName);
		boolean deleteAccount(long accountNumber);
		List<Account> getCurrentBalanceOfAllAccounts(String userName);

	}


