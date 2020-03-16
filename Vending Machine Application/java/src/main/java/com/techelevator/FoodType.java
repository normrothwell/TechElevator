package com.techelevator;

import java.math.BigDecimal;

public class FoodType {

	private String sound;
	private String slot;
	private String name;
	private BigDecimal price;
	private int quantity;




	public FoodType(String sound, String slot, String name, BigDecimal price, int quantity) {
		super();
		this.sound = sound;
		this.slot = slot;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}




	public String getSlot() {
		return slot;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public String getSound() {
		return sound;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
