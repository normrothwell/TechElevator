package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class FractionTest {

	@Test
	public void test_constructor_for_1_over_4() {
		Fraction fraction = new Fraction(1, 4);
		String expected = "1/4";
		assertEquals(expected, fraction.toString());
		
	}
	
	@Test
	public void test_multiply_of_1_over_4_and_2_over_4() {
		Fraction fractiona = new Fraction (1, 4);
		Fraction fractionb = new Fraction (2, 4);
		String expected = "1/8";
		
		// if the Fraction method multiply was NOT STATIC
		// we would use one object name .multiply
		// so fractiona.multiply(fractionb) in order to multiply
		// them together
		Fraction answer = Fraction.multiply(fractiona, fractionb);
		assertEquals(expected, answer.toString());
	}
	
	@Test
	public void test_equals_for_1_over_4_and_1_over_4() {
		assertEquals(new Fraction(1,4), new Fraction(1,4));
		
		//fractiona.equals(fractionb) - this is how we call the .equals
	}
	
	@Test 
	public void test_not_equals() {
		assertFalse(new Fraction(1, 4).equals(new Fraction(3, 4)));
	
	}
	
	@Test
	public void test_equals_for_2_over_4_and_1_over_2() {
		assertEquals(new Fraction(2, 4), new Fraction(1, 2));
	}
	
	@Test
	public void test_gcd_for_25_and_15() {
		assertEquals(5, Fraction.gcd(15,  25));
	}

}









