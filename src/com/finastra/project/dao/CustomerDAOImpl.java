package com.finastra.project.dao;


import java.util.Date;
import java.util.List;
import java.sql.Timestamp;


import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.finastra.project.entity.Account;
import com.finastra.project.entity.BankUser;
import com.finastra.project.entity.Transaction;


@Repository
public class CustomerDAOImpl implements CustomerDAO  {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public boolean checkUser(String userName) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<BankUser> users = session.createQuery("from BankUser where user_name=:userName",BankUser.class)
				.setParameter("userName", userName)
				.list();
		if(!users.isEmpty())
		{
			return true;
		}
		
		return false;
	}


	@Override
	@Transactional
	public void saveUser(BankUser theCustomer) {
		// TODO Auto-generated method stub
		
			//long number = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
			Session currSession = sessionFactory.getCurrentSession();
			//theCustomer.setAccountNumber(number);
			currSession.save(theCustomer);
	}
	
	@Override
	public BankUser authenticate(String userName, String password) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		
		List<BankUser> users = session.createQuery("from BankUser where user_name=:userName and password=:password",BankUser.class)
				.setParameter("userName", userName)
				.setParameter("password", password).list();
		if(!users.isEmpty())
		{
			return users.get(0);
		}
		
		return null;
	}



	
}
			
	


	


