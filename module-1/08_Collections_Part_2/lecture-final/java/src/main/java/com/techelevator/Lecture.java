package com.techelevator;

import java.util.HashMap;
import java.util.LinkedHashSet;
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

		myMap.put("Andorra", 42);
		myMap.put("James", 24);
		myMap.put("Seth", 7);
		myMap.put("Norm", 23);
		myMap.put("Kevin", 11);
		myMap.put("Margaret", 42);
		/* The "get" method is used to retrieve elements from a Map */
		System.out.println("Seth's favorite number is " +
		   myMap.get("Seth"));
		
		int favNumber = myMap.get("Norm");
		System.out.println("Norm's favorite number is " + 
		   favNumber);
		
		/* keySet returns a Set of all of the keys in the Map */
		Set<String> keys = myMap.keySet();
		
		System.out.println("\n*****  Printing all values *******\n");
		for (String name: keys) {
			System.out.println(name + "'s favorite number is " + 
				myMap.get(name));
		}
		/* If the key already exists, put will overwrite the existing value with the new value */
		myMap.put("Margaret", 13);
		
		System.out.println("Maggie's favorite number is " +
				myMap.get("Margaret"));

		System.out.println("####################");
		System.out.println("       SETS");
		System.out.println("####################");
		System.out.println();

		Set<String> names = new LinkedHashSet<>();

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
		
		names.add("Scott");  // this will be ignored
		
		System.out.println("####################");
		System.out.println("Sets do not guarantee ordering");
		System.out.println("####################");
		System.out.println();
		
		for (String name: names) {
			System.out.println(name + " Hash = " + 
					name.hashCode());
		}
		System.out.println(names.remove("Mike"));
		
		/*  regular Hash - unordered
		 * Mike Hash = 2398230
			Son Hash = 83314
			Casey Hash = 64879401
			Tim Hash = 84088
			Greg Hash = 2227949
			Scott Hash = 79711935
		 */
		/*  TreeSet -- put it in alpha order
		 * Casey Hash = 64879401
			Greg Hash = 2227949
			Mike Hash = 2398230
			Scott Hash = 79711935
			Son Hash = 83314
			Tim Hash = 84088
		 */
		/*  LinkedHash set keeps elements in order
		 * Scott Hash = 79711935
			Greg Hash = 2227949
			Casey Hash = 64879401
			Mike Hash = 2398230
			Son Hash = 83314
			Tim Hash = 84088
		 */


	}

}
