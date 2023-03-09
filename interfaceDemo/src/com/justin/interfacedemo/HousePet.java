package com.justin.interfacedemo;

public interface HousePet {
	// default: usable
	public default void play() {
		System.out.println("playing...");
	}
	
	abstract void showAffection();
	abstract void askForFood();
}
