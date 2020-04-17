package com.techelevator;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		
		int sum = 0;
		int priorNumber = 0;
		int holdNum = 0;
		System.out.println("Please enter a non negative number to begin the Fibonacci sequence: ");
		String numString = input.nextLine();
		int number = Integer.parseInt(numString);
		while (number>sum) {
			if (sum == 0) {
				System.out.print(sum);
				sum++;
				priorNumber = 0;
			}else {
				System.out.print(", " + sum);
				holdNum = sum;
				sum = sum + priorNumber;
				priorNumber = holdNum;
				
			}
		}
			
		input.close();
	}

}
