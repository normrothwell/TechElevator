package com.techelevator;

import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a series of base 10 numbers: ");
		String baseTenInput = input.nextLine();
		String[] baseTen = baseTenInput.split(" ");
		for (int x=0;x<baseTen.length;x++) {
			int baseTenInt = Integer.parseInt(baseTen[x]);
			System.out.println(baseTenInt + " to Binary code is " + Integer.toBinaryString(baseTenInt));
			
		
		}input.close();
		
	}

}
