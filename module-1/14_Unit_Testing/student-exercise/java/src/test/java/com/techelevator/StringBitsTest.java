package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringBitsTest {

	@Test
	public void getBits_retruns_Hlo_given_Hello() {
		StringBits bits = new StringBits();
		assertEquals("Hlo", bits.getBits("Hello"));
	}
	
	@Test
	public void getBits_retruns_Hello_given_Heeololeo() {
		StringBits bits = new StringBits();
		assertEquals("Hello", bits.getBits("Heeololeo"));
	}
	
	@Test
	public void getBits_retruns_H_given_Hi() {
		StringBits bits = new StringBits();
		assertEquals("H", bits.getBits("Hi"));
	}

}
