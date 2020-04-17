package com.techelevator;

public class TestCardApplication {

	public static void main(String[] args) {
		
		CardDeck deck = new CardDeck(false);
//		System.out.println("---------------------------");
//		System.out.println("-- Showing Cards in Deck --");
//		System.out.println("---------------------------");
		
		deck.showDeck();
		
//		System.out.println("---------------------------");
//		System.out.println("-- Shuffle Deck and Show --");
//		System.out.println("---------------------------");
		
		deck.shuffleDeck();
		deck.showDeck();
		
		CardHand hand = new CardHand(5);
		
		System.out.println("---------------------------");
		System.out.println("-- Showing Cards in Hand --");
		System.out.println("---------------------------");
		
		hand.dealHand(deck);
		hand.show();
		
		System.out.println("---------------------------");
		System.out.println("----- Remaining Cards -----");
		System.out.println("---------------------------");
		
		deck.showDeck();
		
		PokerHand myPokerHand = new PokerHand();
		
		System.out.println("---------------------------");
		System.out.println("------ Hand of Poker ------");
		System.out.println("---------------------------");
		
		myPokerHand.dealHand(deck);
		myPokerHand.show();
		
	}

}
