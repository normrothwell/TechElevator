package com.techelevator.poker_project;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PokerTest {
	

	@Test
	public void TestThreeOfSameRankReturnsThreeOfAKind() {
		PlayingCard test = new PlayingCard();
		PlayingCard[] testHand = new PlayingCard [5];
		testHand[0] = new PlayingCard('h', '2');
		testHand[1] = new PlayingCard('d', '2');
		testHand[2] = new PlayingCard('d', '3');
		testHand[3] = new PlayingCard('s', 'K');
		testHand[4] = new PlayingCard('c', '2');
		
		
		String actual = test.evaluateHand(testHand);
		String expected = "Three of a Kind";
		assertEquals(expected, actual);
	}


}
