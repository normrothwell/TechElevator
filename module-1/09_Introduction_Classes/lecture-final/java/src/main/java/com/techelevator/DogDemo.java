package com.techelevator;

public class DogDemo {

	public static void main(String[] args) {
		// create a Dog object
		Dog dog1 = new Dog();
		
		// set the values (data members) for that object
//		dog1.setName("Penny");
//		dog1.setCutenessFactor(10);
//		dog1.setHas4Legs(true);
		
		System.out.println("Dog name: " + dog1.getName() );
		System.out.println("Cuteness Factor: " + dog1.getCutenessFactor());
		System.out.println("Has 4 legs? " + dog1.getHas4Legs());
		
		Dog dog2 = new Dog();
		dog2.setName("Leila");
		dog2.setCutenessFactor(3);
		dog2.setHas4Legs(true);
		
		System.out.println("\nDog name: " + dog2.getName());
		System.out.println("Cuteness Factor: " + dog2.getCutenessFactor());
		System.out.println("Has 4 legs? " + dog2.getHas4Legs());
		dog2.printHowCute();  // calls the method printHowCute on dog2
		
		Dog dog3 = new Dog("Max");
		System.out.println("\nDog name: " + dog3.getName());
		System.out.println("Cuteness Factor: " + dog3.getCutenessFactor());
		System.out.println("Has 4 legs? " + dog3.getHas4Legs());
		
		Dog dog4 = new Dog(true, 7, "Fido"); // order matters
		// must match the order of the constructor
	}

}
