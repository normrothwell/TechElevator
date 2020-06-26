package com.techelevator.mortgage_project;

import java.util.Scanner;

public class Mortgage {

	public static void main(String[] args) {
		
		double minimumPayment;
		double monthlyInterestRate;
		double interestPaid;
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the amount of the loan: ");
		double amountOfLoan = Double.parseDouble(input.nextLine());
		System.out.printf("%.2f", amountOfLoan);
		System.out.println("\n\nEnter the term of the loan in months: ");
		
		int termOfLoan = Integer.parseInt(input.nextLine());
		System.out.println("\nEnter the interest rate in percent form (10% = 10): ");
		double interestRate = Double.parseDouble(input.nextLine());

		interestRate = interestRate * 0.01;
		monthlyInterestRate = interestRate/12;

		minimumPayment = (amountOfLoan * (monthlyInterestRate * Math.pow((1 + monthlyInterestRate), termOfLoan) / (Math.pow((1 + monthlyInterestRate), termOfLoan) - 1)));
		
		System.out.println("Your monthly payments on a: $" + String.format("%.2f", amountOfLoan) + " loan" + "\nWith a " + (interestRate * 100) + "% interest rate." + "\nare: $" + String.format("%.2f", minimumPayment) + " per month.");
		
		while (amountOfLoan >= 0.01 && termOfLoan > 0) {
			minimumPayment = (amountOfLoan * (monthlyInterestRate * Math.pow((1 + monthlyInterestRate), termOfLoan) / (Math.pow((1 + monthlyInterestRate), termOfLoan) - 1)));
			termOfLoan--;
			interestPaid = amountOfLoan * interestRate * ((double)1/12);
			System.out.println("Your minimum payment due is $" + String.format("%.2f", minimumPayment));
			System.out.println("Your principal remaining is $" + String.format("%.2f", (amountOfLoan)));
			System.out.println("Your payoff amount is $" + String.format("%.2f", (amountOfLoan + interestPaid)));
			System.out.println("Please enter a loan payment amount: $");
			double paymentAmount = Double.parseDouble(input.nextLine());
			paymentAmount -= interestPaid;
			amountOfLoan -= paymentAmount;
			
		}
		System.out.println(String.format("%.6f", minimumPayment));	
		input.close();
	}

}
