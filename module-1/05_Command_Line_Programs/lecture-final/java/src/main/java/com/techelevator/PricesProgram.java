package com.techelevator;

import java.util.Scanner;

public class PricesProgram {

	public static void main(String[] args) {
		// create a constant - final says this is a constant
		// all CAPS is good programming practice
		final double TAX = 0.06;
		// create connection between program and keyboard for input
		Scanner input = new Scanner(System.in);
		
		double [] prices = new double[3];
		
		for (int x = 0; x < prices.length; x++) {
			System.out.println("Enter a price: ");
			String priceStr = input.nextLine();
			prices[x] = Double.parseDouble(priceStr);
		}
		
		//output the amount of tax
		for (int x = 0; x < prices.length; x++) {
			double tax = prices[x] * TAX;
			// %8.2f means 8 total spots and right justify the number with 
			// 2 decimal places
			System.out.println("Price: " + String.format("%8.2f", prices[x]) +
					"         Tax: " + String.format("%8.2f", tax));
		}

		
		String s1 = new String("Hello");
		String s2 = new String("Hello");
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
		
		System.out.println("Enter three numbers: ");
		String numberStr = input.nextLine();
		System.out.println(numberStr);
		
		String[] numArray = numberStr.split(" ");
		for (int x = 0; x < numArray.length; x++) {
			System.out.println(numArray[x]);
		}
		input.close();
	}

}
