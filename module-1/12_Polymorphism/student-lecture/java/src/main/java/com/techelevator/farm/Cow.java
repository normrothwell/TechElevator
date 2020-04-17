package com.techelevator.farm;

public class Cow extends FarmAnimal implements Singable {

	public Cow() {
		super("Cow", "moo!");
	}

	@Override
	public String getSoundOnce() {
		// TODO Auto-generated method stub
		return "moo";
	}

	@Override
	public String getSoundTwice() {
		// TODO Auto-generated method stub
		return "moo moo";
	}

}