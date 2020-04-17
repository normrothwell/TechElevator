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
		
		List <String> animals = new ArrayList<>(Arrays.asList("Dog","Cat","Horse","Lizard","Butterfly"));
		animals.add("Penguin");
		animals.add(0,"Bat");
		
		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");

		for (int x = 0;x<animals.size();x++) {
			System.out.println(animals.get(x));
		}
		
		System.out.println("####################");
		System.out.println("Lists allow duplicates");

		animals.add("Dog");

		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");
		
		animals.add(2,"Rat");
		System.out.println();
		for (int x = 0;x<animals.size();x++) {
			System.out.println(animals.get(x));
		}

		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");

		animals.remove(0);
		System.out.println();
		for (int x = 0;x<animals.size();x++) {
			System.out.println(animals.get(x));
		}
		
		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");
		
		if (animals.contains("Dog")) {
			System.out.println("What a great list!");
		}
		
		boolean containsRats = animals.contains("Rat");
		System.out.println("Rat in List: " + containsRats);
		
		int index = animals.indexOf("Dog");
		System.out.println("Dog is in the " + index + " position"); //finds first instance only

		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");

		String[] animalsArray = animals.toArray(new String[animals.size()]);
		System.out.println();
		for (int x = 0;x<animalsArray.length;x++) {
			System.out.println(animalsArray[x]);
		}
		
		System.out.println("####################");
		System.out.println(" PRIMITIVE WRAPPERS");
		System.out.println("####################");
		

		/* Every primitive data type has an equivalent "primitive wrapper class" that is an object representation
		 * of a primitive value */

		Integer employees = new Integer (25); //this constructor turns the primiative int into an object
		Integer piecesOfCake = new Integer ("24"); //this constructor takes a String and converts it to an Integer
		
		
		System.out.println("####################");
		System.out.println("       FOREACH");
		System.out.println("####################");
		System.out.println();
		
		for (String x:animals) //for each String x in Animals in ArrayList animals
			System.out.println(x);
		
		List <Integer> ages = new ArrayList<>(Arrays.asList(23,34,45,24,52,28));
		for (Integer age:ages) {
			System.out.println(age);
		}

		System.out.println("####################");
		System.out.println("       QUEUES");
		System.out.println("####################");
		System.out.println();

		
		Queue <String> thingsToDo = new LinkedList<>(); //we offer elements to our Queues, add will cause an exception
		
		thingsToDo.offer("Read the book");
		thingsToDo.offer("Look over the lecture notes");
		thingsToDo.offer("Look over lecture code");
		thingsToDo.offer("work on exercises");
		
		
		/////////////////////
		// PROCESSING ITEMS IN A QUEUE
		/////////////////////

		while (thingsToDo.size() > 0) {
			String job = thingsToDo.poll(); //or remove (both do same thing)
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
		editStack.push("Bold words ITEMs on line 150");
		
		
		////////////////////
		// POPPING THE STACK
		////////////////////

		while (editStack.size()>0) {
			String edit = editStack.pop();
			System.out.println("Previous edit: " + edit);
		}
		
	}
}
