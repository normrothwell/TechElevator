package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class SameFirstLastTest {

	@Test
	public void isTheSame_returns_false_given_array_1_2_3() {
		SameFirstLast firstlast = new SameFirstLast();
		int[] test = new int[]{1,2,3};
		assertFalse(firstlast.isItTheSame(test));
	}

	@Test
	public void isTheSame_returns_true_given_array_1_2_3_1() {
		SameFirstLast firstlast = new SameFirstLast();
		int[] test = new int[]{1,2,3,1};
		assertTrue(firstlast.isItTheSame(test));
	}
	
	@Test
	public void isTheSame_returns_false_given_array_1_2_1() {
		SameFirstLast firstlast = new SameFirstLast();
		int[] test = new int[]{1,2,1};
		assertTrue(firstlast.isItTheSame(test));
	}
	
}
