package com.techelevator;

public class Dog {
	// Data members or data variables or instance variables aka characteristics
	
	private boolean has4Legs;
	private int cutenessFactor;
	private String name;
	
	//default constructor (if no values are entered, set to this default data)
	
	public Dog() {
		this.has4Legs = true;
		this.cutenessFactor = 12;
		this.name = "Spot";
	}
	
	public Dog(String name) {
		this.name = name;
	}
	
	public Dog(boolean has4Legs, int cutenessFactor, String name) { //order matters
		this.has4Legs = has4Legs;
		this.cutenessFactor = cutenessFactor;
		this.name = name;
	}
	
	//Getters and Setters = behavior (methods) for our data members
	
	public void setHas4Legs(boolean has4Legs) {
		this.has4Legs = has4Legs;
	}
	
	public boolean getHas4Legs() {
		return has4Legs;
	}

	public void setCutenessFactor (int cutenessFactor) {
		this.cutenessFactor = cutenessFactor;
	}
	
	public int getCutenessFactor() {
		return cutenessFactor;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void printHowCute () {
		if (cutenessFactor >= 12) {
			System.out.println("This dog is adorable!");
		}else System.out.println("This dog is still great");
	}
	
	
}
