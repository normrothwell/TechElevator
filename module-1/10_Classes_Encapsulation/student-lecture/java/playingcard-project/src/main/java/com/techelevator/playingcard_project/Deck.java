package com.techelevator.playingcard_project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<PlayingCard> listOfCards = new ArrayList<>();
	
	public Deck() {
		for (String suit: new String[] {"s", "h", "d", "c"}) {
			for (char rank : new char[] {'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K'}) {
				PlayingCard currentCard = new PlayingCard(suit,rank);
				listOfCards.add(currentCard);
			}
		}
	}
	
public void shuffle() {
	Collections.shuffle(listOfCards);
	}

public PlayingCard deal() {
	if (listOfCards.size() != 0) {
		return listOfCards.remove(0);
	}return null;
}

public String toString() {
	return "Deck [ " + listOfCards + " ]";
	}

}
