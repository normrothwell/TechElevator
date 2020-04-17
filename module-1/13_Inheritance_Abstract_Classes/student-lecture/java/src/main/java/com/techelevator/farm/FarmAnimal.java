package com.techelevator.farm;

public class FarmAnimal implements Farm{
	private String name;
	protected String sound;
	private boolean isAwake;
	
	public FarmAnimal(String name, String sound) {
		this.name = name;
		this.sound = sound;
		isAwake = true;
	}
	
	public String getName() {
		return name;
	}
	
	public final String getSound() {
		if (isAwake == true){
			return sound;
		}return "snore";
	
	}
	
	public boolean getIsAwake() {
		return isAwake;
	}
	
	public void sleep() {
		isAwake = false;
	}

}
