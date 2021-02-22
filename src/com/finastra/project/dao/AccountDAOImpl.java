package com.finastra.project.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.finastra.project.entity.Account;

@Repository
public class AccountDAOImpl implements AccountDAO{
	
	
	private final SessionFactory sessionFactory;
	
	@Autowired
	public AccountDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}

	
	@Transactional
	public Account getAccount(long accountNumber)
	{
		
		 Session session = sessionFactory.getCurrentSession();
	     
	     return session.get(Account.class, accountNumber);
		
	}


	@Override
	@Transactional
	public boolean saveAccount(Account a) {
		// TODO Auto-generated method stub

		try
		{
			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(a);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
		
	}


	@Override
	@Transactional
	public List<Account> getAccountsByUserName(String userName) {
		// TODO Auto-generated method stub
		try
		{
			Session session = sessionFactory.getCurrentSession();
			List<Account> accounts = session.createQuery("from Account where user_name=:userName",Account.class)
					.setParameter("userName", userName).list();
			
			return accounts;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	@Transactional
	public boolean deleteAccount(long accountNumber) {
		// TODO Auto-generated method stub

		try
		{
			// get the current hibernate session
			Session session = sessionFactory.getCurrentSession();
			// delete object with primary key
			session.createQuery("delete from Account where accountNumber=:accountNumber")
			.setParameter("accountNumber", accountNumber).executeUpdate();
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	
	}
	
	@Override
	@Transactional
	public List<Account> getCurrentBalanceOfAllAccounts(String userName) {
		// TODO Auto-generated method stub
		try
		{
			Session session = sessionFactory.getCurrentSession();
			List<Account> accounts = session.createQuery("from Account where user_name=:userName",Account.class)
					.setParameter("userName", userName).list();
			
			return accounts;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	
	

}
