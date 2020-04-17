package com.techelevator.inheritance_project;

public class HorseDemo {

	public static void main(String[] args) {
		// Create a plain old horse
		Horse horse1 = new Horse();
		
//		printInformation(horse1);
		
		horse1.setColor("Pink Polka Dot");
		horse1.setName("Daisy");
		horse1.setBirthYear(2000);
		System.out.println(horse1);
//		printInformation(horse1);
		Horse horse2 = new Horse();
		horse2.setName("Mr.Ed");
		horse2.setColor("Black");
		horse2.setBirthYear(1949);
		
	//	printInformation(horse2);
		System.out.println(horse2);
		
		RaceHorse raceHorse1 = new RaceHorse();
		raceHorse1.setName("ShadowFax");
		raceHorse1.setColor("Black");
		raceHorse1.setBirthYear(1066);
		raceHorse1.setNumberOfRaces(15);
		
		System.out.println(raceHorse1);
		
		
//		printInformation(raceHorse1);
//		System.out.println("Number of Races: " + 
//		   raceHorse1.getNumberOfRaces());

	}
	
	// separate method to print horse information
	public static void printInformation(Horse horse) {
		System.out.println("Horse name: " + horse.getName() +
				"\nHorse color: " + horse.getColor() + 
				"\nHorse Birth Year: " + horse.getBirthYear());
		
	}

}
