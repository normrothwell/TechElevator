package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class AnimalGroupNameTest {

	@Test
	public void getHerd_method_returns_Tower_given_giraffe() {
		AnimalGroupName animals = new AnimalGroupName();
		assertEquals("Tower", animals.getHerd("giraffe"));
	}
	
	@Test
	public void getHerd_method_returns_unknown_given_no_key() {
		AnimalGroupName animals = new AnimalGroupName();
		assertEquals("unknown", animals.getHerd(""));
	}
	
	@Test
	public void getHerd_method_returns_unknown_given_walrus() {
		AnimalGroupName animals = new AnimalGroupName();
		assertEquals("unknown", animals.getHerd("walrus"));
	}

	@Test
	public void getHerd_method_returns_Crash_given_Rhino() {
		AnimalGroupName animals = new AnimalGroupName();
		assertEquals("Crash", animals.getHerd("Rhino"));
	}
	
	@Test
	public void getHerd_method_returns_Crash_given_rhino() {
		AnimalGroupName animals = new AnimalGroupName();
		assertEquals("Crash", animals.getHerd("rhino"));
	}
	
	@Test
	public void getHerd_method_returns_unknown_given_elephants() {
		AnimalGroupName animals = new AnimalGroupName();
		assertEquals("unknown", animals.getHerd("elephants"));
	}
}
