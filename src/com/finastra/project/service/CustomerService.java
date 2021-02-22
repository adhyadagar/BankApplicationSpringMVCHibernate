package com.finastra.project.service;

import com.finastra.project.entity.Account;
import com.finastra.project.entity.BankUser;
import com.finastra.project.entity.Transaction;

public interface CustomerService {
	
	
	void saveUser(BankUser theCustomer);

	boolean checkUser(String userName);

	BankUser authenticate(String userName, String password);

}
