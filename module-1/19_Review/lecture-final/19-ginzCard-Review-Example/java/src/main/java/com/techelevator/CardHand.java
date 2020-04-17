package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class CardHand implements ValidCardHand {
	private int numCardsInHand;
	protected List<PlayingCard> aHand;
	
	public CardHand(int numCardsInHand) {
		this.numCardsInHand = numCardsInHand;
		// passing numCardsInHand to constructor for ArrayList
		// will reserve only that number of places in the heap
		aHand = new ArrayList<>(numCardsInHand);
	}

	
	public List<PlayingCard> getHand() {
		return aHand;
	}
	
	
	@Override
	public void show() {
		for (PlayingCard  aCard: aHand) {
			System.out.println(aCard);
		}
		
	}

	@Override
	public void clearHand() {
		aHand.clear(); // removes all elements from the ArrayList
		
	}

	@Override
	public void dealHand(CardDeck aDeck) {
		for (int i = 0; i < numCardsInHand; i++) {
			aHand.add(aDeck.dealCard());  // take a card from the deck and add to hand
		}
		
	}

	@Override
	public void addCard(PlayingCard aCard) {
		aHand.add(aCard);
		
	}
	
	

	
	

}
