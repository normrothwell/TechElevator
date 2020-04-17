package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class DateFashionTest {

	@Test
	public void getATable_returns_2_given_5_and_10() {
		DateFashion date = new DateFashion();
		assertEquals(2, date.getATable(5, 10));
	}
	
	@Test
	public void getATable_returns_0_given_5_and_2() {
		DateFashion date = new DateFashion();
		assertEquals(0, date.getATable(5, 2));
	}
	
	@Test
	public void getATable_returns_1_given_5_and_5() {
		DateFashion date = new DateFashion();
		assertEquals(1, date.getATable(5, 5));
	}

}
