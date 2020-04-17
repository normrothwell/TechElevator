package com.techelevator;

public class Fraction {
	
	private int numerator;
	private int denominator;
	
	public Fraction(int numerator, int denominator) {
		int gcdAns = 0;
		if (numerator != 0 && denominator !=0) {
			gcdAns = gcd(numerator, denominator);
		}
		if (gcdAns > 1) {
			this.numerator = numerator/gcdAns;
			this.denominator = denominator/gcdAns;
		} else {
			this.numerator = numerator;
			this.denominator = denominator;
		}
	}
	
	@Override
	public String toString() {
		return numerator + "/" + denominator;
	}
	
	// We use static so we can pass in both Fractions
	// to multiply them, in the Test, we then call
	// this method by saying "Fraction.multiply()
	public static Fraction multiply(Fraction a, Fraction b) {
		int numerator = a.numerator * b.numerator;
		int denominator = a.denominator * b.denominator;
		Fraction answer = new Fraction (numerator, denominator);
		return answer;
	}
	
	@Override
	public boolean equals(Object o) {
		Fraction f = (Fraction)o;
		if (this.numerator == f.numerator &&
				this.denominator == f.denominator) {
			return true;
		}
		return false;
	}
	
	public static int gcd(int a, int b) {  // trust me - this works!
		a = Math.abs(a);  // no negatives!
		b = Math.abs(b);
		
		while (a != b) {
			if (a > b) {
				a = a - b;
			} else {
				b = b - a;
			}
		}
		return a;
	}
	

}
