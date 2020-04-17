package com.techelevator.TollBoothCalculator;

import java.util.ArrayList;
import java.util.List;

public class TollCalculator {

	public static void main(String[] args) {
	
		List <Vehicle> vehiclesOnTollway = new ArrayList <>();
		
		int totalMilesTraveled = 0;
		double tollboothRevenue = 0;
		
		Car focus = new Car(false);
		Car fusionWithTrailer = new Car(true);
		Truck fourAxel = new Truck(4);
		Truck sixAxel = new Truck(6);
		Truck bigTruckBoy = new Truck (10);
		Tank bigTankBoy = new Tank();
		
		
		vehiclesOnTollway.add(focus);
		vehiclesOnTollway.add(fusionWithTrailer);
		vehiclesOnTollway.add(fourAxel);
		vehiclesOnTollway.add(sixAxel);
		vehiclesOnTollway.add(bigTruckBoy);
		vehiclesOnTollway.add(bigTankBoy);
		
		for (int x = 0; x<vehiclesOnTollway.size();x++) {
			int temp = (int)(Math.random() *231)+9;
			System.out.println(vehiclesOnTollway.get(x).getType() + "\t" + temp + "\t$" + String.format("%.2f",vehiclesOnTollway.get(x).calculateToll(temp)));
			tollboothRevenue += vehiclesOnTollway.get(x).calculateToll(temp);
			totalMilesTraveled += temp;
			
		}
		
		System.out.println("\nTotal miles traveled: " + totalMilesTraveled);
		System.out.println("Tollbooth revenue = $" + String.format("%.2f", tollboothRevenue));

	}

}
