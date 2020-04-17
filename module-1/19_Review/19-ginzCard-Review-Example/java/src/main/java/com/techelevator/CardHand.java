package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class CardHand implements ValidCardHand {
	
	private int numCardsInHand;
	protected List <PlayingCard> hand;
	
	public CardHand(int numCardsInHand) {
		this.numCardsInHand = numCardsInHand;
		hand = new ArrayList<>(numCardsInHand);
	}

	public List<PlayingCard> getHand() {
		return hand;
	}
	
	public void addCard(PlayingCard card) {
		hand.add(card);
	}


	@Override
	public void show() {
		for (PlayingCard card: hand){
			System.out.println(card);
		}
	}


	@Override
	public void clearHand() {
		hand.clear();
	}


	@Override
	public void dealHand(CardDeck deck) {
		for (int x = 0;x<numCardsInHand;x++) {
			hand.add(deck.dealCard());
		}
	}
}
