package com.techelevator.farm;

public class Cat extends FarmAnimal {

	public Cat() {
		super("Cat", "meow");
	}
	
	// changed getSound to be final in the parent's class. Can not override a final.
//	public String getSound() {
//		return sound;
//	}

}
