package com.techelevator.farm;

public class Chicken extends FarmAnimal { //implements Singable {  addded at parent level
 
	public Chicken() {
		super("Chicken", "cluck!");
	}

	public void layEgg() {
		System.out.println("Chicken laid an egg!");
	}


}