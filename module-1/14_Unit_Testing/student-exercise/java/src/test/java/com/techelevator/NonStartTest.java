package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class NonStartTest {

	@Test
	public void getPartialString_returns_ellohere_given_Hello_There() {
		NonStart non = new NonStart();
		assertEquals ("ellohere", non.getPartialString("Hello", "There"));
	}
	
	@Test
	public void getPartialString_returns_avaode_given_Java_Code() {
		NonStart non = new NonStart();
		assertEquals ("avaode", non.getPartialString("Java", "Code"));
	}
	
	@Test
	public void getPartialString_returns_hotlava_given_shotl_java() {
		NonStart non = new NonStart();
		assertEquals ("hotlava", non.getPartialString("shotl", "java"));
	}

}
