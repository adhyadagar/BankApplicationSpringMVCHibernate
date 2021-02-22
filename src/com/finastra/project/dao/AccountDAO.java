package com.finastra.project.dao;

import java.util.List;

import com.finastra.project.entity.Account;

public interface AccountDAO {
	
	Account getAccount(long accountNumber);
	
	boolean saveAccount(Account a);
	
	public List<Account> getAccountsByUserName(String userName);

	boolean deleteAccount(long accountNumber);

	List<Account> getCurrentBalanceOfAllAccounts(String userName);
	
	

}
