package com.finastra.project.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finastra.project.entity.Account;
import com.finastra.project.entity.BankUser;
import com.finastra.project.entity.Transaction;
import com.finastra.project.service.CustomerService;
import com.finastra.project.dao.CustomerDAO;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDAO customerDAO;

	@Override
	@Transactional
	public void saveUser(BankUser theCustomer) {
		// TODO Auto-generated method stub
		customerDAO.saveUser(theCustomer);
		
	}

	@Override
	@Transactional
	public boolean checkUser(String userName) {
		// TODO Auto-generated method stub
		return customerDAO.checkUser(userName);
		
	}

	@Override
	@Transactional
	public BankUser authenticate(String userName, String password) {
		// TODO Auto-generated method stub
		return customerDAO.authenticate(userName,password);
	}

}



