package com.techelevator;

import java.util.Scanner; //ctrl+shift+o pulls this code in because we used Scanner below. This calls in code to resolve package errors

public class PricesProgram {

	public static void main(String[] args) {
		
		final double TAX = 0.06; //create a constant using all caps (best practice)
		
		Scanner input = new Scanner(System.in);
		
		
		double[]prices=new double[3];
		
		for (int x=0;x<prices.length;x++) {
			System.out.print("Enter a price: ");
			String priceStr = input.nextLine();
			prices[x]=Double.parseDouble(priceStr);
		}
		for (int x=0;x<prices.length;x++) {
			double tax = prices[x]*TAX;
			//%8.2f means 8 total spots and right justify the number with 2 decimal places
			System.out.println("Price: " + String.format("%8.2f", prices[x]) + "\tTax: " + String.format("%.2f", tax));
		}

		
		
		String s1 = new String("Hello");
		String s2 = new String("Hello");
		System.out.println(s1 == s2); //checks the address of the string (where in memory its stored)
		System.out.println(s1.equals(s2)); //checks the actual data inside the string
		
		System.out.println("Enter any numbers: ");
		String numberStr = input.nextLine();
		System.out.println(numberStr);
		
		String[] numArray = numberStr.split(" "); //.split is used for modular array sizes so we do not need to define the size at the start
		for (int x=0; x<numArray.length; x++) {
			System.out.println(numArray[x]);
		}

		
	}

}
