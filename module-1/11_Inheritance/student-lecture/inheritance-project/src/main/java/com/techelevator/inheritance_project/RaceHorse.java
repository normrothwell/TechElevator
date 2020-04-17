package com.techelevator.inheritance_project;

public class RaceHorse extends Horse{

	private int numberOfRaces;

	
	public int getNumberOfRaces() {
		return numberOfRaces;
	}

	public void setNumberOfRaces(int numberOfRaces) {
		this.numberOfRaces = numberOfRaces;
	}


	@Override
	public String toString() {
		// the keyword super refers to the 
		// parent
		return super.toString() +
				"\nNumber of Races: " + 
				numberOfRaces;
	}
}
