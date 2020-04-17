package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class FrontTimesTest {

	@Test
	public void generateString_test_returns_Cho_2_times_given_Chocolate() {
		FrontTimes front = new FrontTimes();
		assertEquals("ChoCho", front.generateString("Chocolate", 2));
	}
	
	@Test
	public void generateString_test_returns_Cho_3_times_given_Chocolate() {
		FrontTimes front = new FrontTimes();
		assertEquals("ChoChoCho", front.generateString("Chocolate", 3));
	}
	
	@Test
	public void generateString_test_returns_Abc_3_times_given_Abc() {
		FrontTimes front = new FrontTimes();
		assertEquals("AbcAbcAbc", front.generateString("Abc", 3));
	}

}
