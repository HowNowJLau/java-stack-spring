package com.justin.abstractdemo;

public abstract class Payment {
	protected double amount;
	
	public Payment(double amount) {
		this.amount = amount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public void paymentDetails() {
		System.out.println("Amount: " + this.amount);
	}
}
