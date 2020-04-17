package com.techelevator.review;

import java.util.Scanner;

public class EnumDemo {
	
	public enum Directions {
		NORTH, SOUTH, EAST, WEST; // ; is not needed but can be there
	}

	public static void main(String[] args) {
		Directions dir = Directions.NORTH;
		
//		if (dir == Directions.NORTH) {
//			System.out.println("Heading North");
//		} -- can use a SWITCH statement
		
		switch (dir) {
		case NORTH:
			System.out.println("Heading North");
			break;
		case SOUTH:
			System.out.println("Heading South");
			break;
		case EAST:
			System.out.println("Heading East");
			break;
		default:
			System.out.println("Heading West");
		}
		
		Scanner input = new Scanner (System.in);
		
		System.out.println("Enter a direction: ");
		String compassDir = input.nextLine();
		Directions[] dirArray = Directions.values();
		boolean found = false;
		for (Directions d: dirArray) {
			if (d.toString().equals(compassDir.toUpperCase())) {
				System.out.println("Found!");
				found = true;
			} 
		}
		if (!found) {
			System.out.println("Not found :(");
		}

	}

}
