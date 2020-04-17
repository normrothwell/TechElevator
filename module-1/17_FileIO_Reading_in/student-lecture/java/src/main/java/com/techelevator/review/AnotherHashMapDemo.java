package com.techelevator.review;

import java.util.HashMap;
import java.util.Map;

public class AnotherHashMapDemo {

	public static void main(String[] args) {
		
		Map<String,Double>countries = new HashMap<>();
		countries.put("Monaco",  0.78);
		countries.put("Grenada", 133.0);
		countries.put("Malta",  122.0);
		countries.put("Andorra", 181.0);
		countries.put("Dominica",  290.0);
		countries.put("Tonga", 288.0);
		countries.put("Lichtenstein", 162.0);
		
		for(Map.Entry<String, Double> entry: countries.entrySet()) {
			if (entry.getValue() >= 100.0 && entry.getValue() <= 200) {
				System.out.printf("%-30s	%6.2f\n", entry.getKey(), entry.getValue()); //left justify a string of 30 characters and right justify a double of 6 with 2 decimal places
			}
		}
		System.out.println("\nAll Countries\n");
		for (String listing: countries.keySet()) {
			System.out.println(listing + " " + countries.get(listing));
		}
	}

}
