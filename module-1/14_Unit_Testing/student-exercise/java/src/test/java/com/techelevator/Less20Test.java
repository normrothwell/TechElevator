package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class Less20Test {

	@Test
	public void method_tests_if_18_is_within_2_of_20() {
		Less20 less20 = new Less20();
		int num1 = 18;
		assertTrue (less20.isLessThanMultipleOf20(num1));
	}

	@Test
	public void method_tests_if_19_is_within_2_of_20() {
		Less20 less20 = new Less20();
		assertTrue (less20.isLessThanMultipleOf20(19));
	}
	
	@Test
	public void method_tests_if_20_is_within_2_of_20() {
		Less20 less20 = new Less20();
		assertFalse(less20.isLessThanMultipleOf20(20));
	}
}
