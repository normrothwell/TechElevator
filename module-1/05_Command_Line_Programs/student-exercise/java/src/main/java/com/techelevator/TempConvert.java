package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		double temperature;
		
		System.out.println("Enter a Temperature: ");
		String temperatureStr = input.nextLine();
		temperature = Double.parseDouble(temperatureStr);
		System.out.println("Is this temperature in (C)elcius or (F)arenheit?: ");
		String temperatureType = input.nextLine();
		if((temperatureType.equals("F")) || (temperatureType.equals("f"))) {
			temperature = (temperature - 32) / 1.8;
			System.out.println("This Farenheit temperature is " + String.format("%.2f", temperature) + " in Celcius");
		}else if((temperatureType.equals("C")) || (temperatureType.equals("c"))) {
			temperature = (temperature * 1.8) + 32;
			System.out.println("This Celcius temperature is " + String.format("%.2f", temperature) + " in Farenheit");
		}else System.out.println("Please enter a valid temperature and temperature type");
	input.close();
	}
}