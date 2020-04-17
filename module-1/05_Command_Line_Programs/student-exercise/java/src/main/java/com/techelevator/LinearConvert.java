package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {

		
		Scanner input = new Scanner(System.in);
		
		double distance;
		
		System.out.println("Enter a Distance: ");
		String distanceStr = input.nextLine();
		distance = Double.parseDouble(distanceStr);
		System.out.println("Is this distance in (M)eters or (F)eet?: ");
		String distanceType = input.nextLine();
		if((distanceType.equals("F")) || (distanceType.equals("f"))) {
			distance = distance * 0.3048;
			System.out.println("This distance is " + String.format("%.2f", distance) + " in Meters");
		}else if((distanceType.equals("M")) || (distanceType.equals("m"))) {
			distance = distance * 3.2808399;
			System.out.println("This distance is " + String.format("%.2f", distance) + " in Feet");
		}else System.out.println("Please enter a valid distance and specify meters or feet");
		input.close();
	}

}
