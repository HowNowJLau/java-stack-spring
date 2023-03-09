package com.justin.interfacedemo;

public class Cat extends Pet implements HousePet{

	public Cat() {
		super("random cat name", "cat");
	}

	public Cat(String name) {
		super(name, "cat");
	}

	@Override
	public void showAffection() {
		System.out.println("purr..., scratch, or bite");
		
	}

	@Override
	public void askForFood() {
		System.out.println("Screams");
	}
	
	
}
