package com.techelevator.playingcard_project;

public class PlayingCardDemo {

	public static void main(String[] args) {
		PlayingCard aceOfSpades = new PlayingCard(); //calls the default constructor
		System.out.println(aceOfSpades);
		PlayingCard deuceOfDiamonds =new PlayingCard("d", '2', 2, true);
		System.out.println(deuceOfDiamonds);
		deuceOfDiamonds.flip();
		System.out.println(deuceOfDiamonds);
	}

}
