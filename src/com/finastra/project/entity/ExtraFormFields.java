package com.finastra.project.entity;

public class ExtraFormFields {
	
	private double amount;
	private long accountNumberReciever;
	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}
	/**
	 * @return the accountNumberReciever
	 */
	public long getAccountNumberReciever() {
		return accountNumberReciever;
	}
	/**
	 * @param accountNumberReciever the accountNumberReciever to set
	 */
	public void setAccountNumberReciever(long accountNumberReciever) {
		this.accountNumberReciever = accountNumberReciever;
	}
	@Override
	public String toString() {
		return "ExtraFormFields [amount=" + amount + ", accountNumberReciever=" + accountNumberReciever + "]";
	}

	
}
