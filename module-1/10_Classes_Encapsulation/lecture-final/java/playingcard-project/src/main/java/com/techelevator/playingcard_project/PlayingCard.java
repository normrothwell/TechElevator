package com.techelevator.playingcard_project;

public class PlayingCard {
	// Define characteristics
	// Data Members, data variables, instance variables
	private String suit;
	private char rank;
	private int value;
	private boolean faceUp;
	
	// Default constructor -- no-arg constructor
	public PlayingCard() {
		this.suit = "Spades";
		this.rank = 'A';
		this.value = 14;
		this.faceUp = false;
	}
	 // Overloaded -- accepts two parameters
	public PlayingCard(String suit, char rank) {
		this.suit = suit;
		this.rank = rank;
	}
	
	 // Overloaded -- accepts all the parameters
	public PlayingCard(String suit, char rank, int value, boolean faceUp) {
		super(); // SANTA CLAUS!!!!!
		this.suit = suit;
		this.rank = rank;
		this.value = value;
		this.faceUp = faceUp;
	}

	public String getSuit() {
		return suit;
	}

	public void setSuit(String suit) {
		if (suit.equals("Spades") || suit.equals("Clubs") ||
				suit.equals("Hearts") || suit.equals("Diamonds")) {
					this.suit = suit;
		}  else {
			this.suit = "unknown";
		}
		
	}

	public char getRank() {
		return rank;
	}

	public void setRank(char rank) {
		this.rank = rank;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public boolean isFaceUp() {
		return faceUp;
	}

	public void setFaceUp(boolean faceUp) {
		this.faceUp = faceUp;
	}
	@Override
	public String toString() {
		return "[" + suit + ", " +
	     rank + ", " + value + ", " + faceUp + "]";
	}

	public boolean flip() {
		// flips the card over
		faceUp = !faceUp;
		return faceUp;
	}
}
