package com.techelevator;

public class KataPotter {


	public double getCost (int[] books) {
		int set = 0;
		double totalCost = 0;
		do  {
		set = 0;
		for (int x = 0;x<books.length;x++) {
			if (books[x]>0) {
				set++;
				books[x]--;
			}
		}
		if (set == 1) {
			totalCost += 8;
		}else if (set == 2) {
			totalCost += 15.2;
		}else if (set == 3) {
			totalCost += 21.6;
		}else if (set == 4) {
			totalCost += 25.6;
		}else if (set == 5) {
			totalCost += 30;
		}
		}while ((books[0] > 0) || (books[1] > 0) || (books[2] > 0) || (books[3] > 0) || (books[4] > 0));
		return totalCost;
		}



}