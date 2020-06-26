package com.techelevator.poker_project;

public class PlayingCard {
	private char suit;
	private char rank;


public PlayingCard() {
	
}

public PlayingCard(char suit, char rank) {
	this.suit = suit;
	this.rank = rank;
}




public char getSuit() {
	return suit;
}


public void setSuit(char suit) {
	this.suit = suit;
}


public char getRank() {
	return rank;
}


public void setRank(char rank) {
	this.rank = rank;
}

public String toString () {
	return "[" + rank + suit + "]";
}


public String evaluateHand (PlayingCard[] hand) {
	
	
	int count = 0;
	String evaluation = "";
	
	
	for (int y = 0; y<hand.length;y++) {
		int tempCount = 0;

		for (int x = 0; x<hand.length; x++) {
			
			if (hand[y].getRank() == hand[x].getRank()) {
				tempCount++;
			}
		}if (tempCount > count) {
			count = tempCount;
		}
	
	}
	switch (count) {
		case 2: evaluation = "One Pair";
		break;
		case 3: evaluation = "Three of a Kind";
		break;
		case 4: evaluation = "Four of a Kind";
		break;
		default: evaluation = "High Card";
		break;
		
	}
	evaluation.substring(8);
	
	return evaluation;
}



}