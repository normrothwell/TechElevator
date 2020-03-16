package com.techelevator;

import java.math.BigDecimal;

public class Drink extends FoodType {
	
	
	public Drink (String slot, String name, BigDecimal price) {
		super ("Glug Glug, Yum!",slot, name, price, 5 );
	}
}
