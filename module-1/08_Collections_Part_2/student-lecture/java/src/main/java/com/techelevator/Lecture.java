package com.techelevator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("####################");
		System.out.println("       MAPS");
		System.out.println("####################");
		System.out.println();

		/* Map is an interface and HashMap is a class that implements Map */
		
		Map <String, Integer> myMap = new HashMap<>();
		
		/* The "put" method is used to add elements to a Map */
		
		myMap.put("Lemieux", 66);
		myMap.put("Jagr", 68);
		myMap.put("Crosby", 87);
		myMap.put("Hornqvist", 72);
		myMap.put("Malkin", 71);
		
		/* The "get" method is used to retrieve elements from a Map */
	
		System.out.println("Crosby's number is " + myMap.get("Crosby"));
		int greatNumber = myMap.get("Lemieux"); //can also save value to a variable
		System.out.println("The greatest Penguin had number " + greatNumber);
		
		
		/* keySet returns a Set of all of the keys in the Map */
		
		Set<String> keys = myMap.keySet();
		for(String name: keys) {
			System.out.println(name + "'s number is " + myMap.get(name));
		}
		/* If the key already exists, put will overwrite the existing value with the new value */
		
		myMap.put("Hornqvist", 81); //replaces old value of Hornqvist with new value
		System.out.println("Hornqvist's new number is " + myMap.get("Hornqvist"));

		
		System.out.println("####################");
		System.out.println("       SETS");
		System.out.println("####################");
		System.out.println();

		Set<String> names = new HashSet<>();
		

		System.out.println("####################");
		System.out.println("Sets cannot contain duplicates");
		System.out.println("####################");
		System.out.println();

		names.add("Scott");
		names.add("Greg");
		names.add("Casey");
		names.add("Mike");
		names.add("Son");
		names.add("Tim");

		names.add("Scott"); //will ignore this as Scott already exists
		
		System.out.println("####################");
		System.out.println("Sets do not guarantee ordering");
		System.out.println("####################");
		System.out.println();

		for (String name: names) {
			System.out.println(name + " Hash is " + name.hashCode()); //always use hashCode regardless of set type
		}

	}

}
