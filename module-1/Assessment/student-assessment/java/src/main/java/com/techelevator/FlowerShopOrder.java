package com.techelevator;

import java.util.Scanner;

public class FlowerShopOrder {

		private String bouquetType = "";
		private int numRoses = 0;
		private double total = 0;
		private boolean sameDayDelivery = false;
		private int zipCode;
		
	public FlowerShopOrder (String bouquetType, int numRoses) {
		this.numRoses = numRoses;
		this.bouquetType = bouquetType;
		
	}
	
	

	public double flowerCost(int flowers) {
		double cost = 19.99 + (flowers*2.99);
		return cost;
	}
	
	public double delivery() {
		double deliveryFee = 0;
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter a delivery zip code: ");
		zipCode = Integer.parseInt(input.nextLine());
		
		if ((zipCode >= 10000) || (zipCode <= 39999)) {
		System.out.println("Would you like same day delivery? Please enter (y)es or (n)o: ");
		String sameDay = input.nextLine();
		sameDay = sameDay.toLowerCase();
			if (sameDay.equals("y")){
				sameDayDelivery = true;
		}
		
		if ((zipCode >= 20000) && (zipCode <= 29999)){
			deliveryFee += 3.99;
			if (sameDayDelivery) {
				deliveryFee += 5.99;
			}
		}
		
		if ((zipCode >= 30000) && (zipCode <= 39999)){
			deliveryFee += 6.99;
			if (sameDayDelivery) {
				deliveryFee += 5.99;
			}
		}
		
			
		}else deliveryFee += 19.99;
		input.close();
		return deliveryFee;
	}
	
	public String getBouquetType() {
		return bouquetType;
	}

	public int getNumRoses() {
		return numRoses;
	}
}
