package com.techelevator;

public interface ValidCardHand {
	
	public void show(); // display all cards in hand
	public void clearHand(); // remove all cards from hand
	public void dealHand(CardDeck aDeck); // fill a hand from CardDeck
	public void addCard(PlayingCard aCard); // Add card to hand

}
