package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class Lucky13Test {

	@Test
	public void getLucky_returns_true_given_array_of_0_2_4() {
		Lucky13 lucky = new Lucky13();
		int[] test = new int[]{0,2,4};
		assertTrue(lucky.getLucky(test));
	}
	
	@Test
	public void getLucky_returns_false_given_array_of_1_2_3() {
		Lucky13 lucky = new Lucky13();
		int[] test = new int[]{1,2,3};
		assertFalse(lucky.getLucky(test));
	}

	@Test
	public void getLucky_returns_false_given_array_of_1_2_4() {
		Lucky13 lucky = new Lucky13();
		int[] test = new int[]{1,2,4};
		assertFalse(lucky.getLucky(test));
	}


}
