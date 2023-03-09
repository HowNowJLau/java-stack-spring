package com.justin.interfacedemo;

public class Dog extends Pet implements HousePet{

	public Dog() {
		super("random dog name", "dog");
	}
	
	public Dog(String name) {
		super(name, "dog");
	}

	@Override
	public void showAffection() {
		System.out.println("It doesn't.");
	}

	@Override
	public void askForFood() {
		System.out.println("Barks, whines, howls, drools");	
	}

}
