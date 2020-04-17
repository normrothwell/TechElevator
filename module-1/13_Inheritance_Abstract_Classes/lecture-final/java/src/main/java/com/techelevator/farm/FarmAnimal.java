package com.techelevator.farm;

public class FarmAnimal implements Farm{
	private String name;
	protected String sound;
	// added a new boolean to determine if animal is awake
	private boolean isAwake;

	
	public FarmAnimal(String name, String sound) {
		this.name = name;
		this.sound = sound;
		//start each animal as awake
		isAwake = true;
	}
	
	public String getName() {
		return name;
	}
	
	public final String getSound() {
		if (isAwake) {
			return sound;
		} else {
			return "zzzzz.....";
		}
	}
	
	public boolean getIsAwake() {
		return isAwake;
	}
	
	public void sleep() {
		isAwake = false;
	}

}
