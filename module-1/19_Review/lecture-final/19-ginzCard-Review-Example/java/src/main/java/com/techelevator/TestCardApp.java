package com.techelevator;

public class TestCardApp {

	public static void main(String[] args) {
		// create a new deck of cards
		CardDeck myDeck = new CardDeck(false);
		
		System.out.println("-----------------------------------------");
		System.out.println("-- Showing Cards in Deck               --");
		System.out.println("-----------------------------------------");
		
		myDeck.showDeck();
		
		System.out.println("-----------------------------------------");
		System.out.println("-- Shuffle and Show again              --");
		System.out.println("-----------------------------------------");
		
		myDeck.shuffleDeck();
		myDeck.showDeck();
		
		CardHand myHand = new CardHand(5);
		myHand.dealHand(myDeck);
		
		System.out.println("-----------------------------------------");
		System.out.println("-- Showing Cards in Hand               --");
		System.out.println("-----------------------------------------");
	
		myHand.show();
		
		System.out.println("-----------------------------------------");
		System.out.println("-- Showing Cards Left in Deck          --");
		System.out.println("-----------------------------------------");
		
		myDeck.showDeck();
		
		System.out.println("-----------------------------------------");
		System.out.println("-- Showing Cards in Poker Hand         --");
		System.out.println("-----------------------------------------");
		
		PokerHand myPokerHand = new PokerHand();
		myPokerHand.dealHand(myDeck);
		
		myPokerHand.show();
	}

}
