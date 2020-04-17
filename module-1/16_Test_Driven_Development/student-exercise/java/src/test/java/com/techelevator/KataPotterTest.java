package com.techelevator;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class KataPotterTest {
	
	@Test
	public void test_1_book_equals_8() {
		int[] books = {1,0,0,0,0};
		assertEquals (8, new KataPotter().getCost(books), .001);
	}
	
	@Test
	public void test_2_different_books_equals_15_20() {
		int[] books = {1,1,0,0,0};
		assertEquals (15.2, new KataPotter().getCost(books), .001);
	}
	
	@Test
	public void test_3_different_books_equals_21_60() {
		int[] books = {1,1,0,1,0};
		assertEquals (21.6, new KataPotter().getCost(books), .001);
	}
	
	@Test
	public void test_4_different_books_equals_25_60() {
		int[] books = {0,1,1,1,1};
		assertEquals (25.6, new KataPotter().getCost(books), .001);
	}
	
	@Test
	public void test_5_different_books_equals_30() {
		int[] books = {1,1,1,1,1};
		assertEquals (30, new KataPotter().getCost(books), .001);
	}
	
	@Test
	public void test_1_of_each_book_plus_1_additional_book_equals_38() {
		int[] books = {1,1,2,1,1};
		assertEquals (38, new KataPotter().getCost(books), .001);
	}
	
	@Test
	public void test_a_set_of_2_different_books_and_a_set_of_3_different_books_equals_36_80() {
		int[] books = {2,2,1,0,0};
		assertEquals (36.8, new KataPotter().getCost(books), .001);
	}
	
	@Test
	public void test_a_set_of_5_and_a_set_of_3_returns_51_60() {
		int[] books = {2,2,2,1,1};
		assertEquals (51.6, new KataPotter().getCost(books), .001);
	}
}
