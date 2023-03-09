package com.justin.zookeeper;

public class Gorilla extends Mammal{

	public Gorilla() {
		super();
	}
	
	public void throwSomething() {
		super.setEnergy(-5);
		System.out.println("The gorilla has thrown something! Watch out!");
		super.displayEnergy();
	}
	
	public void eatBananas() {
		super.setEnergy(10);
		System.out.println("The gorilla eats some bananas. It is very satisfied.");
		super.displayEnergy();
	}
	
	public void climb() {
		super.setEnergy(-10);
		System.out.println("The gorilla is climbing a tree.");
		super.displayEnergy();
	}
}
