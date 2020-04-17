package com.techelevator.farm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OldMacDonald {

	public static void main(String[] args) {
		FarmAnimal[] inventory = new FarmAnimal[6]; 
		
		for (int i=0 ; i < 6; i++) {
			int random = (int)(Math.random() * 4);
			if (random == 0) {
				inventory[i] = new Chicken();
			}
			else if (random == 1) {
				inventory[i] = new Cow();
			}
			else if (random == 2) {
				inventory[i] = new Sheep();
			} else {
				inventory[i] = new Cat();
			}
			inventory[i].sleep();
		}
			
		inventory[1].sleep();
		inventory[4].sleep();
		
		for (FarmAnimal item : inventory) {
			String sound = item.getSound();
			System.out.println("Old MacDonald had a farm, ee ay ee ay o");
			System.out.println("And on that farm he had a " + item.getName() 
			 + " ee ay ee ay o");
			System.out.println("With a " + sound + " " + sound + " here, and a " );
			System.out.println(sound + " " + sound + " there");
			System.out.println("Here are " + sound + " there a " + sound + " everywhere a " 
			  + sound + " " + sound);
			System.out.println("Old MacDonald had a farm, ee ay ee ay o\n");
		}
		
		
		
	}

}
