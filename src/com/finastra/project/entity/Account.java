package com.finastra.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity // so that it is considered as a mappable class
@Table(name = "account")
public class Account {

	
	@Column(name = "user_name")
	private String userName;
	
	@Id
	@Column(name = "account_number")
	private long accountNumber;
	
	@Column(name = "balance")
	private double balance;
	
	
	@Column(name = "account_type")
	private String accountType;
	
	@Column(name = "user_id")
	private long userId;

	public Account() {
			
		}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the accountNumber
	 */
	public long getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	/**
	 * @return the accountType
	 */
	public String getAccountType() {
		return accountType;
	}

	/**
	 * @param accountType the accountType to set
	 */
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	/**
	 * @return the userId
	 */
	public long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Account [userName=" + userName + ", accountNumber=" + accountNumber + ", balance=" + balance
				+ ", accountType=" + accountType + ", userId=" + userId + "]";
	}

	

}
