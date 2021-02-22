package com.finastra.project.dao;

import java.util.List;

import com.finastra.project.entity.Account;
import com.finastra.project.entity.Transaction;

public interface TransactionDAO {
	
	boolean saveAccount(Transaction t);

	List<Transaction> getTransactionsByUserName(String userName);

	Transaction getAccount(long accountNumber);

	boolean deleteAccount(long accountNumber);

	List<Transaction> getTransactionsByAccountNumber(long accountNumber);

}
