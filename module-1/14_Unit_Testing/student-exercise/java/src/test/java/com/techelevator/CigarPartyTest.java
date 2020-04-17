package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class CigarPartyTest {

	@Test
	public void haveParty_with_30_cigars_during_the_week_returns_false() {
		CigarParty party = new CigarParty();
		assertFalse(party.haveParty(30, false));
	}
	
	@Test
	public void haveParty_with_50_cigars_during_the_week_returns_true() {
		CigarParty party = new CigarParty();
		assertTrue(party.haveParty(50, false));
	}
	
	@Test
	public void haveParty_with_70_cigars_during_the_weekend_returns_true() {
		CigarParty party = new CigarParty();
		assertTrue(party.haveParty(70, true));
	}

}
