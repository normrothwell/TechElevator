package com.techelevator.poker_project;

import java.util.Scanner;

public class Poker {

	public static void main(String[] args) {
		boolean replaceLoop = true;
		Scanner input = new Scanner(System.in);
		PlayingCard card = new PlayingCard();
		Deck deckOfCards = new Deck();
		deckOfCards.shuffle();
		PlayingCard hand[] = new PlayingCard[5];
		for (int x=0;x<5;x++) {
			card = deckOfCards.deal();
			hand[x] = card;
		}
		
		for (PlayingCard cards: hand) {
			System.out.printf(cards.toString() + " ");
		}
		while (replaceLoop) {
			System.out.println("\nSelect the position(s) of the cards you would like to replace separated by a space");
			String replace = input.nextLine();
			String[] toReplace = replace.split(" ");
		
			try {
				for (int x = 0;x<toReplace.length;x++) {
				int cardToReplace = Integer.parseInt(toReplace[x]);
				cardToReplace--;
				hand[cardToReplace] = deckOfCards.deal();
			} replaceLoop = false;
			}catch (ArrayIndexOutOfBoundsException exception) {
				System.out.println("Please make a valid selection");
				replaceLoop = true;
			}catch (NumberFormatException exception) {
				System.out.println("Please make sure you only enter numbers");
				replaceLoop = true;
			}
		}
		
		for (PlayingCard cards: hand) {
			System.out.printf(cards.toString() + " ");
		}
		
//		String handEvaluation = evaluateHand(hand);
		
//		System.out.println("\n\n" + handEvaluation);
		
		input.close();
		}

		

}
