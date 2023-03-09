package com.justin.zookeeper;

public class Bat extends Mammal{

	public Bat() {
		super(300);
	}
	
	public void fly() {
		super.setEnergy(-50);
		System.out.println("Flap!");
		super.displayEnergy();
	}
	
	public void eatHuman() {
		super.setEnergy(25);
		System.out.println("AHHH!!!");
		super.displayEnergy();
	}
	
	public void attackTown() {
		super.setEnergy(-100);
		System.out.println("SOMEBODY HELP!!!");
		super.displayEnergy();
	}

}
