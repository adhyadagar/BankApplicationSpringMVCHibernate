package com.finastra.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finastra.project.dao.AccountDAO;
import com.finastra.project.dao.TransactionDAO;
import com.finastra.project.entity.Transaction;

@Service
public class TransactionServiceImpl implements TransactionService {

	
	@Autowired
	private TransactionDAO transactionDAO;
	
	
	@Override
	public boolean saveTransaction(Transaction t) {
		// TODO Auto-generated method stub
		 return transactionDAO.saveAccount(t);
		
	}


	@Override
	public List<Transaction> getTransactionsByUserName(String userName) {
		// TODO Auto-generated method stub
		return transactionDAO.getTransactionsByUserName(userName);
	}


	@Override
	public Transaction getAccount(long accountNumber) {
		// TODO Auto-generated method stub
		return transactionDAO.getAccount(accountNumber);
	}


	@Override
	public boolean deleteAccount(long accountNumber) {
		// TODO Auto-generated method stub
		return transactionDAO.deleteAccount(accountNumber);
	}


	@Override
	public List<Transaction> getTransactionsByAccountNumber(long accountNumber) {
		// TODO Auto-generated method stub
		return transactionDAO.getTransactionsByAccountNumber(accountNumber);
	}

}
