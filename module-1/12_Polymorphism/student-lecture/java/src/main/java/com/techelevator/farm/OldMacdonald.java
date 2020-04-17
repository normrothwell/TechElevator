package com.techelevator.farm;

import java.math.BigDecimal;
import java.util.Scanner;

public class OldMacdonald {
	public static void main(String[] args) {

		FarmAnimal[] farmAnimals = new FarmAnimal[] { new Cow(), new Chicken(), new Dog() };

		for (FarmAnimal animal : farmAnimals) {
			String name = animal.getName();
			String sound = animal.getSound();
			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he had a " + name + ", ee, ay, ee, ay, oh!");
//			System.out.println("With a " + name.getSoundTwice() + " here");
			System.out.println("And a " + sound + " " + sound + " there");
			System.out.println("Here a " + sound + " there a " + sound + " everywhere a " + sound + " " + sound);
			System.out.println();
		}
		
		Dog nina = new Dog();
		Tractor tractor = new Tractor();
		tractor.setName("tractor");
		tractor.setColor("Green");;
		tractor.setSound("Tractor sounds");
		
		Scanner input = new Scanner (System.in);
		System.out.println("What type of crop do you wish to buy?");
		Crops crop = new Crops();
		crop.setName(input.nextLine());
		System.out.println("What unit are you buying?");
		crop.setUnit(input.nextLine());
		System.out.println("That will cost " + crop.getPrice().setScale(2, BigDecimal.ROUND_HALF_DOWN));
		
		
		System.out.println(nina.getSoundOnce());
		input.close();
	}
}