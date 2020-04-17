package com.techelevator;

public class KataFizzBuzz {
	
	
	public String fizzbuzz (int num) {
		String numString = Integer.toString(num);
		if (num == 0) {
			return "";
		}else if (((num%3 == 0) && (num%5 == 0)) || ((numString.contains("3") && numString.contains("5")))) {
			return "Fizzbuzz";
		}else if ((num%3 == 0) || (numString.contains("3"))) {
			return "Fizz";
		}else if ((num%5 == 0) || (numString.contains("5"))) {
			return "Buzz";
		}else return (Integer.toString(num));
	}
	
	
}
