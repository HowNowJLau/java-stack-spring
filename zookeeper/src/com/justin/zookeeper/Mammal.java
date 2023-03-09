package com.justin.zookeeper;

public class Mammal {

	private int energyLevel;
	
	public Mammal() {
		energyLevel = 100;
	}
	
	public Mammal(int energy) {
		energyLevel = energy;
	}

	public int displayEnergy() {
		System.out.println("Current Energy: " + energyLevel);
		return energyLevel;
	}
	
	public void setEnergy(int amount) {
		energyLevel += amount;
	}
}
