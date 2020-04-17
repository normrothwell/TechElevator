package com.techelevator.farm;

import java.math.BigDecimal;

public class Tractor implements Singable, Sellable {

	private String name;
	private String sound;
	private String color;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSound() {
		return sound;
	}
	public void setSound(String sound) {
		this.sound = sound;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public BigDecimal getPrice() {
		return BigDecimal.valueOf(32500.00);
	}
	@Override
	public String getSoundOnce() {
		return sound;
	}
	@Override
	public String getSoundTwice() {
		return sound + " " + sound;
	}
	
	
}
