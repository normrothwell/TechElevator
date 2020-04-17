package com.techelevator.playingcard_project;

public class DeckDemo {

	public static void main(String[] args) {
		//Create a deck of cards
		Deck deckOfCards = new Deck();
		System.out.println(deckOfCards);
		
		deckOfCards.shuffle();
		System.out.println((deckOfCards));
		
		PlayingCard myCard = deckOfCards.deal();
		myCard.flip();
		System.out.println(myCard);
		
		PlayingCard yourCard = deckOfCards.deal();
		System.out.println(yourCard);	
		
		if (myCard.getRank() > yourCard.getRank()) {
			System.out.println("I win!");
		} else {
			System.out.println("You won...");
		}
		
		PlayingCard[] myHand = new PlayingCard[5];
		PlayingCard[] yourHand = new PlayingCard[5];
		
		for (int i = 0; i < 5; i++) {
			yourHand[i] = deckOfCards.deal(); // method from Deck
			myHand[i] = deckOfCards.deal(); // method from Deck
		}
		System.out.println("\nMy cards:");
		for (int i = 0; i < 5; i++) {
			System.out.println(myHand[i]);		
		}
		System.out.println("\nYour cards:");
		for (int i = 0; i < 5; i++) {
			System.out.println(yourHand[i]);		
		}
		
		
	}

}
