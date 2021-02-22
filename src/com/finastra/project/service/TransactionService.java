package com.finastra.project.service;

import java.util.List;

import com.finastra.project.entity.Transaction;

public interface TransactionService {
	
	boolean saveTransaction(Transaction t);
	
	List<Transaction> getTransactionsByUserName(String userName);
	
	Transaction getAccount(long accountNumber);
	
	boolean deleteAccount(long accountNumber);

	List<Transaction> getTransactionsByAccountNumber(long accountNumber);

	

}
