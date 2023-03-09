package com.justin.caranddriver;

public class Driver extends Car{

	public Driver() {
		super();
	}

	public void drive() {
		super.setGas(-1);
		System.out.println("Car is being driven. Current gas: " + super.getGas() + "/10");
		checkGameOver();
	}
	
	public void useBoosters() {
		if (super.getGas() < 3) {
			System.out.println("Fuel is too low! Can't use boosters.");
			return;
		}
		super.setGas(-3);
		System.out.println("Boosters activated! Current gas: " + super.getGas() + "/10");
		checkGameOver();
	}
	
	public void refuel() {
		if (super.getGas() > 8) {
			System.out.println("Too much fuel! Can't refuel.");
			return;
		}
		super.setGas(2);
		System.out.println("Car refueled. Current gas: " + super.getGas() + "/10");
	}
	
	private void checkGameOver() {
		if (super.getGas() == 0) {
			System.out.println("Out of gas! Game over.");
		}
	}
}
