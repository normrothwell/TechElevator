package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

	
	@Test // MUST HAVE THIS IN ORDER for the tests to run
	public void add_method_adds_1_and_2_and_returns_3() {
		Calculator calculator = new Calculator();
		int num1 = 1;
		int num2 = 2;
		int expected = 3;
		int actual = calculator.add(num1, num2);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void add_method_adds_20000_and_4300_and_returns_2147500043() {
		Calculator calculator = new Calculator();
		int num1 = 20000;
		int num2 = 4300;
		
		assertEquals(24300, calculator.add(num1, num2));	
	}
	
	@Test
	public void add_method_adds_16_3_and_3_1415_and_returns_19_4415(){
		Calculator calculator = new Calculator();
		
		// when comparing doubles, you need to add a delta for rounding
		assertEquals(calculator.add(16.3, 3.1415), 19.4415, 0.00001); // 0.00001 is delta
		
	}
	@Test
	public void subtract_method() {
		Calculator calculator = new Calculator();
		assertEquals(calculator.subtract(5, 2), 3);
	}
	
	@Test
	public void inRange_method_checks_that_14_is_in_range_of_10_and_20() {
		Calculator calculator = new Calculator();
		assertTrue(calculator.inRange(14, 10, 20));
		// a good idea to check edge cases!!!
	}
	

}

















