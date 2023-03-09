package com.justin.abstractdemo;

public class Test {

	public static void main(String[] args) {
//		Payment payment1 = new Payment(19.90);
		CashPayment laptop = new CashPayment(2000.99);
		System.out.println(laptop.getAmount());
		
		CreditCardPayment computer = new CreditCardPayment(3000.99, "4342", "Justin", "03/08");
		computer.paymentDetails();
	}

}
