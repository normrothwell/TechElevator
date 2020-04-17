package com.techelevator;

public class DogDemo {

	public static void main(String[] args) {
		Dog dog1=new Dog();
		dog1.setName("Penny");
		dog1.setCutenessFactor(11);
		dog1.setHas4Legs(true);
		System.out.println("The dog's name is: " + dog1.getName());
		System.out.println("The dog's cuteness factor is: " + dog1.getCutenessFactor());
		System.out.println("This dog has 4 legs: " + dog1.getHas4Legs());
		
		Dog dog2=new Dog();
		dog2.setName("Leila");
		dog2.setCutenessFactor(14);
		dog2.setHas4Legs(true);
		System.out.println("\nThe dog's name is: " + dog2.getName());
		System.out.println("The dog's cuteness facotr is: " + dog2.getCutenessFactor());
		System.out.println("This dog has 4 legs: " + dog2.getHas4Legs());

		Dog dog3=new Dog();
		System.out.println("\nThe dog's name is: " + dog3.getName());
		System.out.println("The dog's cuteness factor is: " + dog3.getCutenessFactor());
		System.out.println("This dog has 4 legs: " + dog3.getHas4Legs());
		
		Dog dog4=new Dog("Tripod"); //only pulls in the name and leaves other values at default
		System.out.println("\nThe dog's name is: " + dog4.getName());
		System.out.println("The dog's cuteness factor is: " + dog4.getCutenessFactor());
		System.out.println("This dog has 4 legs: " + dog4.getHas4Legs());
		dog4.printHowCute();
		
		Dog dog5=new Dog(true, 16, "Rosco"); //must be in same order as method
		System.out.println("\nThe dog's name is: " + dog5.getName());
		System.out.println("The dog's cuteness factor is: " + dog5.getCutenessFactor());
		System.out.println("This dog has 4 legs: " + dog5.getHas4Legs());
		dog5.printHowCute();
		
		
	}

}
