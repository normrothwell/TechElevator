package com.techelevator.inheritance_project;

public class HorseDemo {

	public static void main(String[] args) {
		
		Horse horse1 = new Horse();
		

		horse1.setColor("Pink Polka Dot");
		horse1.setName("Daisy");
		horse1.setBirthYear(2000);
		
		printInformation(horse1);
		
		Horse horse2 = new Horse();
		horse2.setColor("Black");
		horse2.setName("Mr. Ed");
		horse2.setBirthYear(1949);
		
		printInformation(horse2);
		
		RaceHorse raceHorse1 = new RaceHorse();
		raceHorse1.setName("ShadowFaax");
		raceHorse1.setColor("Black");
		raceHorse1.setBirthYear(1066);
		raceHorse1.setNumberOfRaces(15);
		
		printInformation(raceHorse1);
		System.out.println("Number of Races: " + raceHorse1.getNumberOfRaces());
		
		System.out.println(raceHorse1);
		
		
		
	}
	
	public static void printInformation(Horse horse) {
		System.out.println("Horse name: " + horse.getName() + "\nHorse color: " + horse.getColor() + "\nHorse birth year: " + horse.getBirthYear());

	}

}
