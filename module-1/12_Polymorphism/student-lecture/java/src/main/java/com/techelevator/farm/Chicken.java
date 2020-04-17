package com.techelevator.farm;

public class Chicken extends FarmAnimal implements Singable {

	public Chicken() {
		super("Chicken", "cluck!");
	}

	public void layEgg() {
		System.out.println("Chicken laid an egg!");
	}

	@Override
	public String getSoundOnce() {
		// TODO Auto-generated method stub
		return "cluck";
	}

	@Override
	public String getSoundTwice() {
		// TODO Auto-generated method stub
		return "cluck cluck";
	}

}