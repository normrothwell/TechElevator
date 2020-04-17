package com.techelevator.calculator;

public class Calculator {

	private int result;
	
	public Calculator() {
		
	}

	public int getResult() {
		return result;
	}
	
	public int add(int addend) {
		this.result += addend;
		return result;
	}
	
	public int getResult(int result) {
		return result;
	}
	
	public int multiply(int multiplier) {
		this.result *= multiplier;
		return result;
	}
	
	public int power(int exponent) {
		this.result = (int)Math.pow(result,  exponent);
		return result;
	}
	
	public void reset() {
		this.result = 0;
	}
	
	public int subtract(int subtrahend) {
		this.result -= subtrahend;
		return result;
	}
	
}
