package com.techelevator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class FractionTest {

	@Test
	public void test_constructor_for_1_over_4() {
		Fraction fraction = new Fraction(1,4);
		assertEquals("1/4", fraction.toString());
	}
	
	@Test
	public void test_multiply_returns_1_over_8_given_1_over_4_times_1_over_2() {
		Fraction a = new Fraction (1,4);
		Fraction b = new Fraction (1,2);
		Fraction answer = Fraction.multiply(a, b);
		assertEquals("1/8", answer.toString());
	}
	
	@Test
	public void test_equals_for_1_over_4_and_1_over_4() {
		assertEquals(new Fraction(1,4), new Fraction(1,4));
	}
	
	@Test
	public void test_not_equals_() {
		assertFalse(new Fraction(1,4).equals(new Fraction (3,4)));
	}
	
	@Test
	public void test_equals_for_2_over_4_and_1_over_2() {
		assertEquals(new Fraction (2,4), new Fraction (1,2));
	}
	
	@Test
	public void test_gcd_for_15_and_25_returns_5() {
		assertEquals(5, Fraction.gcd(15, 25));
	}
	
/*	@Test
	public void test_subtract_1_over_2_minus_1_over_8_returns_3_over_8() {
		Fraction a = new Fraction (1,2);
		Fraction b = new Fraction (1,8);
		Fraction answer = Fraction.subtract(a,b);
		assertEquals("3/8", answer.toString());
	}
*/
}
