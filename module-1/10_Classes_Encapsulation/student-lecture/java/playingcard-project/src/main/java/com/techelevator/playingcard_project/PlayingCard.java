package com.techelevator.playingcard_project;

public class PlayingCard {
	private String suit;
	private char rank;
	private int value;
	private boolean faceUp;



public PlayingCard() {
	this.suit = "s";
	this.rank = 'A';
	this.value = 14;
	this.faceUp = false;
}

public PlayingCard(String suit, char rank) {
	this.suit = suit;
	this.rank = rank;
}


public PlayingCard(String suit, char rank, int value, boolean faceUp) {
	super();
	this.suit = suit;
	this.rank = rank;
	this.value = value;
	this.faceUp = faceUp;
}





public String getSuit() {
	return suit;
}



public void setSuit(String suit) {
	this.suit = suit;
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

public String toString () {
	return "[ " + rank + suit + ", " + value + " " + faceUp + " ]";
	}
	
public boolean flip() {
	faceUp = !faceUp;
	return faceUp;
}


}

