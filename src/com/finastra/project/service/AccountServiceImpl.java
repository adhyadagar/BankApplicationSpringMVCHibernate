package com.finastra.project.service;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finastra.project.dao.AccountDAO;
import com.finastra.project.dao.CustomerDAO;
import com.finastra.project.entity.Account;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private AccountDAO accountDAO;
	

	public Account getAccount(long accountNumber)
	{
		return accountDAO.getAccount(accountNumber);
	}
	
	@Override
	public boolean saveAccount(Account a) {
		// TODO Auto-generated method stub
	     
		 return accountDAO.saveAccount(a);
	}

	@Override
	public List<Account> getAccountsByUserName(String userName) {
		// TODO Auto-generated method stub
		return accountDAO.getAccountsByUserName(userName);
	}

	@Override
	public boolean deleteAccount(long accountNumber) {
		// TODO Auto-generated method stub
		return accountDAO.deleteAccount(accountNumber);
	}

	@Override
	public List<Account> getCurrentBalanceOfAllAccounts(String userName) {
		// TODO Auto-generated method stub
		return accountDAO.getCurrentBalanceOfAllAccounts(userName);
	}
}
