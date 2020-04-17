package com.techelevator;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class KataFizzBuzzTest {
	
	@Test
	public void test_fizzbuzz_returns_1_when_1_entered() {
		KataFizzBuzz fb = new KataFizzBuzz();
		assertEquals("1", fb.fizzbuzz(1));
	}
	
	@Test
	public void test_fizzbuzz_returns_fizz_when_3_entered() {
		assertEquals("Fizz", new KataFizzBuzz().fizzbuzz(3));
	}
	
	@Test
	public void test_fizzbuzz_returns_buzz_when_5_entered() {
		assertEquals("Buzz", new KataFizzBuzz().fizzbuzz(5));
	}
	
	@Test
	public void test_fizzbuzz_returns_fizzbuzz_when_15_entered() {
		assertEquals("Fizzbuzz", new KataFizzBuzz().fizzbuzz(15));
	}
	
	@Test
	public void test_fizzbuzz_returns_22_when_22_entered() {
		assertEquals("22", new KataFizzBuzz().fizzbuzz(22));
	}
	
	@Test
	public void test_fizzbuzz_returns_nothing_when_0_entered() {
		assertEquals("", new KataFizzBuzz().fizzbuzz(0));
	}
	
	@Test
	public void test_fizzbuzz_returns_fizz_when_13_entered() {
		assertEquals("Fizz", new KataFizzBuzz().fizzbuzz(13));
	}
	
	@Test
	public void test_fizzbuzz_returns_fizzbuzz_when_35_entered() {
		assertEquals("Fizzbuzz", new KataFizzBuzz().fizzbuzz(35));
	}
	
	@Test
	public void test_fizzbuzz_returns_fizz_when_51_entered() {
		assertEquals("Fizz", new KataFizzBuzz().fizzbuzz(51));

	}
	
	@Test
	public void test_fizzbuzz_returns_fizzbuzz_when_53_entered() {
		assertEquals("Fizzbuzz", new KataFizzBuzz().fizzbuzz(53));
	}
}