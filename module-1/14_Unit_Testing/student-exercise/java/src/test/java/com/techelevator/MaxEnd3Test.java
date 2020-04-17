package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class MaxEnd3Test {

	@Test
	public void MakeArray_returns_3_3_3_given_array_of_1_2_3() {
		MaxEnd3 max = new MaxEnd3();
		int[] test = new int[]{1,2,3};
		int[] expected = new int[] {3,3,3};
		assertArrayEquals(expected, max.makeArray(test));
	}
	
	@Test
	public void MakeArray_returns_11_11_11_given_array_of_11_5_9() {
		MaxEnd3 max = new MaxEnd3();
		int[] test = new int[]{11,5,9};
		int[] expected = new int[] {11,11,11};
		assertArrayEquals(expected, max.makeArray(test));
	}
	
	@Test
	public void MakeArray_returns_3_3_3_given_array_of_2_11_3() {
		MaxEnd3 max = new MaxEnd3();
		int[] test = new int[]{2,11,3};
		int[] expected = new int[] {3,3,3};
		assertArrayEquals(expected, max.makeArray(test));
	}


}
