package com.techelevator.exceptions;

import java.util.Scanner;

public class ExceptionsLecture {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String [] cities = {"Detroit", "Dearborn", "Sterling Heights", "Livonia", "Canton"};
		
		System.out.println("The followiung cities: ");
		
		try {
			for (int x = 0; x< cities.length; x++) {
				System.out.println(cities[x]);
			}
		
			System.out.println("We don't like Toledo");
		
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("*** Something went wrong ***");
		}
		
		System.out.println("are great cities\n");
		try {
			doSomethingDangerous();
	
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("*** Error ***");
		}
		try {
		System.out.println("\nHow many hours did you work this week? ");
		int hoursWorked = Integer.parseInt(scan.nextLine());
		int overTimeHours = hoursWorked - 40;
		System.out.println("You worked " + overTimeHours + " hours of overtime ");
	
		} catch (NumberFormatException e) {
			System.out.println("No fractions please");
		} catch (Exception e) {
			System.out.println("You did it wrong: ");
		}
		
		int nights = -3;
		int numGuests = -2;
		try {
		double amountOwed = calculateHotelRoomCharges(nights, numGuests);
			System.out.println("total owed for " + numGuests + " guests for " + nights + " nights");
		
		}catch (IllegalArgumentException e) {
			// this will swallow an exception - always need something inside of catch block
		}
		double balance = 250;
		double withdraw = 1000;
		try {
			double newBalance = withdraw(balance, withdraw);
			System.out.println("Your new balance is: " + newBalance);
		}catch (OverdraftException e) {
			System.out.println("You do not have the funds to do that");
			System.out.println("This would overdraw you by " + e.getOverdraftAmount());
		}
	}	
		
	
	// Utility functions:
	
	private static double calculateHotelRoomCharges(int nights, int numberOfGuests) {
		final double EXTRA_GUEST_CHARGE = 20;
		final double ROOM_RATE = 85;
		
		/* The throw statements below demonstrate how to throw a new Exception. */
		if(nights < 1) {
			throw new IllegalArgumentException("Minimum number of nights is 1");
		} else if(numberOfGuests < 1) {
			throw new IllegalArgumentException("Minimum number of guests is 1");
		}
		
		int numberOfExtraGuests = 0;
		if(numberOfGuests > 4) {
			numberOfExtraGuests = numberOfGuests - 4;
		}
		
		double dailyRate = ROOM_RATE + (EXTRA_GUEST_CHARGE * numberOfExtraGuests);
		return dailyRate * nights;
	}
	
	
	public static double withdraw(double currentBalance, double amountToWithdraw) throws OverdraftException {
		double newBalance;
		if(amountToWithdraw <= currentBalance) {
			newBalance = currentBalance - amountToWithdraw;
		} else {
			throw new OverdraftException("The requested withdrawal amount is greater than the current balance", Math.abs(currentBalance - amountToWithdraw));
		}
		return newBalance;		
	}

	
	private static void doSomethingDangerous() {
		int[] numbers = new int[5];
		for(int i = 0; i < 10; i++) {
			numbers[i] = i;  // this line will throw an Exception once i reaches 5
		}
		System.out.println("Look Ma, no Exceptions!");  // This line will not execute because an Exception will be thrown inside the for loop
	}

}
