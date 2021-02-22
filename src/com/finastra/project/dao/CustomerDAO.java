package com.finastra.project.dao;

import com.finastra.project.entity.Account;
import com.finastra.project.entity.BankUser;
import com.finastra.project.entity.Transaction;

public interface CustomerDAO {

	boolean checkUser(String userName);

	void saveUser(BankUser theCustomer);

	BankUser authenticate(String userName, String password);
}
