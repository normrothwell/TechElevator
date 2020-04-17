package com.techelevator.farm;

public class Cat extends FarmAnimal {

	public Cat() {
		super("Cat", "meow");
	}
	
	//  -- we changed getSound to be final in the parent class
	// therefore it CANNOT be overridden!
//	@Override
//	public String getSound() {
//		return sound;
//	}

}
