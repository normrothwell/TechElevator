package com.techelevator.TollBoothCalculator;

public class Car implements Vehicle {
	
	private boolean hasTrailer;
	
	public Car(boolean hasTrailer) {
		this.hasTrailer = hasTrailer;
	}
	
	public boolean isHasTrailer() {
		return hasTrailer;
	}
	
	@Override
	public double calculateToll(int distance) {
		if (hasTrailer == true) {
			return ((distance *= 0.20)+1);
		}return (distance*=0.20);
	}

	@Override
	public String getType() { //return name of vehicle (ex Car)
		return "Car";
	} 
}
