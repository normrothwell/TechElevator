package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void add_method_adds_1_and_2_and_returns_3() {
		Calculator calculator = new Calculator();
		int num1 = 1;
		int num2 = 2;
		int expected = 3;
		int actual = calculator.add(num1, num2);
		assertEquals(expected, actual);
	}
	
	@Test
	public void subtract_method_subtracts_1_from_3_and_returns_2() {
		Calculator calculator = new Calculator();
		int num1 = 3;
		int num2 = 1;
		int expected = 2;
		int actual = calculator.subtract(num1, num2);
		assertEquals(expected, actual);
	}

	@Test
	public void add_method_adds_20000_and_4300_and_return_24300() {
		Calculator calculator = new Calculator();
		int num1 = 20000;
		int num2 = 4300;
		int expected = 24300;
		assertEquals (expected, calculator.add(num1, num2));
		
	}
	
	@Test
	public void add_method_adds_16_3_and_3_14159_and_returns_19_4415(){
		Calculator calculator = new Calculator();
		double num1 = 16.3;
		double num2 = 3.14159;
		double expected = 19.44159;
		assertEquals (expected, calculator.add(num1, num2), .00001); ////.0001 is a delta, how much can these 2 be off and considered equal.
	}
	
	@Test
	public void inRange_method_checks_that_14_is_in_range_between_10_and_20() { //in general you want to check edge cases
		Calculator calculator = new Calculator();
		int num1 = 14;
		int bottomRange = 10;
		int topRange = 20;
		assertTrue (calculator.inRange(num1, bottomRange, topRange));
	}
	
}
