package com.finastra.project.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity // so that it is considered as a mappable class
@Table(name = "transaction")
public class Transaction {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "trans_id")
	private int trans_id;
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "account_number")
	private long accountNumber;
	
	@Column(name = "balance")
	private double balance;
	
	@Column(name = "operation")
	private String operation;
	
	@Column(name = "new_balance")
	private double newBalance;
	
	@Column(name = "time_details")
	private Timestamp timeDetails;

	public Transaction() {
			
		}

	/**
	 * @return the trans_id
	 */
	public int getTrans_id() {
		return trans_id;
	}

	/**
	 * @param trans_id the trans_id to set
	 */
	public void setTrans_id(int trans_id) {
		this.trans_id = trans_id;
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
	 * @return the operation
	 */
	public String getOperation() {
		return operation;
	}

	/**
	 * @param operation the operation to set
	 */
	public void setOperation(String operation) {
		this.operation = operation;
	}

	/**
	 * @return the newBalance
	 */
	public double getNewBalance() {
		return newBalance;
	}

	/**
	 * @param newBalance the newBalance to set
	 */
	public void setNewBalance(double newBalance) {
		this.newBalance = newBalance;
	}

	/**
	 * @return the timeDetails
	 */
	public Timestamp getTimeDetails() {
		return timeDetails;
	}

	/**
	 * @param timeDetails the timeDetails to set
	 */
	public void setTimeDetails(Timestamp timeDetails) {
		this.timeDetails = timeDetails;
	}

	@Override
	public String toString() {
		return "Transaction [trans_id=" + trans_id + ", userName=" + userName + ", accountNumber=" + accountNumber
				+ ", balance=" + balance + ", operation=" + operation + ", newBalance=" + newBalance + ", timeDetails="
				+ timeDetails + "]";
	}
	

}
