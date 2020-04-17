package com.techelevator.farm;

public class Dog extends FarmAnimal implements Singable {
	
	public Dog() {
		super("Dog", "Ed-ward");
	}

	@Override
	public String getSoundOnce() {
		return "Ed-ward";
		
	}

	@Override
	public String getSoundTwice() {
		return "Ed-ward Ed-ward";
		
	}

}
