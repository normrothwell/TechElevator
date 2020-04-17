package com.techelevator.poker_project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<PlayingCard> deckOfCards = new ArrayList<>();
	
	public Deck() {
		for (char suit: new char[] {'s', 'h', 'd', 'c'}) {
			for (char rank : new char[] {'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K'}) {
				PlayingCard currentCard = new PlayingCard(suit,rank);
				deckOfCards.add(currentCard);
			}
		}
	}
	
public void shuffle() {
	Collections.shuffle(deckOfCards);
	}

public PlayingCard deal() {
	if (deckOfCards.size() != 0) {
		return deckOfCards.remove(0);
	}return null;
}

public String toString() {
	return "Deck " + deckOfCards + "";
	}




}