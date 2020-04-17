package com.techelevator.playingcard_project;

public class DeckDemo {

	public static void main(String[] args) {
		Deck deckOfCards = new Deck();
		System.out.println(deckOfCards);
		
		deckOfCards.shuffle();
		System.out.println(deckOfCards);
		
		PlayingCard myCard = deckOfCards.deal();
		myCard.flip();
		System.out.println(myCard);
		
	}

}
