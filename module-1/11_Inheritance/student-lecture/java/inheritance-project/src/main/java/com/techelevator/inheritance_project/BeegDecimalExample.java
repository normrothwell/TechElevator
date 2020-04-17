package com.techelevator.inheritance_project;

import java.math.BigDecimal;

public class BeegDecimalExample {

	public static void main(String[] args) {
		
		BigDecimal bd1 = new BigDecimal(120.99);
		BigDecimal bd2 = new BigDecimal("356.25");
		
		System.out.println("Value of first is: " + bd1.setScale(2, BigDecimal.ROUND_HALF_DOWN) + "\nValue of second is: " + bd2);

		bd1 = bd1.add(bd2);
		System.out.println("The value of the 2 added together is: " + bd1.setScale(2, BigDecimal.ROUND_HALF_DOWN));
		bd1 = bd1.subtract(new BigDecimal (5.99));
		System.out.println("The new value of bd1 is: " + bd1.setScale(2, BigDecimal.ROUND_HALF_DOWN));
		
	
		BigDecimal bd3 = bd2.pow(4);
		System.out.println("bd2 raised to the 4th power: "+ bd3.setScale(2, BigDecimal.ROUND_HALF_DOWN));
		
		BigDecimal balance1 = new BigDecimal (100);
		BigDecimal balance2 = new BigDecimal (200);
		BigDecimal test = new BigDecimal (-90);
		
//		if (balance.subtract(amountToWithdraw).compareTo(test) {
//			balance.subtract(amountToWithdraw);
//		}
		
		balance1.subtract(balance2).compareTo(test);
		System.out.println(balance1);
		System.out.println(balance2);
		System.out.println(test);
	}
	
	

}
