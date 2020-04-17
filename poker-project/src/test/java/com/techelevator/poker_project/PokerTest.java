package com.techelevator.poker_project;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PokerTest {
	

	@Test
	public void TestThreeOfSameRankReturnsThreeOfAKind() {
		PlayingCard[] test = new PlayingCard [5];
		test[0] = new PlayingCard('h', '2');
		test[1] = new PlayingCard('d', '2');
		test[2] = new PlayingCard('d', '3');
		test[3] = new PlayingCard('s', 'K');
		test[4] = new PlayingCard('c', '2');
		
		
		String actual = evaluateHand(test);
		String expected = "Three of a Kind";
		assertEquals(expected, actual);
	}


}
