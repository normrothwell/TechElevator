package com.techelevator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Lecture {

	public static void main(String[] args) {
		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");
		
		List <String> animals = new ArrayList<>();  // declares an ArrayList called animals
		animals.add("Bats");  // will be in position 0
		animals.add("Cats");  // position 1
		animals.add("Elephants");
		animals.add("Dogs");
		animals.add("Frogs");
		animals.add("Hogs");   // position 5

		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");
		
		for (int i = 0; i < animals.size(); i++) {  // ArrayList uses .size() to return the length or size
			System.out.println(animals.get(i));
		}

		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");
		
		animals.add("Dogs");
		
		for (int i = 0; i < animals.size(); i++) {  
			System.out.println(animals.get(i));
		}
		

		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");
		
		animals.add(2, "Rats");
		
		for (int i = 0; i < animals.size(); i++) {  
			System.out.println(animals.get(i));
		}

		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");

		animals.remove(2);
		
		for (int i = 0; i < animals.size(); i++) {  
			System.out.println(animals.get(i));
		}
		
		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");
		
		if (animals.contains("Dogs")) {
			System.out.println("What a great list!");
		} 
		
		boolean containsRats = animals.contains("Rats");
		System.out.println("Rats in list: " + containsRats);
		
		int index = animals.indexOf("Dogs");
		System.out.println("Dogs is in the " + index + " position");
		
		index = animals.indexOf("Butterflies");
		System.out.println("Butterflies is in the " + index + " position");

		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");
		
		String[] animalsArray = animals.toArray(new String[animals.size()]);
		for (int i = 0; i < animalsArray.length; i++) {  
			System.out.println(animalsArray[i]);
		}

		System.out.println("####################");
		System.out.println(" PRIMITIVE WRAPPERS");
		System.out.println("####################");

		/* Every primitive data type has an equivalent "primitive wrapper class" that is an object representation
		 * of a primitive value */
		Integer employees = new Integer (25);  // this () - called the constructor
											   // "wrap" the primitive int 
											   // into an object
		Integer piecesOfCake = new Integer ("24"); // this constructor takes a
												   // String and converts it to 
												   // Integer

		System.out.println("####################");
		System.out.println("       FOREACH");
		System.out.println("####################");
		System.out.println();
		
		for (String animal: animals) {
			System.out.println(animal);
		}
		
		List <Integer> ages = new ArrayList<>(Arrays.asList(23, 34, 45, 24, 52, 28));
		
		for (Integer age: ages) {
			System.out.println(age);
		}

		System.out.println("####################");
		System.out.println("       QUEUES");
		System.out.println("####################");
		System.out.println();

		Queue <String> thingsToDo = new LinkedList<>();
		//we offer elements to our Queue -- we can use add, but it will throw an
		// exception if it cannot add.
		
		thingsToDo.offer("Read the book");
		thingsToDo.offer("Look over lecture notes");
		thingsToDo.offer("Look over lecture code");
		thingsToDo.offer("work on exercises");
		
		/////////////////////
		// PROCESSING ITEMS IN A QUEUE
		/////////////////////
		
		// to remove and print each item
		while (thingsToDo.size() > 0) {
			String job = thingsToDo.poll();  // or remove
			System.out.println("Next item: " + job);
		}
		
		System.out.println("####################");
		System.out.println("       STACKS");
		System.out.println("####################");
		System.out.println();

		Stack <String> editStack = new Stack<>();
		////////////////////
		// PUSHING ITEMS TO THE STACK
		////////////////////
		editStack.push("Remove typo on line 148");
		editStack.push("Bold words ITEMS on line 150");  // adds items in LIFO

		////////////////////
		// POPPING THE STACK
		////////////////////
		while (editStack.size() > 0) {
			String edit = editStack.pop();  // removes items in LIFO
			System.out.println("Previous edit: " + edit);
		}

	}
}
