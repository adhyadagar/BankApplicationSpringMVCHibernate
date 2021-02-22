package com.finastra.project.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.finastra.project.entity.Account;
import com.finastra.project.entity.Transaction;


@Repository
public class TransactionDAOImpl implements TransactionDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public boolean saveAccount(Transaction t) {
		// TODO Auto-generated method stub
		try
		{
			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(t);
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
	public List<Transaction> getTransactionsByUserName(String userName) {
		// TODO Auto-generated method stub
		try
		{
			Session session = sessionFactory.getCurrentSession();
			List<Transaction> trans = session.createQuery("from Transaction where userName=:userName",Transaction.class)
					.setParameter("userName", userName).list();
			
			return trans;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	@Transactional
	public Transaction getAccount(long accountNumber)
	{
		
		 Session session = sessionFactory.getCurrentSession();
	     
	     return session.get(Transaction.class, accountNumber);
		
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
			session.createQuery("delete from Account where accountNumber=:accountNumber",Transaction.class)
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
	public List<Transaction> getTransactionsByAccountNumber(long accountNumber) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		try
		{
			Session session = sessionFactory.getCurrentSession();
			List<Transaction> trans = session.createQuery("from Transaction where account_number=:accountNumber",Transaction.class)
					.setParameter("accountNumber", accountNumber).list();
			
			return trans;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}


}
