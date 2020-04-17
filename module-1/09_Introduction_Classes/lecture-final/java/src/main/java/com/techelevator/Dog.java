package com.techelevator;

public class Dog {
	// Data members or data variables or instance variables
	// Characteristics
	private boolean has4Legs;
	private int cutenessFactor;
	private String name;
	
	// Default constructor - no-arg constructor
	public Dog() {
		this.has4Legs = true;
		this.cutenessFactor = 5;
		this.name = "Spot";	
	}
	// another constructor that takes in a string
	// we say this constructor is OVERLOADED because there
	// are two different methods of the same name
	public Dog(String name) {
		this.name = name;
	}
	
	 // another constructor that takes in all 3 data members
	// OVERLOADED AGAIN! Because it is named the same
	public Dog(boolean has4Legs, int cutenessFactor, String name) {
		this.has4Legs = has4Legs;
		this.cutenessFactor = cutenessFactor;
		this.name = name;
	}
	
	
	// Getters and Setters - Behavior (methods) for our data members
	
	public void setHas4Legs(boolean has4Legs) {
		this.has4Legs = has4Legs;
	}

	public boolean getHas4Legs() {
		return has4Legs;
	}
	
	public void setCutenessFactor(int cutenessFactor) {
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
	
	public void printHowCute() {
		if (cutenessFactor >= 5) {
			System.out.println("Hey, it's a cute dog!");
		} else {
			System.out.println("Great personality!");
		}
	}
}
