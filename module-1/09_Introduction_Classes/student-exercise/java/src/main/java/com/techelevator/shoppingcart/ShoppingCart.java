package com.techelevator.shoppingcart;

public class ShoppingCart {

	private int totalNumberOfItems = 0;
	private double totalAmountOwed = 0;

	
	public ShoppingCart() {
		
	}
	
	
	public int getTotalNumberOfItems() {
		return totalNumberOfItems;
	}



	public double getTotalAmountOwed() {
		return totalAmountOwed;
	}

	public void addItems(int numberOfItems, double pricePerItem) {
		totalNumberOfItems += numberOfItems;
		totalAmountOwed = (pricePerItem * numberOfItems);
		
	}

	public double getAveragePricePerItem() {
		if (totalNumberOfItems > 0) {
		return (totalAmountOwed / (double)totalNumberOfItems);
		}return (totalAmountOwed);
	}
	
	public void empty() {
		totalNumberOfItems = 0;
		totalAmountOwed = 0;
	}
	
	
}
