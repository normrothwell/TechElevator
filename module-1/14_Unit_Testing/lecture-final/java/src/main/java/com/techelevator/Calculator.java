package com.techelevator;

public class Calculator {
	
	// add is OVERLOADED!!!
	public int add(int number1, int number2) {
		return number1 + number2;
	}
	// add is OVERLOADED!!!
	public double add(double number1, double number2) {
		return number1 + number2;
	}
	
	public int subtract (int number1, int number2) {
		return number1 - number2;
	}
	
	public boolean inRange(int number, int bottomRange, int topRange) {
		if (number > bottomRange && number < topRange) {
			return true;
		}
		return false;
	}

}
