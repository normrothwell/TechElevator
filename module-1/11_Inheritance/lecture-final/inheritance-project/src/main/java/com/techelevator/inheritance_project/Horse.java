package com.techelevator.inheritance_project;

public class Horse {
	// data members
	private String name;
	private String color;
	private int birthYear;
	
	// if I do not write a constructor, 
	//the computer provides a default one

	public Horse() {
		
	}
	
	public Horse(String name, String color,
			int birthYear) {
		this.name = name;
		this.color = color;
		this.birthYear = birthYear;
	}

	// getters and setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		if (color.equals("Brown") ||
			color.equals("Black")){
				this.color = color;
		} else {
			this.color = "Brown";
		}
	}
	public int getBirthYear() {
		return birthYear;
	}
	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}
	
	@Override // @ means annotation
	// Override tells compiler you are providing a 
	// different version of a method than the parent
	public String toString() {
		return "Horse name: " +  name +
				"\nHorse color: " + color +
				"\nHorse Birth Year: " + birthYear;
		
	}

}
