package com.techelevator;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.techelevator.PlayingCard.CardSuit;
import com.techelevator.PlayingCard.CardValue;

public class CardDeck {
	
	Queue<PlayingCard> deckOfCards = new LinkedList<>();

	public static final int NUMBER_OF_CARDS_FOR_SUIT = 13;
	
	
	public CardDeck(){
		resetDeck(true);
	}
	
	public CardDeck(boolean withJokers) { //this allows user to define if they want jokers
		resetDeck(withJokers);
	}
	
	public void resetDeck(boolean withJokers) {
		deckOfCards.clear(); //removes all elements from the Queue
		for (int x = 1; x<= NUMBER_OF_CARDS_FOR_SUIT;x++) {
			deckOfCards.add(new PlayingCard(x, PlayingCard.CardSuit.SPADE));
		}
		for (int x = 1; x<= NUMBER_OF_CARDS_FOR_SUIT;x++) {
			deckOfCards.add(new PlayingCard(x, PlayingCard.CardSuit.HEART));
		}
		for (int x = 1; x<= NUMBER_OF_CARDS_FOR_SUIT;x++) {
			deckOfCards.add(new PlayingCard(x, PlayingCard.CardSuit.DIAMOND));
		}
		for (int x = 1; x<= NUMBER_OF_CARDS_FOR_SUIT;x++) {
			deckOfCards.add(new PlayingCard(x, PlayingCard.CardSuit.CLUB));
		}
		if (withJokers) {
			deckOfCards.add(new PlayingCard(CardValue.JOKER, CardSuit.JOKER));
			deckOfCards.add(new PlayingCard(CardValue.JOKER, CardSuit.JOKER));
		}
	
	}
	
	public void shuffleDeck() {
		Collections.shuffle((List<?>) deckOfCards);
	}
	
	public PlayingCard dealCard() {
			if (deckOfCards.size() > 0) {
				return deckOfCards.remove();
			}return null;
	}

	
	public void showDeck() {
		System.out.println("Number of cards in deck: " + deckOfCards.size());
		for (PlayingCard card: deckOfCards) {
			card.showCardWithHash();
		}
	}
}
