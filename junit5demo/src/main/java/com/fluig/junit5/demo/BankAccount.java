package com.fluig.junit5.demo;

public class BankAccount {

	private double balance;
	private double overdraftProtection;

	public BankAccount(double balance, double overdraftProtection) {
		super();
		this.balance = balance;
		this.overdraftProtection = overdraftProtection;
	}

	public double getBalance() {
		return balance;
	}

	public void credit(double value) {
		this.balance += value;
	}

	public boolean debt(double value) {
		if (value <= balance + overdraftProtection) {
			balance -= value;
			return true;
		} else {
			return false;
		}
	}

}
