package com.techelevator;

public class LoopPrograms {

	public static void main(String[] args) {
		// Using the numsArray, calculate the average as well as find the smallest and largest values.
	
		
		int[]numsArray = {5, 7, 12, 1, 24, 3};
		int largestValue = numsArray[0];
		int smallestValue = numsArray[0];
		int sum = 0;
		for (int x = 0;x<numsArray.length;x++) {
			sum += numsArray[x];
			if (largestValue < numsArray[x]) {
				largestValue = numsArray[x];
			}
			if (smallestValue > numsArray[x]) {
				smallestValue = numsArray[x];
			}
		}double average = ((double)sum/numsArray.length);
			System.out.println("Smallest:" + smallestValue);
			System.out.println("Largest:" + largestValue);
			System.out.println("Average:" + String.format("%.2f", average));
			
			countByFivesLoop();
		}

	
	public static void countByFivesLoop() {
		System.out.println("\n\nPrinting by 5s from 10 to 100 inclusive");
		for (int x = 10; x<=100;x = x + 5) {
			System.out.println(x);
		}
	}
	
}
