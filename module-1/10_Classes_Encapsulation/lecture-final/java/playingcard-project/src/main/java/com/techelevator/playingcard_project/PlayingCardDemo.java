package com.techelevator.playingcard_project;

public class PlayingCardDemo {

	public static void main(String[] args) {
		//create an object (we called aceOfSpades) of the PlayingCard class
		PlayingCard aceOfSpades = new PlayingCard(); // call the default constructor
		System.out.println(aceOfSpades);
		
		PlayingCard deuceOfDiamonds = 
				new PlayingCard("Diamonds", '2', 2, false);
		System.out.println(deuceOfDiamonds);
		deuceOfDiamonds.flip();
		System.out.println(deuceOfDiamonds);
		
		aceOfSpades.setSuit("Blue Pillar");
		System.out.println(aceOfSpades);
		
	}

}
