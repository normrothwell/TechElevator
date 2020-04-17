package com.techelevator.farm;

import java.util.Scanner;

public class OldMacdonald {
	public static void main(String[] args) {

		FarmAnimal[] farmAnimals = new FarmAnimal[] { new Cow(), new Chicken(), 
				new Sheep()};

		for (FarmAnimal animal : farmAnimals) {
			String name = animal.getName();
			String sound = animal.getSoundOnce();
			String soundTwice = animal.getSoundTwice();
			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he had a " + name + ", ee, ay, ee, ay, oh!");
			System.out.println("With a " + soundTwice + " here");
			System.out.println("And a " + soundTwice +  " there");
			System.out.println("Here a " + sound + " there a " + sound + " everywhere a " + sound + " " + sound);
			System.out.println();
		}
		
		Sheep sheep1 = new Sheep();
		
		System.out.println(sheep1.getSoundOnce());
		
		Tractor tractor = new Tractor();
		tractor.setName("tractor");
		tractor.setColor("red");
		tractor.setSound("vroom");
		System.out.println("My " + tractor.getName() + "goes " +
		   tractor.getSoundTwice());
		
		Scanner input = new Scanner(System.in);
		System.out.println("What type of crop do you wish to buy?");
		Crops crop = new Crops();
		crop.setName(input.nextLine());
		System.out.println("What unit are you buying?");
		crop.setUnit(input.nextLine());
		System.out.println("That will cost " + 
		   crop.getPrice().setScale(2, java.math.BigDecimal.ROUND_HALF_DOWN));
		
	}
}