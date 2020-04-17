package com.techelevator.TollBoothCalculator;

public class Truck implements Vehicle {
	
	private int numberOfAxels;
	
	public Truck (int numberOfAxels) {
		this.numberOfAxels = numberOfAxels;
	}

	public int getNumberOfAxels() {
		return numberOfAxels;
	}

	@Override
	public double calculateToll(int distance) {
		if (numberOfAxels == 4) {
			return (distance*0.40);
		}else if (numberOfAxels == 6) {
			return (distance*0.45);
		}else return (distance*0.48);
	}

	@Override
	public String getType() {
		return "Truck";
	}

}
