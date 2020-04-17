package com.techelevator.TollBoothCalculator;

public interface Vehicle {
	
	public double calculateToll(int distance); //abstract method = implementer will provide body
	public String getType(); //abstract method - implementer will provide body
}
