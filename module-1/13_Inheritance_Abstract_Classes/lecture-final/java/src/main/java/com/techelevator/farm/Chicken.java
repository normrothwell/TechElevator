package com.techelevator.farm;

import java.math.BigDecimal;

public class Chicken extends FarmAnimal {

	public Chicken() {
		super("Chicken", "cluck!");
	}
	
	public void layEgg() {
		System.out.println("Chicken laid an egg!");
	}
	
}
