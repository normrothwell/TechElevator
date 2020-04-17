package com.techelevator;

public interface ValidCardHand {

	public void show();
	public void clearHand();
	public void dealHand(CardDeck deck);
	public void addCard(PlayingCard card);
	
}
